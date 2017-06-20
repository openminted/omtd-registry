package eu.openminted.registry.generate;

import eu.openminted.registry.domain.*;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
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

    static public MetadataHeaderInfo generate() throws DatatypeConfigurationException {
        MetadataHeaderInfo info = new MetadataHeaderInfo();

        //
        // Set creation date and last date updated
        //
        GregorianCalendar gregory = new GregorianCalendar();
        gregory.setTime(new Date());
        XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
        info.setMetadataCreationDate(calendar);
        info.setMetadataLastDateUpdated(calendar);

        //
        // Set metadata record identifier
        //
        MetadataIdentifier identifier = new MetadataIdentifier();
        identifier.setValue(UUID.randomUUID().toString());
        identifier.setMetadataIdentifierSchemeName(MetadataIdentifierSchemeNameEnum.OTHER);
        info.setMetadataRecordIdentifier(identifier);

        //
        // Set metadata creator
        //
        //TODO check if anonymous user
        OIDCAuthenticationToken authentication = (OIDCAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        PersonInfo personInfo = new PersonInfo();
        Name name = new Name();
        name.setValue(authentication.getName());
        name.setLang("en");
        personInfo.getNames().add(name);

        PersonIdentifier personIdentifier = new PersonIdentifier();
        personIdentifier.setValue(authentication.getSub());
        personIdentifier.setPersonIdentifierSchemeName(PersonIdentifierSchemeNameEnum.OTHER);
        personInfo.getPersonIdentifiers().add(personIdentifier);

        info.getMetadataCreators().add(personInfo);
        return info;
    }
}
