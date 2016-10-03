package eu.openminted.registry.domain;

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

import java.io.StringReader;
import java.io.StringWriter;

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
	public void testUnmarshal() throws JAXBException {
		Component component = (Component) unmarshaller.unmarshal(new StringReader(componentXml));
		StringWriter sw = new StringWriter();
		System.out.println(componentXml);
		System.out.println("MARSHALED");
		marshaller.marshal(component, sw);
		
		Assert.assertEquals("ms776482", component.getMetadataHeaderInfo().getMetadataRecordIdentifier().getId());
		Assert.assertEquals(ComponentDistributionInfo.OperatingSystem.OS_INDEPENDENT, component.getDistributionInfos().get(0).getOperatingSystem());
		Assert.assertTrue(isValidComponentXml(sw.toString()));
	}

//	@Test
	public void compare2() throws JAXBException {
		Component component = (Component) unmarshaller.unmarshal(new StringReader(componentXml));
		StringWriter sw = new StringWriter();

		marshaller.marshal(component, sw);

		Assert.assertEquals(componentXml, sw.toString());
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
