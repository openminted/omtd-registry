
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for null.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;maxLength value="100"/&gt;
 *     &lt;enumeration value="accessComponent"/&gt;
 *     &lt;enumeration value="reader"/&gt;
 *     &lt;enumeration value="writer"/&gt;
 *     &lt;enumeration value="supportComponent"/&gt;
 *     &lt;enumeration value="visualiser"/&gt;
 *     &lt;enumeration value="debugger"/&gt;
 *     &lt;enumeration value="validator"/&gt;
 *     &lt;enumeration value="viewer"/&gt;
 *     &lt;enumeration value="corpusViewer"/&gt;
 *     &lt;enumeration value="lexiconViewer"/&gt;
 *     &lt;enumeration value="editor"/&gt;
 *     &lt;enumeration value="mlTrainer"/&gt;
 *     &lt;enumeration value="mlPredictor"/&gt;
 *     &lt;enumeration value="featureExtractor"/&gt;
 *     &lt;enumeration value="dataSplitter"/&gt;
 *     &lt;enumeration value="dataMerger"/&gt;
 *     &lt;enumeration value="converter"/&gt;
 *     &lt;enumeration value="evaluator"/&gt;
 *     &lt;enumeration value="flowController"/&gt;
 *     &lt;enumeration value="scriptBasedAnalyser"/&gt;
 *     &lt;enumeration value="matcher"/&gt;
 *     &lt;enumeration value="gazeteerBasedMatcher"/&gt;
 *     &lt;enumeration value="crowdSourcingComponent"/&gt;
 *     &lt;enumeration value="dataCollector"/&gt;
 *     &lt;enumeration value="crawler"/&gt;
 *     &lt;enumeration value="processor"/&gt;
 *     &lt;enumeration value="annotator"/&gt;
 *     &lt;enumeration value="segmenter"/&gt;
 *     &lt;enumeration value="stemmer"/&gt;
 *     &lt;enumeration value="lemmatizer"/&gt;
 *     &lt;enumeration value="morphologicalTagger"/&gt;
 *     &lt;enumeration value="chunker"/&gt;
 *     &lt;enumeration value="parser"/&gt;
 *     &lt;enumeration value="coreferenceAnnotator"/&gt;
 *     &lt;enumeration value="namedEntityRecognizer"/&gt;
 *     &lt;enumeration value="semanticsAnnotator"/&gt;
 *     &lt;enumeration value="srlAnnotator"/&gt;
 *     &lt;enumeration value="readabilityAnnotator"/&gt;
 *     &lt;enumeration value="aligner"/&gt;
 *     &lt;enumeration value="generator"/&gt;
 *     &lt;enumeration value="summarizer"/&gt;
 *     &lt;enumeration value="simplifier"/&gt;
 *     &lt;enumeration value="preOrPostProcessingComponent"/&gt;
 *     &lt;enumeration value="spellingChecker"/&gt;
 *     &lt;enumeration value="grammarChecker"/&gt;
 *     &lt;enumeration value="normalizer"/&gt;
 *     &lt;enumeration value="filters"/&gt;
 *     &lt;enumeration value="analyzer"/&gt;
 *     &lt;enumeration value="topicExtractor"/&gt;
 *     &lt;enumeration value="documentClassifier"/&gt;
 *     &lt;enumeration value="languageIdentifier"/&gt;
 *     &lt;enumeration value="sentimentAnalyzer"/&gt;
 *     &lt;enumeration value="keywordsExtractor"/&gt;
 *     &lt;enumeration value="termExtractor"/&gt;
 *     &lt;enumeration value="contradictionDetector"/&gt;
 *     &lt;enumeration value="eventExtractor"/&gt;
 *     &lt;enumeration value="persuasiveExpressionMiner"/&gt;
 *     &lt;enumeration value="informationExtractor"/&gt;
 *     &lt;enumeration value="lexiconExtractorFromCorpora"/&gt;
 *     &lt;enumeration value="lexiconExtractorFromLexica"/&gt;
 *     &lt;enumeration value="wordSenseDisambiguator"/&gt;
 *     &lt;enumeration value="qualitativeAnalyzer"/&gt;
 *     &lt;enumeration value="platform"/&gt;
 *     &lt;enumeration value="infrastructure"/&gt;
 *     &lt;enumeration value="architecture"/&gt;
 *     &lt;enumeration value="nlpDevelopmentEnvironment"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum ComponentTypeEnum {

    @XmlEnumValue("accessComponent")
    ACCESS_COMPONENT("accessComponent"),

    /**
     * A component that reads content of various types (pdf, txt, xml etc.)
     * 
     */
    @XmlEnumValue("reader")
    READER("reader"),

    /**
     * A component that writes processing results in various formats
     * 
     */
    @XmlEnumValue("writer")
    WRITER("writer"),

    /**
     * A component that provides support tos developers
     * 
     */
    @XmlEnumValue("supportComponent")
    SUPPORT_COMPONENT("supportComponent"),

    /**
     * A component or interface that renders the contents of a resource in a graphic way for visualisation purposes
     * 
     */
    @XmlEnumValue("visualiser")
    VISUALISER("visualiser"),

    /**
     * A component that helps in the debugging process
     * 
     */
    @XmlEnumValue("debugger")
    DEBUGGER("debugger"),

    /**
     * A component used to confirm that a system/resource meets the specifications and fulfills its intended purpose
     * 
     */
    @XmlEnumValue("validator")
    VALIDATOR("validator"),

    /**
     * A component that provides access to the contents of a resource but intended only for access by humans
     * 
     */
    @XmlEnumValue("viewer")
    VIEWER("viewer"),

    /**
     * A component that provides access to the contents of a corpus but intended only for access by humans
     * 
     */
    @XmlEnumValue("corpusViewer")
    CORPUS_VIEWER("corpusViewer"),

    /**
     * A component that provides access to the contents of a lexical/conceptual resoruces but intended only for access by humans
     * 
     */
    @XmlEnumValue("lexiconViewer")
    LEXICON_VIEWER("lexiconViewer"),

    /**
     * A component that allows humans to edit the contents of a resource
     * 
     */
    @XmlEnumValue("editor")
    EDITOR("editor"),

    /**
     * A component that is used in training models for machine learning
     * 
     */
    @XmlEnumValue("mlTrainer")
    ML_TRAINER("mlTrainer"),

    /**
     * A component that is used in predicting based on machine learning models
     * 
     */
    @XmlEnumValue("mlPredictor")
    ML_PREDICTOR("mlPredictor"),

    /**
     * A component that is used for extracting features
     * 
     */
    @XmlEnumValue("featureExtractor")
    FEATURE_EXTRACTOR("featureExtractor"),

    /**
     * A component that performs data splitting for cross validation purposes
     * 
     */
    @XmlEnumValue("dataSplitter")
    DATA_SPLITTER("dataSplitter"),

    /**
     * A component that supports data merging from various sources
     * 
     */
    @XmlEnumValue("dataMerger")
    DATA_MERGER("dataMerger"),

    /**
     * A component that performs conversion between formats of a resource
     * 
     */
    @XmlEnumValue("converter")
    CONVERTER("converter"),

    /**
     * A component that is used in the evaluation of the performance of a component
     * 
     */
    @XmlEnumValue("evaluator")
    EVALUATOR("evaluator"),

    /**
     * A component that supports controlling flows
     * 
     */
    @XmlEnumValue("flowController")
    FLOW_CONTROLLER("flowController"),

    /**
     * A component that performs analysis tasks based on a script
     * 
     */
    @XmlEnumValue("scriptBasedAnalyser")
    SCRIPT_BASED_ANALYSER("scriptBasedAnalyser"),

    /**
     * A component that allows matching (mapping) of elements
     * 
     */
    @XmlEnumValue("matcher")
    MATCHER("matcher"),

    /**
     * A component that allows matching of elements based on a gazeteer
     * 
     */
    @XmlEnumValue("gazeteerBasedMatcher")
    GAZETEER_BASED_MATCHER("gazeteerBasedMatcher"),

    /**
     * A component that supports crowd sourcing operations
     * 
     */
    @XmlEnumValue("crowdSourcingComponent")
    CROWD_SOURCING_COMPONENT("crowdSourcingComponent"),

    /**
     * A component that collects (retrieves) data from various sources
     * 
     */
    @XmlEnumValue("dataCollector")
    DATA_COLLECTOR("dataCollector"),

    /**
     * A component that crawls the web and collects data from various web sites
     * 
     */
    @XmlEnumValue("crawler")
    CRAWLER("crawler"),

    /**
     * A component that is used in processing operations
     * 
     */
    @XmlEnumValue("processor")
    PROCESSOR("processor"),

    /**
     * A component that annotates any language data (text, video, audio etc.), i.e. adds any descriptive or analytic notations (structural, linguistic, etc) to raw language data
     * 
     */
    @XmlEnumValue("annotator")
    ANNOTATOR("annotator"),

    /**
     * A component that segments a text into structural untis (chapters, paragraphs, sentences, words, tokens etc.)
     * 
     */
    @XmlEnumValue("segmenter")
    SEGMENTER("segmenter"),

    /**
     * A component that extracts stems from words in a
     * text, usually by removing the commoner morphological and inflectional endings from words
     * 
     */
    @XmlEnumValue("stemmer")
    STEMMER("stemmer"),

    /**
     * A component that annotates the tokens of a text with lemma information
     * 
     */
    @XmlEnumValue("lemmatizer")
    LEMMATIZER("lemmatizer"),

    /**
     * A component that annotates tokens of a text with morphological information (part-of-speech and morphological features)
     * 
     */
    @XmlEnumValue("morphologicalTagger")
    MORPHOLOGICAL_TAGGER("morphologicalTagger"),

    /**
     * A component that groups tokens of a text into chunks
     * 
     */
    @XmlEnumValue("chunker")
    CHUNKER("chunker"),

    /**
     * A component that parses sentences and ?
     * 
     */
    @XmlEnumValue("parser")
    PARSER("parser"),

    /**
     * A component that annotates tokens of a text with coreference information, i.e. annotating expressions that refer to the same entity in the text
     * 
     */
    @XmlEnumValue("coreferenceAnnotator")
    COREFERENCE_ANNOTATOR("coreferenceAnnotator"),

    /**
     * A component that seeks to locate and classify elements in a text into pre-defined categories such as the names of persons, organizations,
     * locations, expressions of times, etc.
     * 
     */
    @XmlEnumValue("namedEntityRecognizer")
    NAMED_ENTITY_RECOGNIZER("namedEntityRecognizer"),

    /**
     * A component that annotates the tokens of a text with semantic features
     * 
     */
    @XmlEnumValue("semanticsAnnotator")
    SEMANTICS_ANNOTATOR("semanticsAnnotator"),

    /**
     * A component that annotates the tokens of a text with Semantic Role labels
     * 
     */
    @XmlEnumValue("srlAnnotator")
    SRL_ANNOTATOR("srlAnnotator"),

    /**
     * A component that annotates the tokens of a text with readability scores
     * 
     */
    @XmlEnumValue("readabilityAnnotator")
    READABILITY_ANNOTATOR("readabilityAnnotator"),

    /**
     * A component that detects and annotates equivalence relations between items (corpora, texts, paragraphs, sentences, phrases,
     * words) in two languages
     * 
     */
    @XmlEnumValue("aligner")
    ALIGNER("aligner"),

    /**
     * A component that generates (semi-)automatically natural language texts (based on non-linguistic data, keywords, logical forms, knowledge bases...)
     * 
     */
    @XmlEnumValue("generator")
    GENERATOR("generator"),

    /**
     * A component that produces a natural language synopsis of a longer text
     * 
     */
    @XmlEnumValue("summarizer")
    SUMMARIZER("summarizer"),

    /**
     * A component that outputs a simpler rendition of a given item (sentence, text etc.)
     * 
     */
    @XmlEnumValue("simplifier")
    SIMPLIFIER("simplifier"),

    /**
     * A component that is used at pre- or post-processing stages in order to normalize input/output
     * 
     */
    @XmlEnumValue("preOrPostProcessingComponent")
    PRE_OR_POST_PROCESSING_COMPONENT("preOrPostProcessingComponent"),

    /**
     * A component that corrects spelling mistakes in a text
     * 
     */
    @XmlEnumValue("spellingChecker")
    SPELLING_CHECKER("spellingChecker"),

    /**
     * A component that corrects grammatical mistakes in a text
     * 
     */
    @XmlEnumValue("grammarChecker")
    GRAMMAR_CHECKER("grammarChecker"),

    /**
     * A component that removes unwanted material from text, usually as a pre-processing step
     * 
     */
    @XmlEnumValue("normalizer")
    NORMALIZER("normalizer"),

    /**
     * ??
     * 
     */
    @XmlEnumValue("filters")
    FILTERS("filters"),

    /**
     * A component that is used for analysing an input text in order to perform extraction of features/information (e.g. word list), or characterization of the whole text
     * 
     */
    @XmlEnumValue("analyzer")
    ANALYZER("analyzer"),

    /**
     * A component that guesses the topic of a text
     * 
     */
    @XmlEnumValue("topicExtractor")
    TOPIC_EXTRACTOR("topicExtractor"),

    /**
     * A component that tries to classify a document into one or more categories
     * 
     */
    @XmlEnumValue("documentClassifier")
    DOCUMENT_CLASSIFIER("documentClassifier"),

    /**
     * A component that identifies the language of a given text based on its contents
     * 
     */
    @XmlEnumValue("languageIdentifier")
    LANGUAGE_IDENTIFIER("languageIdentifier"),

    /**
     * A component that tries to identify sentences that express the author’s negative or positive feelings on something; (Sentiment analysis (also known as opinion mining) refers to the use of natural language processing, text analysis and computational linguistics to identify and extract subjective information in source materials (wikipedia) )
     * 
     */
    @XmlEnumValue("sentimentAnalyzer")
    SENTIMENT_ANALYZER("sentimentAnalyzer"),

    /**
     * A component that tries to extract keywords from a given text
     * 
     */
    @XmlEnumValue("keywordsExtractor")
    KEYWORDS_EXTRACTOR("keywordsExtractor"),

    /**
     * A component that tries to extract terms from a corpus
     * 
     */
    @XmlEnumValue("termExtractor")
    TERM_EXTRACTOR("termExtractor"),

    /**
     * A component that tries to automatically recognise elements that reveal contradiction in a text
     * 
     */
    @XmlEnumValue("contradictionDetector")
    CONTRADICTION_DETECTOR("contradictionDetector"),

    /**
     * A component that tries to extract information related to incidents referred to in a text
     * 
     */
    @XmlEnumValue("eventExtractor")
    EVENT_EXTRACTOR("eventExtractor"),

    /**
     * A component that tries to identify persuasive expressions in a given text
     * 
     */
    @XmlEnumValue("persuasiveExpressionMiner")
    PERSUASIVE_EXPRESSION_MINER("persuasiveExpressionMiner"),

    /**
     * A component that automatically extracts structured information from unstructured and/or semi-structured machine-readable documents
     * 
     */
    @XmlEnumValue("informationExtractor")
    INFORMATION_EXTRACTOR("informationExtractor"),

    /**
     * A component that extracts structured lexical resources from corpora
     * 
     */
    @XmlEnumValue("lexiconExtractorFromCorpora")
    LEXICON_EXTRACTOR_FROM_CORPORA("lexiconExtractorFromCorpora"),

    /**
     * A component that extracts specific lexical information contained in other lexica
     * 
     */
    @XmlEnumValue("lexiconExtractorFromLexica")
    LEXICON_EXTRACTOR_FROM_LEXICA("lexiconExtractorFromLexica"),

    /**
     * A component that tries to identify which sense of a word (i.e. meaning) is used in a sentence, when the word has multiple meanings (Source: wikipedia)
     * 
     */
    @XmlEnumValue("wordSenseDisambiguator")
    WORD_SENSE_DISAMBIGUATOR("wordSenseDisambiguator"),

    /**
     * ??
     * 
     */
    @XmlEnumValue("qualitativeAnalyzer")
    QUALITATIVE_ANALYZER("qualitativeAnalyzer"),

    /**
     * A technology that eases the development of new tools and services in the NLP field
     * 
     */
    @XmlEnumValue("platform")
    PLATFORM("platform"),
    @XmlEnumValue("infrastructure")
    INFRASTRUCTURE("infrastructure"),

    /**
     * A technology that supports the flexible development of NLP applications, together with all the requested resources
     * 
     */
    @XmlEnumValue("architecture")
    ARCHITECTURE("architecture"),

    /**
     * A technology that supports the development of data resources, like lexicons, grammars, corpora, etc. Can be included in an Architecture or in a Platform
     * 
     */
    @XmlEnumValue("nlpDevelopmentEnvironment")
    NLP_DEVELOPMENT_ENVIRONMENT("nlpDevelopmentEnvironment"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    ComponentTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ComponentTypeEnum fromValue(String v) {
        for (ComponentTypeEnum c: ComponentTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
