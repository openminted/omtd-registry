
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
 *     &lt;enumeration value="alignment"/&gt;
 *     &lt;enumeration value="annotation"/&gt;
 *     &lt;enumeration value="avatarSynthesis"/&gt;
 *     &lt;enumeration value="bilingualLexiconInduction"/&gt;
 *     &lt;enumeration value="contradictionDetection"/&gt;
 *     &lt;enumeration value="coreferenceResolution"/&gt;
 *     &lt;enumeration value="dependencyParsing"/&gt;
 *     &lt;enumeration value="derivationalMorphologicalAnalysis"/&gt;
 *     &lt;enumeration value="discourseAnalysis"/&gt;
 *     &lt;enumeration value="documentClassification"/&gt;
 *     &lt;enumeration value="emotionGeneration"/&gt;
 *     &lt;enumeration value="emotionRecognition"/&gt;
 *     &lt;enumeration value="entityMentionRecognition"/&gt;
 *     &lt;enumeration value="eventExtraction"/&gt;
 *     &lt;enumeration value="expressionRecognition"/&gt;
 *     &lt;enumeration value="faceRecognition"/&gt;
 *     &lt;enumeration value="faceVerification"/&gt;
 *     &lt;enumeration value="humanoidAgentSynthesis"/&gt;
 *     &lt;enumeration value="informationExtraction"/&gt;
 *     &lt;enumeration value="informationRetrieval"/&gt;
 *     &lt;enumeration value="intra-documentCoreferenceResolution"/&gt;
 *     &lt;enumeration value="knowledgeDiscovery"/&gt;
 *     &lt;enumeration value="knowledgeRepresentation"/&gt;
 *     &lt;enumeration value="languageIdentification"/&gt;
 *     &lt;enumeration value="languageModelling"/&gt;
 *     &lt;enumeration value="languageModelsTraining"/&gt;
 *     &lt;enumeration value="lemmatization"/&gt;
 *     &lt;enumeration value="lexiconAccess"/&gt;
 *     &lt;enumeration value="lexiconAcquisitionFromCorpora"/&gt;
 *     &lt;enumeration value="lexiconEnhancement"/&gt;
 *     &lt;enumeration value="lexiconExtractionFromLexica"/&gt;
 *     &lt;enumeration value="lexiconFormatConversion"/&gt;
 *     &lt;enumeration value="lexiconMerging"/&gt;
 *     &lt;enumeration value="lexiconVisualization"/&gt;
 *     &lt;enumeration value="linguisticResearch"/&gt;
 *     &lt;enumeration value="lipTrackingAnalysis"/&gt;
 *     &lt;enumeration value="machineTranslation"/&gt;
 *     &lt;enumeration value="morphologicalAnalysis"/&gt;
 *     &lt;enumeration value="morphosyntacticAnnotation-bPosTagging"/&gt;
 *     &lt;enumeration value="morphosyntacticAnnotation-posTagging"/&gt;
 *     &lt;enumeration value="multimediaDevelopment"/&gt;
 *     &lt;enumeration value="multimediaDocumentProcessing"/&gt;
 *     &lt;enumeration value="namedEntityRecognition"/&gt;
 *     &lt;enumeration value="naturalLanguageGeneration"/&gt;
 *     &lt;enumeration value="naturalLanguageUnderstanding"/&gt;
 *     &lt;enumeration value="opinionMining"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *     &lt;enumeration value="personIdentification"/&gt;
 *     &lt;enumeration value="personRecognition"/&gt;
 *     &lt;enumeration value="persuasiveExpressionMining"/&gt;
 *     &lt;enumeration value="phraseAlignment"/&gt;
 *     &lt;enumeration value="qualitativeAnalysis"/&gt;
 *     &lt;enumeration value="questionAnswering"/&gt;
 *     &lt;enumeration value="readingAndWritingAidApplications"/&gt;
 *     &lt;enumeration value="semanticRoleLabelling"/&gt;
 *     &lt;enumeration value="semanticWeb"/&gt;
 *     &lt;enumeration value="sentenceAlignment"/&gt;
 *     &lt;enumeration value="sentenceSplitting"/&gt;
 *     &lt;enumeration value="sentimentAnalysis"/&gt;
 *     &lt;enumeration value="shallowParsing"/&gt;
 *     &lt;enumeration value="signLanguageGeneration"/&gt;
 *     &lt;enumeration value="signLanguageRecognition"/&gt;
 *     &lt;enumeration value="speakerIdentification"/&gt;
 *     &lt;enumeration value="speakerVerification"/&gt;
 *     &lt;enumeration value="speechAnalysis"/&gt;
 *     &lt;enumeration value="speechAssistedVideoControl"/&gt;
 *     &lt;enumeration value="speechLipsCorrelationAnalysis"/&gt;
 *     &lt;enumeration value="speechRecognition"/&gt;
 *     &lt;enumeration value="speechSynthesis"/&gt;
 *     &lt;enumeration value="speechToSpeechTranslation"/&gt;
 *     &lt;enumeration value="speechUnderstanding"/&gt;
 *     &lt;enumeration value="speechVerification"/&gt;
 *     &lt;enumeration value="spellChecking"/&gt;
 *     &lt;enumeration value="spokenDialogueSystems"/&gt;
 *     &lt;enumeration value="summarization"/&gt;
 *     &lt;enumeration value="talkingHeadSynthesis"/&gt;
 *     &lt;enumeration value="temporalExpressionRecognition"/&gt;
 *     &lt;enumeration value="terminologyExtraction"/&gt;
 *     &lt;enumeration value="textCategorisation"/&gt;
 *     &lt;enumeration value="textGeneration"/&gt;
 *     &lt;enumeration value="textMining"/&gt;
 *     &lt;enumeration value="textToSpeechSynthesis"/&gt;
 *     &lt;enumeration value="textualEntailment"/&gt;
 *     &lt;enumeration value="tokenization"/&gt;
 *     &lt;enumeration value="tokenizationAndSentenceSplitting"/&gt;
 *     &lt;enumeration value="topicDetection_Tracking"/&gt;
 *     &lt;enumeration value="userAuthentication"/&gt;
 *     &lt;enumeration value="visualSceneUnderstanding"/&gt;
 *     &lt;enumeration value="voiceControl"/&gt;
 *     &lt;enumeration value="wordAlignment"/&gt;
 *     &lt;enumeration value="wordSenseDisambiguation"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum UseNLPSpecificEnum {

    @XmlEnumValue("alignment")
    ALIGNMENT("alignment"),
    @XmlEnumValue("annotation")
    ANNOTATION("annotation"),
    @XmlEnumValue("avatarSynthesis")
    AVATAR_SYNTHESIS("avatarSynthesis"),
    @XmlEnumValue("bilingualLexiconInduction")
    BILINGUAL_LEXICON_INDUCTION("bilingualLexiconInduction"),
    @XmlEnumValue("contradictionDetection")
    CONTRADICTION_DETECTION("contradictionDetection"),
    @XmlEnumValue("coreferenceResolution")
    COREFERENCE_RESOLUTION("coreferenceResolution"),
    @XmlEnumValue("dependencyParsing")
    DEPENDENCY_PARSING("dependencyParsing"),
    @XmlEnumValue("derivationalMorphologicalAnalysis")
    DERIVATIONAL_MORPHOLOGICAL_ANALYSIS("derivationalMorphologicalAnalysis"),
    @XmlEnumValue("discourseAnalysis")
    DISCOURSE_ANALYSIS("discourseAnalysis"),
    @XmlEnumValue("documentClassification")
    DOCUMENT_CLASSIFICATION("documentClassification"),
    @XmlEnumValue("emotionGeneration")
    EMOTION_GENERATION("emotionGeneration"),
    @XmlEnumValue("emotionRecognition")
    EMOTION_RECOGNITION("emotionRecognition"),
    @XmlEnumValue("entityMentionRecognition")
    ENTITY_MENTION_RECOGNITION("entityMentionRecognition"),
    @XmlEnumValue("eventExtraction")
    EVENT_EXTRACTION("eventExtraction"),
    @XmlEnumValue("expressionRecognition")
    EXPRESSION_RECOGNITION("expressionRecognition"),
    @XmlEnumValue("faceRecognition")
    FACE_RECOGNITION("faceRecognition"),
    @XmlEnumValue("faceVerification")
    FACE_VERIFICATION("faceVerification"),
    @XmlEnumValue("humanoidAgentSynthesis")
    HUMANOID_AGENT_SYNTHESIS("humanoidAgentSynthesis"),
    @XmlEnumValue("informationExtraction")
    INFORMATION_EXTRACTION("informationExtraction"),
    @XmlEnumValue("informationRetrieval")
    INFORMATION_RETRIEVAL("informationRetrieval"),
    @XmlEnumValue("intra-documentCoreferenceResolution")
    INTRA_DOCUMENT_COREFERENCE_RESOLUTION("intra-documentCoreferenceResolution"),
    @XmlEnumValue("knowledgeDiscovery")
    KNOWLEDGE_DISCOVERY("knowledgeDiscovery"),
    @XmlEnumValue("knowledgeRepresentation")
    KNOWLEDGE_REPRESENTATION("knowledgeRepresentation"),
    @XmlEnumValue("languageIdentification")
    LANGUAGE_IDENTIFICATION("languageIdentification"),
    @XmlEnumValue("languageModelling")
    LANGUAGE_MODELLING("languageModelling"),
    @XmlEnumValue("languageModelsTraining")
    LANGUAGE_MODELS_TRAINING("languageModelsTraining"),
    @XmlEnumValue("lemmatization")
    LEMMATIZATION("lemmatization"),
    @XmlEnumValue("lexiconAccess")
    LEXICON_ACCESS("lexiconAccess"),
    @XmlEnumValue("lexiconAcquisitionFromCorpora")
    LEXICON_ACQUISITION_FROM_CORPORA("lexiconAcquisitionFromCorpora"),
    @XmlEnumValue("lexiconEnhancement")
    LEXICON_ENHANCEMENT("lexiconEnhancement"),
    @XmlEnumValue("lexiconExtractionFromLexica")
    LEXICON_EXTRACTION_FROM_LEXICA("lexiconExtractionFromLexica"),
    @XmlEnumValue("lexiconFormatConversion")
    LEXICON_FORMAT_CONVERSION("lexiconFormatConversion"),
    @XmlEnumValue("lexiconMerging")
    LEXICON_MERGING("lexiconMerging"),
    @XmlEnumValue("lexiconVisualization")
    LEXICON_VISUALIZATION("lexiconVisualization"),
    @XmlEnumValue("linguisticResearch")
    LINGUISTIC_RESEARCH("linguisticResearch"),
    @XmlEnumValue("lipTrackingAnalysis")
    LIP_TRACKING_ANALYSIS("lipTrackingAnalysis"),
    @XmlEnumValue("machineTranslation")
    MACHINE_TRANSLATION("machineTranslation"),
    @XmlEnumValue("morphologicalAnalysis")
    MORPHOLOGICAL_ANALYSIS("morphologicalAnalysis"),
    @XmlEnumValue("morphosyntacticAnnotation-bPosTagging")
    MORPHOSYNTACTIC_ANNOTATION_B_POS_TAGGING("morphosyntacticAnnotation-bPosTagging"),
    @XmlEnumValue("morphosyntacticAnnotation-posTagging")
    MORPHOSYNTACTIC_ANNOTATION_POS_TAGGING("morphosyntacticAnnotation-posTagging"),
    @XmlEnumValue("multimediaDevelopment")
    MULTIMEDIA_DEVELOPMENT("multimediaDevelopment"),
    @XmlEnumValue("multimediaDocumentProcessing")
    MULTIMEDIA_DOCUMENT_PROCESSING("multimediaDocumentProcessing"),
    @XmlEnumValue("namedEntityRecognition")
    NAMED_ENTITY_RECOGNITION("namedEntityRecognition"),
    @XmlEnumValue("naturalLanguageGeneration")
    NATURAL_LANGUAGE_GENERATION("naturalLanguageGeneration"),
    @XmlEnumValue("naturalLanguageUnderstanding")
    NATURAL_LANGUAGE_UNDERSTANDING("naturalLanguageUnderstanding"),
    @XmlEnumValue("opinionMining")
    OPINION_MINING("opinionMining"),
    @XmlEnumValue("other")
    OTHER("other"),
    @XmlEnumValue("personIdentification")
    PERSON_IDENTIFICATION("personIdentification"),
    @XmlEnumValue("personRecognition")
    PERSON_RECOGNITION("personRecognition"),
    @XmlEnumValue("persuasiveExpressionMining")
    PERSUASIVE_EXPRESSION_MINING("persuasiveExpressionMining"),
    @XmlEnumValue("phraseAlignment")
    PHRASE_ALIGNMENT("phraseAlignment"),
    @XmlEnumValue("qualitativeAnalysis")
    QUALITATIVE_ANALYSIS("qualitativeAnalysis"),
    @XmlEnumValue("questionAnswering")
    QUESTION_ANSWERING("questionAnswering"),
    @XmlEnumValue("readingAndWritingAidApplications")
    READING_AND_WRITING_AID_APPLICATIONS("readingAndWritingAidApplications"),
    @XmlEnumValue("semanticRoleLabelling")
    SEMANTIC_ROLE_LABELLING("semanticRoleLabelling"),
    @XmlEnumValue("semanticWeb")
    SEMANTIC_WEB("semanticWeb"),
    @XmlEnumValue("sentenceAlignment")
    SENTENCE_ALIGNMENT("sentenceAlignment"),
    @XmlEnumValue("sentenceSplitting")
    SENTENCE_SPLITTING("sentenceSplitting"),
    @XmlEnumValue("sentimentAnalysis")
    SENTIMENT_ANALYSIS("sentimentAnalysis"),
    @XmlEnumValue("shallowParsing")
    SHALLOW_PARSING("shallowParsing"),
    @XmlEnumValue("signLanguageGeneration")
    SIGN_LANGUAGE_GENERATION("signLanguageGeneration"),
    @XmlEnumValue("signLanguageRecognition")
    SIGN_LANGUAGE_RECOGNITION("signLanguageRecognition"),
    @XmlEnumValue("speakerIdentification")
    SPEAKER_IDENTIFICATION("speakerIdentification"),
    @XmlEnumValue("speakerVerification")
    SPEAKER_VERIFICATION("speakerVerification"),
    @XmlEnumValue("speechAnalysis")
    SPEECH_ANALYSIS("speechAnalysis"),
    @XmlEnumValue("speechAssistedVideoControl")
    SPEECH_ASSISTED_VIDEO_CONTROL("speechAssistedVideoControl"),
    @XmlEnumValue("speechLipsCorrelationAnalysis")
    SPEECH_LIPS_CORRELATION_ANALYSIS("speechLipsCorrelationAnalysis"),
    @XmlEnumValue("speechRecognition")
    SPEECH_RECOGNITION("speechRecognition"),
    @XmlEnumValue("speechSynthesis")
    SPEECH_SYNTHESIS("speechSynthesis"),
    @XmlEnumValue("speechToSpeechTranslation")
    SPEECH_TO_SPEECH_TRANSLATION("speechToSpeechTranslation"),
    @XmlEnumValue("speechUnderstanding")
    SPEECH_UNDERSTANDING("speechUnderstanding"),
    @XmlEnumValue("speechVerification")
    SPEECH_VERIFICATION("speechVerification"),
    @XmlEnumValue("spellChecking")
    SPELL_CHECKING("spellChecking"),
    @XmlEnumValue("spokenDialogueSystems")
    SPOKEN_DIALOGUE_SYSTEMS("spokenDialogueSystems"),
    @XmlEnumValue("summarization")
    SUMMARIZATION("summarization"),
    @XmlEnumValue("talkingHeadSynthesis")
    TALKING_HEAD_SYNTHESIS("talkingHeadSynthesis"),
    @XmlEnumValue("temporalExpressionRecognition")
    TEMPORAL_EXPRESSION_RECOGNITION("temporalExpressionRecognition"),
    @XmlEnumValue("terminologyExtraction")
    TERMINOLOGY_EXTRACTION("terminologyExtraction"),
    @XmlEnumValue("textCategorisation")
    TEXT_CATEGORISATION("textCategorisation"),
    @XmlEnumValue("textGeneration")
    TEXT_GENERATION("textGeneration"),
    @XmlEnumValue("textMining")
    TEXT_MINING("textMining"),
    @XmlEnumValue("textToSpeechSynthesis")
    TEXT_TO_SPEECH_SYNTHESIS("textToSpeechSynthesis"),
    @XmlEnumValue("textualEntailment")
    TEXTUAL_ENTAILMENT("textualEntailment"),
    @XmlEnumValue("tokenization")
    TOKENIZATION("tokenization"),
    @XmlEnumValue("tokenizationAndSentenceSplitting")
    TOKENIZATION_AND_SENTENCE_SPLITTING("tokenizationAndSentenceSplitting"),
    @XmlEnumValue("topicDetection_Tracking")
    TOPIC_DETECTION_TRACKING("topicDetection_Tracking"),
    @XmlEnumValue("userAuthentication")
    USER_AUTHENTICATION("userAuthentication"),
    @XmlEnumValue("visualSceneUnderstanding")
    VISUAL_SCENE_UNDERSTANDING("visualSceneUnderstanding"),
    @XmlEnumValue("voiceControl")
    VOICE_CONTROL("voiceControl"),
    @XmlEnumValue("wordAlignment")
    WORD_ALIGNMENT("wordAlignment"),
    @XmlEnumValue("wordSenseDisambiguation")
    WORD_SENSE_DISAMBIGUATION("wordSenseDisambiguation");
    private final String value;

    UseNLPSpecificEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UseNLPSpecificEnum fromValue(String v) {
        for (UseNLPSpecificEnum c: UseNLPSpecificEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
