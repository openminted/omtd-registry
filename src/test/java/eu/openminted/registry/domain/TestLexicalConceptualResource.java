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
public class TestLexicalConceptualResource {

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
		LexicalConceptualResource LexicalConceptualResource = createLexicalConceptualResource();

		System.out.println("Output:");
		marshaller.marshal(LexicalConceptualResource, System.out);
		System.out.println("EOF XML");
		StringWriter sw = new StringWriter();
		marshaller.marshal(LexicalConceptualResource, sw);
		
		Assert.assertEquals(true, isValidLexicalConceptualResourceXml(sw.toString()));
	}

	@Test
	public void compare1() throws JAXBException {
		LexicalConceptualResource LexicalConceptualResource = createLexicalConceptualResource();

		StringWriter sw = new StringWriter();
		marshaller.marshal(LexicalConceptualResource, sw);

		LexicalConceptualResource c2 = (LexicalConceptualResource) unmarshaller.unmarshal(new StringReader(sw.toString()));
		StringWriter sw2 = new StringWriter();
		marshaller.marshal(c2, sw2);

		Assert.assertEquals(sw.toString(), sw2.toString());
	}

	@Test
	public void testUnmarshal() throws JAXBException {
		LexicalConceptualResource LexicalConceptualResource = (LexicalConceptualResource) unmarshaller.unmarshal(new StringReader(LexicalConceptualResourceXml));

	}

	@Test
	public void compare2() throws JAXBException {
		LexicalConceptualResource LexicalConceptualResource = (LexicalConceptualResource) unmarshaller.unmarshal(new StringReader(LexicalConceptualResourceXml));
		StringWriter sw = new StringWriter();

		marshaller.marshal(LexicalConceptualResource, sw);
		
		System.out.println("compare2");
		System.out.println(sw.toString());
		System.out.println("EOF");
		
		Assert.assertEquals(LexicalConceptualResourceXml, sw.toString());
	}

	@Test
	public void testJson() throws IOException {
		LexicalConceptualResource LexicalConceptualResource = createLexicalConceptualResource();

		ObjectMapper mapper = new ObjectMapper();

		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		StringWriter sw = new StringWriter();

		mapper.writeValue(sw, LexicalConceptualResource);

		System.out.println(sw.toString());
	}

	private boolean isValidLexicalConceptualResourceXml(String xml) {
		Validator validator = Validator.forLanguage(Languages.W3C_XML_SCHEMA_NS_URI);

		validator.setSchemaSource(Input.fromURI("http://194.177.192.223/openminted/schema/OMTD-SHARE-LexicalConceptualResource.xsd").build());
		ValidationResult result = validator.validateInstance(new StreamSource( new StringReader(xml)));

		if (!result.isValid()) {
			for (ValidationProblem problem:result.getProblems()) {
				System.out.println(problem.getMessage());
			}
		}

		return result.isValid();
	}

	private LexicalConceptualResource createLexicalConceptualResource() {
		ObjectFactory of = new ObjectFactory();

		LexicalConceptualResource LexicalConceptualResource = of.createLexicalConceptualResource();

		LexicalConceptualResource.setMetadataHeaderInfo(new MetadataHeaderInfo());

		LexicalConceptualResource.getMetadataHeaderInfo().setMetadataCreationDate(new Date());

		LexicalConceptualResource.getMetadataHeaderInfo().setMetadataCreators(new ArrayList<>());
		LexicalConceptualResource.getMetadataHeaderInfo().getMetadataCreators().add(new RelatedPerson());
		LexicalConceptualResource.getMetadataHeaderInfo().getMetadataCreators().get(0).setPersonNames(Arrays.asList("Smith, John"));

		LexicalConceptualResource.getMetadataHeaderInfo().setRevision("1.23");
		LexicalConceptualResource.getMetadataHeaderInfo().setLanguages(new ArrayList<>());

		LexicalConceptualResource.getMetadataHeaderInfo().setSourceOfMetadataRecord(new SourceOfMetadataRecord());
		LexicalConceptualResource.getMetadataHeaderInfo().getSourceOfMetadataRecord().setCollectedFrom(new RelatedRepository());
		LexicalConceptualResource.getMetadataHeaderInfo().getSourceOfMetadataRecord().getCollectedFrom().setRepositoryNames(Arrays.asList("clarin:el"));
		LexicalConceptualResource.getMetadataHeaderInfo().getSourceOfMetadataRecord().setSourceMetadataLink("https://inventory.clarin.gr/resources/browse/ilsp-feature-based-multi-tiered-pos-tagger/9ff47a0e5af111e5a2e0aa3fc8d33ad8f8736d2c68654a37b471475f9f913baa/");


		LexicalConceptualResource.getMetadataHeaderInfo().setMetadataLastUpdated(new Date());

		LexicalConceptualResource.getMetadataHeaderInfo().setMetadataRecordIdentifier(new Identifier<>());
		LexicalConceptualResource.getMetadataHeaderInfo().getMetadataRecordIdentifier().setId("id");
		LexicalConceptualResource.getMetadataHeaderInfo().getMetadataRecordIdentifier().setSchema(MetadataHeaderInfo.MetadataIdentifierSchema.URL);
		LexicalConceptualResource.getMetadataHeaderInfo().getMetadataRecordIdentifier().setUrl("http://www.foo.gr");

		LexicalConceptualResource.setResourceIdentificationInfo(new ResourceIdentificationInfo());
		LexicalConceptualResource.getResourceIdentificationInfo().setResourceNames(Arrays.asList("ILSP Feature-based multi-tiered POS Tagger"));
		LexicalConceptualResource.getResourceIdentificationInfo().setDescriptions(Arrays.asList("FBT part-of-speech tagger for Greek texts."));
		LexicalConceptualResource.getResourceIdentificationInfo().setResourceShortNames(Arrays.asList("ilsp_fbt"));
		LexicalConceptualResource.getResourceIdentificationInfo().setResourceIdentifiers(Arrays.asList(new Identifier<ResourceIdentifierSchema>(ResourceIdentifierSchema.HDL, "http://hdl.grnet.gr/11500/ATHENA-0000-0000-23E8-3", null)));

		LexicalConceptualResource.setContactInfo(new ContactInfo());
		LexicalConceptualResource.getContactInfo().setContactEmail("prokopis@ilsp.gr");
		LexicalConceptualResource.getContactInfo().setContactPersons(Arrays.asList(new RelatedPerson()));
		LexicalConceptualResource.getContactInfo().getContactPersons().get(0).setPersonNames(Arrays.asList("Prokopidis, Prokopis"));

		

		
		LexicalConceptualResource.setDistributionInfos(Arrays.asList(new DatasetDistributionInfo()));
		LexicalConceptualResource.getDistributionInfos().get(0).setRightsInfo(new RightsInfo());
		LexicalConceptualResource.getDistributionInfos().get(0).getRightsInfo().setLicenseInfos(Arrays.asList(new LicenseInfo()));
		LexicalConceptualResource.getDistributionInfos().get(0).getRightsInfo().getLicenseInfos().get(0).setLicense(LicenseInfo.License.APACHE_LICENSE_2_0);

		return LexicalConceptualResource;
	}

	private static String LexicalConceptualResourceXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
			"<!--Sample XML file generated by XMLSpy v2013 sp1 (http://www.altova.com)-->\r\n" + 
			"<ms:lcrMetadataRecord xsi:schemaLocation=\"http://www.meta-share.org/OMTD-SHARE_XMLSchema OMTD-SHARE-LexicalConceptualResource.xsd\" xmlns:ms=\"http://www.meta-share.org/OMTD-SHARE_XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
			"	<ms:metadataHeaderInfo>\r\n" + 
			"		<ms:metadataRecordIdentifier metadataIdentifierSchemeName=\"other\" schemeURI=\"http://www.altova.com\">String</ms:metadataRecordIdentifier>\r\n" + 
			"		<ms:metadataCreationDate>2016-07-29</ms:metadataCreationDate>\r\n" + 
			"		<ms:metadataCreators>\r\n" + 
			"			<ms:metadataCreator>\r\n" + 
			"				<ms:personNames>\r\n" + 
			"					<ms:personName lang=\"en-us\">Smith, John</ms:personName>\r\n" + 
			"				</ms:personNames>\r\n" + 
			"			</ms:metadataCreator>\r\n" + 
			"		</ms:metadataCreators>\r\n" + 
			"		<ms:sourceOfMetadataRecord>\r\n" + 
			"			<ms:collectedFrom>\r\n" + 
			"				<ms:repositoryNames>\r\n" + 
			"					<ms:repositoryName lang=\"en-us\">META-SHARE</ms:repositoryName>\r\n" + 
			"				</ms:repositoryNames>\r\n" + 
			"			</ms:collectedFrom>\r\n" + 
			"			<ms:sourceMetadataLink>http://metashare.ilsp.gr:8080/repository/browse/catalan-parole-simple-lexinfo-lexicon/dee98446be2e11e28763000c291ecfc83001a2575569443895fe3a1ea4d71eb9/</ms:sourceMetadataLink>\r\n" + 
			"			<ms:relatedMetadataScheme>META-SHARE</ms:relatedMetadataScheme>\r\n" + 
			"			<ms:originalDataProviderInfo>\r\n" + 
			"				<ms:originalDataProviderType>repository</ms:originalDataProviderType>\r\n" + 
			"				<ms:originalDataProviderRepository>\r\n" + 
			"					<ms:repositoryNames>\r\n" + 
			"						<ms:repositoryName lang=\"en-us\">Spanish META-SHARE</ms:repositoryName>\r\n" + 
			"					</ms:repositoryNames>\r\n" + 
			"				</ms:originalDataProviderRepository>\r\n" + 
			"			</ms:originalDataProviderInfo>\r\n" + 
			"		</ms:sourceOfMetadataRecord>\r\n" + 
			"		<ms:metadataLanguages>\r\n" + 
			"			<ms:metadataLanguage>\r\n" + 
			"				<ms:languageTag>en-GB</ms:languageTag>\r\n" + 
			"			</ms:metadataLanguage>\r\n" + 
			"		</ms:metadataLanguages>\r\n" + 
			"		<ms:metadataLastDateUpdated>2016-07-24</ms:metadataLastDateUpdated>\r\n" + 
			"		<ms:revision>added a change</ms:revision>\r\n" + 
			"	</ms:metadataHeaderInfo>\r\n" + 
			"	<ms:lexicalConceptualResourceInfo>\r\n" + 
			"		<ms:resourceType>lexicalConceptualResource</ms:resourceType>\r\n" + 
			"		<ms:identificationInfo>\r\n" + 
			"			<ms:resourceNames>\r\n" + 
			"				<ms:resourceName lang=\"en-us\">Catalan PAROLE-SIMPLE LexInfo Lexicon</ms:resourceName>\r\n" + 
			"			</ms:resourceNames>\r\n" + 
			"			<ms:descriptions>\r\n" + 
			"				<ms:description lang=\"en-us\">The Catalan Parole/Simple 'lexinfo' Lexicon is the OWL version of the Spanish Parole and Simple lexicons (defined during the PAROLE LE2-4017 and SIMPLE LE4-8346 projects) once mapped to Lexinfo Model (\"http://lexinfo.net/\"). This data set has been published as Linked Open Data in the Data Hub (http://thedatahub.org/en/dataset/parole-simple-ont). The goal of SIMPLE project was to add semantic information, selected for its relevance for LE applications, to the set of harmonised multifunctional lexica built for 12 European languages by the PAROLE consortium. PAROLE +SIMPLE lexicons contain morphological, syntactic and semantic information, organised according to a common model and to common linguistic specifications. The Catalan The Catalan lexicon includes 20,545 entries annotated with syntactic information half of which are also annotated with semantic information.</ms:description>\r\n" + 
			"			</ms:descriptions>\r\n" + 
			"			<ms:resourceShortNames>\r\n" + 
			"				<ms:resourceShortName lang=\"en-us\">PAROLE-SIMPLE LexInfo Ontology</ms:resourceShortName>\r\n" + 
			"			</ms:resourceShortNames>\r\n" + 
			"			<ms:identifiers>\r\n" + 
			"				<ms:identifier resourceIdentifierSchemeName=\"url\">https://datahub.io/es/dataset/parole-simple-lexinfo-ontology-lexicons</ms:identifier>\r\n" + 
			"			</ms:identifiers>\r\n" + 
			"		</ms:identificationInfo>\r\n" + 
			"		<ms:contactInfo>\r\n" + 
			"			<ms:contactEmail>test@test.com</ms:contactEmail>\r\n" + 
			"			<ms:contactGroups>\r\n" + 
			"				<ms:contactGroup>\r\n" + 
			"					<ms:groupNames>\r\n" + 
			"						<ms:groupName>Developers of the lexicon</ms:groupName>\r\n" + 
			"					</ms:groupNames>\r\n" + 
			"					<ms:relatedOrganization>\r\n" + 
			"						<ms:organizationNames>\r\n" + 
			"							<ms:organizationName>IULA-UPF</ms:organizationName>\r\n" + 
			"						</ms:organizationNames>\r\n" + 
			"					</ms:relatedOrganization>\r\n" + 
			"				</ms:contactGroup>\r\n" + 
			"			</ms:contactGroups>\r\n" + 
			"		</ms:contactInfo>\r\n" + 
			"		<ms:versionInfo>\r\n" + 
			"			<ms:version>v1</ms:version>\r\n" + 
			"		</ms:versionInfo>\r\n" + 
			"		<ms:resourceCreationInfo>\r\n" + 
			"			<ms:fundingProjects>\r\n" + 
			"				<ms:fundingProject>\r\n" + 
			"					<ms:projectNames>\r\n" + 
			"						<ms:projectName lang=\"en-us\">SIMPLE</ms:projectName>\r\n" + 
			"					</ms:projectNames>\r\n" + 
			"				</ms:fundingProject>\r\n" + 
			"			</ms:fundingProjects>\r\n" + 
			"			<ms:creationDate>\r\n" + 
			"				<ms:dateRange>\r\n" + 
			"					<ms:startDate>\r\n" + 
			"						<ms:year>1996</ms:year>\r\n" + 
			"					</ms:startDate>\r\n" + 
			"					<ms:endDate>\r\n" + 
			"						<ms:year>2000</ms:year>\r\n" + 
			"					</ms:endDate>\r\n" + 
			"				</ms:dateRange>\r\n" + 
			"			</ms:creationDate>\r\n" + 
			"		</ms:resourceCreationInfo>\r\n" + 
			"				<ms:distributionInfos>\r\n" + 
			"			<ms:datasetDistributionInfo>\r\n" + 
			"				<ms:distributionMediums>\r\n" + 
			"					<ms:distributionMedium>downloadable</ms:distributionMedium>\r\n" + 
			"				</ms:distributionMediums>\r\n" + 
			"				<ms:downloadURLs>\r\n" + 
			"					<ms:downloadURL>www.download.es</ms:downloadURL>\r\n" + 
			"				</ms:downloadURLs>\r\n" + 
			"				<ms:textFormats>\r\n" + 
			"					<ms:textFormatInfo>\r\n" + 
			"						<ms:mimeType>text/turtle</ms:mimeType>\r\n" + 
			"					</ms:textFormatInfo>\r\n" + 
			"					<ms:textFormatInfo>\r\n" + 
			"						<ms:mimeType>application/rdf+xml</ms:mimeType>\r\n" + 
			"					</ms:textFormatInfo>\r\n" + 
			"				</ms:textFormats>\r\n" + 
			"				<ms:characterEncodings>\r\n" + 
			"					<ms:characterEncodingInfo>\r\n" + 
			"						<ms:characterEncoding>UTF-8</ms:characterEncoding>\r\n" + 
			"					</ms:characterEncodingInfo>\r\n" + 
			"				</ms:characterEncodings>\r\n" + 
			"				<ms:sizes>\r\n" + 
			"					<ms:sizeInfo>\r\n" + 
			"						<ms:size>20545</ms:size>\r\n" + 
			"						<ms:sizeUnit>entries</ms:sizeUnit>\r\n" + 
			"					</ms:sizeInfo>\r\n" + 
			"				</ms:sizes>\r\n" + 
			"				<ms:rightsInfo>\r\n" + 
			"					<ms:licenceInfos>\r\n" + 
			"						<ms:licenceInfo>\r\n" + 
			"							<ms:licence>CC-BY</ms:licence>\r\n" + 
			"							<ms:version>4.0</ms:version>\r\n" + 
			"						</ms:licenceInfo>\r\n" + 
			"					</ms:licenceInfos>\r\n" + 
			"				</ms:rightsInfo>\r\n" + 
			"				<ms:rightsHolders>\r\n" + 
			"					<ms:rightsHolder>\r\n" + 
			"						<ms:relatedOrganization>\r\n" + 
			"							<ms:organizationNames>\r\n" + 
			"								<ms:organizationName>IULA-UPF</ms:organizationName>\r\n" + 
			"							</ms:organizationNames>\r\n" + 
			"						</ms:relatedOrganization>\r\n" + 
			"					</ms:rightsHolder>\r\n" + 
			"				</ms:rightsHolders>\r\n" + 
			"			</ms:datasetDistributionInfo>\r\n" + 
			"		</ms:distributionInfos>\r\n" + 
			"		<ms:lexicalConceptualResourceType>ontology</ms:lexicalConceptualResourceType>\r\n" + 
			"		<ms:lexicalConceptualResourceEncodingInfo>\r\n" + 
			"			<ms:encodingLevel>morphology</ms:encodingLevel>\r\n" + 
			"			<ms:encodingLevel>semantics</ms:encodingLevel>\r\n" + 
			"			<ms:encodingLevel>syntax</ms:encodingLevel>\r\n" + 
			"			<ms:linguisticInformation>lemma</ms:linguisticInformation>\r\n" + 
			"			<ms:linguisticInformation>partOfSpeech</ms:linguisticInformation>\r\n" + 
			"			<ms:linguisticInformation>semantics-Relations</ms:linguisticInformation>\r\n" + 
			"			<ms:linguisticInformation>semantics-SemanticClass</ms:linguisticInformation>\r\n" + 
			"			<ms:linguisticInformation>semantics-Traits</ms:linguisticInformation>\r\n" + 
			"			<ms:linguisticInformation>syntax-SubcatFrame</ms:linguisticInformation>\r\n" + 
			"			<ms:linguisticInformation>usage-Examples</ms:linguisticInformation>\r\n" + 
			"			<ms:conformanceToStandardsBestPractices>RDF</ms:conformanceToStandardsBestPractices>\r\n" + 
			"			<ms:conformanceToStandardsBestPractices>OWL</ms:conformanceToStandardsBestPractices>\r\n" + 
			"			<ms:theoreticModel>Generative lexicon</ms:theoreticModel>\r\n" + 
			"		</ms:lexicalConceptualResourceEncodingInfo>\r\n" + 
			"		<ms:lexicalConceptualResourceMediaType>\r\n" + 
			"			<ms:lexicalConceptualResourceTextInfo>\r\n" + 
			"				<ms:mediaType>text</ms:mediaType>\r\n" + 
			"				<ms:lingualityInfo>\r\n" + 
			"					<ms:lingualityType>monolingual</ms:lingualityType>\r\n" + 
			"				</ms:lingualityInfo>\r\n" + 
			"				<ms:languages>\r\n" + 
			"					<ms:languageInfo>\r\n" + 
			"						<ms:language>\r\n" + 
			"							<ms:languageTag>ca</ms:languageTag>\r\n" + 
			"						</ms:language>\r\n" + 
			"					</ms:languageInfo>\r\n" + 
			"				</ms:languages>\r\n" + 
			"				<ms:sizes>\r\n" + 
			"					<ms:sizeInfo>\r\n" + 
			"						<ms:size>20545</ms:size>\r\n" + 
			"						<ms:sizeUnit>entries</ms:sizeUnit>\r\n" + 
			"					</ms:sizeInfo>\r\n" + 
			"				</ms:sizes>\r\n" + 
			"			</ms:lexicalConceptualResourceTextInfo>\r\n" + 
			"		</ms:lexicalConceptualResourceMediaType>\r\n" + 
			"	</ms:lexicalConceptualResourceInfo>\r\n" + 
			"</ms:lcrMetadataRecord>";
}
