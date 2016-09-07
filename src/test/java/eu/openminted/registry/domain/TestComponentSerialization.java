package eu.openminted.registry.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xmlunit.builder.Input;
import org.xmlunit.validation.Languages;
import org.xmlunit.validation.ValidationProblem;
import org.xmlunit.validation.ValidationResult;
import org.xmlunit.validation.Validator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by antleb on 9/6/16.
 */
public class TestComponentSerialization {

	private static Marshaller marshaller;
	private static Unmarshaller unmarshaller;

	@BeforeClass
	public static void init() throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(ObjectFactory.class);

		marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		unmarshaller = jc.createUnmarshaller();
	}

	@Test
	public void serialize() throws JAXBException {
		Component component = createComponent();

		System.out.println("Output:");
		marshaller.marshal(component, System.out);

		StringWriter sw = new StringWriter();
		marshaller.marshal(component, sw);

		Assert.assertEquals(true, isValidComponentXml(sw.toString()));
	}

	@Test
	public void compare() throws JAXBException {
		Component component = createComponent();

		StringWriter sw = new StringWriter();
		marshaller.marshal(component, sw);

		Component c2 = (Component) unmarshaller.unmarshal(new StringReader(sw.toString()));
		StringWriter sw2 = new StringWriter();
		marshaller.marshal(c2, sw2);

		Assert.assertEquals(sw.toString(), sw2.toString());
	}

	@Test
	public void testUnmarshal() throws JAXBException {
		Component component = (Component) unmarshaller.unmarshal(new StringReader(componentXml));

		Assert.assertEquals("ms776482", component.getMetadataHeaderInfo().getMetadataRecordIdentifier().getId());
	}

	@Test
	public void testJson() throws IOException {
		Component component = createComponent();

		ObjectMapper mapper = new ObjectMapper();

		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		StringWriter sw = new StringWriter();

		mapper.writeValue(sw, component);

		System.out.println(sw.toString());
	}
	private boolean isValidComponentXml(String xml) {
		Validator validator = Validator.forLanguage(Languages.W3C_XML_SCHEMA_NS_URI);

		validator.setSchemaSource(Input.fromURI("http://194.177.192.223/openminted/schema/OMTD-SHARE-Component.xsd").build());
		ValidationResult result = validator.validateInstance(new StreamSource( new StringReader(xml)));

		if (!result.isValid()) {
			for (ValidationProblem problem:result.getProblems()) {
				System.out.println(problem.getMessage());
			}
		}

		return result.isValid();
	}

	private Component createComponent() {
		ObjectFactory of = new ObjectFactory();

		Component component = of.createComponent();

		component.setMetadataHeaderInfo(of.createMetadataHeaderInfo());

		component.getMetadataHeaderInfo().setMetadataCreationDate(new Date());

		component.getMetadataHeaderInfo().setMetadataCreators(new ArrayList<>());
		component.getMetadataHeaderInfo().getMetadataCreators().add(new RelatedPerson());
		component.getMetadataHeaderInfo().getMetadataCreators().get(0).setPersonNames(Arrays.asList("Smith, John"));

		component.getMetadataHeaderInfo().setRevision("1.23");
		component.getMetadataHeaderInfo().setLanguages(new ArrayList<>());

		component.getMetadataHeaderInfo().setSourceOfMetadataRecord(new SourceOfMetadataRecord());
		component.getMetadataHeaderInfo().getSourceOfMetadataRecord().setCollectedFrom(new RelatedRepository());
		component.getMetadataHeaderInfo().getSourceOfMetadataRecord().getCollectedFrom().setRepositoryNames(Arrays.asList("clarin:el"));
		component.getMetadataHeaderInfo().getSourceOfMetadataRecord().setSourceMetadataLink("https://inventory.clarin.gr/resources/browse/ilsp-feature-based-multi-tiered-pos-tagger/9ff47a0e5af111e5a2e0aa3fc8d33ad8f8736d2c68654a37b471475f9f913baa/");


		component.getMetadataHeaderInfo().setMetadataLastUpdated(new Date());

		component.getMetadataHeaderInfo().setMetadataRecordIdentifier(of.createIdentifier());
		component.getMetadataHeaderInfo().getMetadataRecordIdentifier().setId("id");
		component.getMetadataHeaderInfo().getMetadataRecordIdentifier().setSchema(MetadataHeaderInfo.MetadataIdentifierSchema.URL);
		component.getMetadataHeaderInfo().getMetadataRecordIdentifier().setUrl("http://www.foo.gr");

		component.setResourceIdentificationInfo(of.createResourceIdentificationInfo());
		component.getResourceIdentificationInfo().setResourceNames(Arrays.asList("ILSP Feature-based multi-tiered POS Tagger"));
		component.getResourceIdentificationInfo().setDescriptions(Arrays.asList("FBT part-of-speech tagger for Greek texts."));
		component.getResourceIdentificationInfo().setResourceShortNames(Arrays.asList("ilsp_fbt"));
		component.getResourceIdentificationInfo().setResourceIdentifiers(Arrays.asList(new Identifier<ResourceIdentifierSchema>(ResourceIdentifierSchema.HDL, "http://hdl.grnet.gr/11500/ATHENA-0000-0000-23E8-3", null)));

		component.setContactInfo(new ContactInfo());
		component.getContactInfo().setContactEmail("prokopis@ilsp.gr");
		component.getContactInfo().setContactPersons(Arrays.asList(new RelatedPerson()));
		component.getContactInfo().getContactPersons().get(0).setPersonNames(Arrays.asList("Prokopidis, Prokopis"));

		component.setComponentTypes(new ArrayList<>());
		component.getComponentTypes().add("morphologicalTagger");

		component.setDistributionInfos(Arrays.asList(new ComponentDistributionInfo()));
		component.getDistributionInfos().get(0).setComponentDistributionMedium(ComponentDistributionInfo.ComponentDistributionMedium.WEB_SERVICE);
		component.getDistributionInfos().get(0).setRightsInfo(new RightsInfo());
		component.getDistributionInfos().get(0).getRightsInfo().setLicenseInfos(Arrays.asList(new LicenseInfo()));
		component.getDistributionInfos().get(0).getRightsInfo().getLicenseInfos().get(0).setLicense(LicenseInfo.License.APACHE_LICENSE_2_0);

		return component;
	}

	private static String componentXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<componentMetadataRecord xmlns=\"http://www.meta-share.org/OMTD-SHARE_XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.meta-share.org/OMTD-SHARE_XMLSchema http://omtd.net16.net/schemas/OMTD-SHAREv1XSD/OMTD-SHARE-Component.xsd\">\n" +
			"  <metadataHeaderInfo>\n" +
			"    <metadataRecordIdentifier metadataIdentifierSchemeName=\"other\">ms776482</metadataRecordIdentifier>\n" +
			"    <metadataCreationDate>2012-07-12</metadataCreationDate>\n" +
			"    <metadataCreators>\n" +
			"      <metadataCreator>\n" +
			"        <personNames>\n" +
			"          <personName lang=\"und\">Ștefănescu Dan</personName>\n" +
			"        </personNames>\n" +
			"      </metadataCreator>\n" +
			"    </metadataCreators>\n" +
			"    <metadataLastDateUpdated>2013-02-01</metadataLastDateUpdated>\n" +
			"  </metadataHeaderInfo>\n" +
			"  <componentInfo>\n" +
			"    <resourceType>component</resourceType>\n" +
			"    <identificationInfo>\n" +
			"      <resourceNames>\n" +
			"        <resourceName lang=\"eng\">Lexical Chains Finder</resourceName>\n" +
			"      </resourceNames>\n" +
			"      <descriptions>\n" +
			"        <description lang=\"eng\">REST Web Service for finding Lexical Chains using the Princeton WordNet structure</description>\n" +
			"      </descriptions>\n" +
			"      <resourceShortNames>\n" +
			"        <resourceShortName lang=\"eng\">LexChains</resourceShortName>\n" +
			"      </resourceShortNames>\n" +
			"      <identifiers>\n" +
			"        <identifier resourceIdentifierSchemeName=\"other\">776482</identifier>\n" +
			"        <identifier resourceIdentifierSchemeName=\"other\">LexChains</identifier>\n" +
			"      </identifiers>\n" +
			"    </identificationInfo>\n" +
			"    <contactInfo>\n" +
			"      <contactEmail/>\n" +
			"      <contactPersons>\n" +
			"        <contactPerson>\n" +
			"          <personNames>\n" +
			"            <personName lang=\"und\">Tufiș Dan</personName>\n" +
			"          </personNames>\n" +
			"        </contactPerson>\n" +
			"      </contactPersons>\n" +
			"    </contactInfo>\n" +
			"    <versionInfo>\n" +
			"      <version>2.0</version>\n" +
			"    </versionInfo>\n" +
			"    <validationInfos/>\n" +
			"    <componentTypes>\n" +
			"      <componentType>other</componentType>\n" +
			"      <componentType>other</componentType>\n" +
			"    </componentTypes>\n" +
			"    <distributionInfos>\n" +
			"      <componentDistributionInfo>\n" +
			"        <componentDistributionMedium>executableCode</componentDistributionMedium>\n" +
			"        <accessURLs>\n" +
			"          <accessURL>http://khufu.racai.ro:8001/lexchains.ashx</accessURL>\n" +
			"        </accessURLs>\n" +
			"        <operatingSystem>os-independent</operatingSystem>\n" +
			"        <rightsInfo>\n" +
			"          <licenceInfos>\n" +
			"            <licenceInfo>\n" +
			"              <licence>nonStandardLicenceTerms</licence>\n" +
			"              <conditionsOfUse>informLicensor</conditionsOfUse>\n" +
			"              <conditionsOfUse>noRedistribution</conditionsOfUse>\n" +
			"            </licenceInfo>\n" +
			"          </licenceInfos>\n" +
			"        </rightsInfo>\n" +
			"        <attributionTexts>\n" +
			"          <attributionText lang=\"eng\">Please cite this paper: 'Ion, R., Ştefănescu, D. (2011). Unsupervised Word Sense Disambiguation with Lexical Chains and Graph-Based Context Formalization. In Zygmunt Vetulani (ed.): LTC 2009, Lecture Notes in Artificial Intelligence, Volume 6562/2011, pp. 435—443, Springer, Heidelberg'</attributionText>\n" +
			"        </attributionTexts>\n" +
			"        <rightsHolders>\n" +
			"          <rightsHolder>\n" +
			"            <relatedPerson>\n" +
			"              <personNames>\n" +
			"                <personName lang=\"und\">Ștefănescu</personName>\n" +
			"              </personNames>\n" +
			"            </relatedPerson>\n" +
			"          </rightsHolder>\n" +
			"        </rightsHolders>\n" +
			"        <userTypes>\n" +
			"          <userType>academic</userType>\n" +
			"          <userType>commercial</userType>\n" +
			"        </userTypes>\n" +
			"      </componentDistributionInfo>\n" +
			"    </distributionInfos>\n" +
			"    <inputContentResourceInfo>\n" +
			"      <resourceTypes/>\n" +
			"      <mediaType>text</mediaType>\n" +
			"      <languages>\n" +
			"        <language>\n" +
			"          <languageTag>en</languageTag>\n" +
			"          <languageId>en</languageId>\n" +
			"        </language>\n" +
			"      </languages>\n" +
			"      <dataFormats/>\n" +
			"      <annotationLevels/>\n" +
			"      <modalityTypes>\n" +
			"        <modalityType>writtenLanguage</modalityType>\n" +
			"      </modalityTypes>\n" +
			"    </inputContentResourceInfo>\n" +
			"    <outputResourceInfo>\n" +
			"      <resourceTypes>\n" +
			"        <resourceType>corpus</resourceType>\n" +
			"      </resourceTypes>\n" +
			"      <mediaType>text</mediaType>\n" +
			"      <dataFormats/>\n" +
			"      <annotationLevels/>\n" +
			"      <modalityTypes>\n" +
			"        <modalityType>writtenLanguage</modalityType>\n" +
			"      </modalityTypes>\n" +
			"    </outputResourceInfo>\n" +
			"  </componentInfo>\n" +
			"</componentMetadataRecord>\n";
}
