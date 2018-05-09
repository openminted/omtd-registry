package eu.openminted.registry.generate;

import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.*;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * Created by stefanos on 16/6/2017.
 */
public class MetadataHeaderInfoGenerate {

    private static final String SCOPE_AFFILIATION = "edu_person_scoped_affiliations";

    private static Logger logger = LoggerFactory.getLogger(MetadataHeaderInfoGenerate.class);

    static public MetadataHeaderInfo generate(MetadataHeaderInfo info) {
        if (info == null) {
            info = new MetadataHeaderInfo();
        }

        //
        // Set creation date and last date updated
        //
        GregorianCalendar gregory = new GregorianCalendar();
        gregory.setTime(new Date());
        XMLGregorianCalendar calendar = null;
        try {
            calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        logger.info(info.getMetadataCreationDate().toString());
        if(info.getMetadataCreationDate() == null){
            info.setMetadataCreationDate(calendar);
        }
        info.setMetadataLastDateUpdated(calendar);

        //
        // Set metadata record identifier
        //
        if (info.getMetadataRecordIdentifier() == null) {
            MetadataIdentifier identifier = new MetadataIdentifier();
            identifier.setValue(UUID.randomUUID().toString());
            identifier.setMetadataIdentifierSchemeName(MetadataIdentifierSchemeNameEnum.OMTD);
            info.setMetadataRecordIdentifier(identifier);
        }

        //
        // Set metadata creator
        //

        OIDCAuthenticationToken authentication;
        try {
            authentication = (OIDCAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        } catch (ClassCastException e) {
            throw new ServiceException("User is not authenticated in order to generate metadata");
        }

        info.getMetadataCreators()
                .removeIf(person -> person.getPersonIdentifiers().get(0).getValue().equals(authentication.getSub()));


        PersonInfo personInfo = new PersonInfo();
        personInfo.setGivenName(authentication.getUserInfo().getGivenName());
        personInfo.setSurname(authentication.getUserInfo().getFamilyName());

        PersonIdentifier personIdentifier = new PersonIdentifier();
        personIdentifier.setValue(authentication.getSub());
        personIdentifier.setPersonIdentifierSchemeName(PersonIdentifierSchemeNameEnum.OTHER);
        personInfo.getPersonIdentifiers().add(personIdentifier);

        //
        // Set affiliations
        //
        authentication.getUserInfo().getSource().getAsJsonArray(SCOPE_AFFILIATION).forEach(af -> {
            String[] organizationPosition = af.getAsString().split("@");
            if (organizationPosition.length == 2) {
                Affiliation affiliation = new Affiliation();
                OrganizationInfo organizationInfo = new OrganizationInfo();
                OrganizationName organizationName = new OrganizationName();
                organizationName.setValue(organizationPosition[1]);
                organizationInfo.getOrganizationNames().add(organizationName);
                affiliation.setAffiliatedOrganization(organizationInfo);
                affiliation.setPosition(organizationPosition[0]);
                personInfo.setAffiliation(affiliation);
            } else {
                logger.warn("The provided affiliation was not in position@organization format");
            }
        });

        //
        // Set communication info
        //
        CommunicationInfo communicationInfo = new CommunicationInfo();
        communicationInfo.getEmails().add(authentication.getUserInfo().getEmail());
        personInfo.setCommunicationInfo(communicationInfo);


        {
            info.getMetadataCreators().add(personInfo);
        }

        return info;
    }
}
