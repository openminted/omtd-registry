package eu.openminted.registry.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.builder.Input;
import org.xmlunit.diff.Comparison;
import org.xmlunit.diff.ComparisonListener;
import org.xmlunit.diff.ComparisonResult;
import org.xmlunit.diff.ComparisonType;
import org.xmlunit.diff.Diff;
import org.xmlunit.validation.Languages;
import org.xmlunit.validation.ValidationProblem;
import org.xmlunit.validation.ValidationResult;
import org.xmlunit.validation.Validator;

import com.googlecode.junittoolbox.ParallelParameterized;

@RunWith(ParallelParameterized.class)
public class TestLanguageDescription {

	@Parameters(name="{0}")
	public static Collection<Object[]> data() {
		File folder = new File("src/test/resources/languageDescription/active");
		File[] listOfFiles = folder.listFiles();
		Collection<Object[]> ret = new ArrayList<Object[]>();
		for(File f : listOfFiles) {
			ret.add(new Object[]{f});
		}
		return ret;
	}
	
	private static List<Marshaller> marshaller = new ArrayList<Marshaller>();
	private static List<Unmarshaller> unmarshaller = new ArrayList<Unmarshaller>();;
	private static List<JAXBContext> jc = new ArrayList<JAXBContext>();
	private static int numThreads = 0;
	private File testXML;
	private static List<Validator> validator = new ArrayList<Validator>();;
	
	public TestLanguageDescription(File testXML) {
		this.testXML = testXML;
	}
	
	@BeforeClass
	public static void before() throws JAXBException {
		String threads = System.getProperty("junit.parallel.threads", "8");
        numThreads = Integer.parseInt(threads);
        for (int i = 0; i < numThreads; ++i) {
        	JAXBContext jcc = JAXBContext.newInstance(ObjectFactory.class);
        	jc.add(jcc);
        	marshaller.add(jcc.createMarshaller());
        	unmarshaller.add(jcc.createUnmarshaller());
        	marshaller.get(i).setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        	validator.add(Validator.forLanguage(Languages.W3C_XML_SCHEMA_NS_URI));
        	validator.get(i).setSchemaSource(Input.fromFile("src/main/xsd/OMTD-SHARE-LanguageDescription.xsd").build());
        }
	}
	
	@Test
	public void test() throws JAXBException, FileNotFoundException {
		int id = (int) Thread.currentThread().getId() % numThreads;
		BufferedReader in = new BufferedReader(new FileReader(testXML));
		LanguageDescription languageDescrption = (LanguageDescription) unmarshaller.get(id).unmarshal(in);

		
		StringWriter sw = new StringWriter();
		marshaller.get(id).marshal(languageDescrption, sw);
		
		Source original = Input.fromFile(testXML).build();
		Source marshaled = Input.fromJaxb(languageDescrption).build();
		ComparisonListener compList = new ComparisonListener() {

			@Override
			public void comparisonPerformed(Comparison comparison,
					ComparisonResult outcome) {
				if(comparison.getType() != ComparisonType.NAMESPACE_PREFIX && comparison.getType() != ComparisonType.SCHEMA_LOCATION)
				System.out.println("@" + testXML.getName() + " found a difference: "
						+ comparison);

			}
		};

		Diff diff = DiffBuilder.compare(original)
				.ignoreComments().checkForSimilar().ignoreWhitespace().normalizeWhitespace()
				.withTest(marshaled)
				.withDifferenceListeners(compList).build();

		boolean isValid = isValidLanguageDescriptionResourceXml(sw.toString());
		if(diff.hasDifferences() || !isValid) {
			System.out.println("Output File : " + testXML.toString());
			marshaller.get(id).marshal(languageDescrption, System.out);
			System.out.println("EOF XML");
		}
		
		Assert.assertEquals(true, isValid);
		Assert.assertFalse(diff.toString(), diff.hasDifferences());
		
		
		
	}
	
	private boolean isValidLanguageDescriptionResourceXml(String xml) {
		ValidationResult result = validator.get((int) Thread.currentThread().getId() % numThreads).validateInstance(new StreamSource( new StringReader(xml)));

		if (!result.isValid()) {
			for (ValidationProblem problem:result.getProblems()) {
				System.out.println(problem.getMessage());
			}
		}

		return result.isValid();
	}
	

}
