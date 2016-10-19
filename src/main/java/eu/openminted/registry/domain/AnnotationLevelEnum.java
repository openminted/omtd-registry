
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
 *     &lt;maxLength value="150"/&gt;
 *     &lt;enumeration value="alignment"/&gt;
 *     &lt;enumeration value="discourseAnnotation"/&gt;
 *     &lt;enumeration value="discourseAnnotation-argumentation"/&gt;
 *     &lt;enumeration value="discourseAnnotation-audienceReactions"/&gt;
 *     &lt;enumeration value="discourseAnnotation-coreference"/&gt;
 *     &lt;enumeration value="discourseAnnotation-dialogueActs"/&gt;
 *     &lt;enumeration value="discourseAnnotation-discourseRelations"/&gt;
 *     &lt;enumeration value="lemmatization"/&gt;
 *     &lt;enumeration value="morphosyntacticAnnotation-bPosTagging"/&gt;
 *     &lt;enumeration value="morphosyntacticAnnotation-posTagging"/&gt;
 *     &lt;enumeration value="segmentation"/&gt;
 *     &lt;enumeration value="semanticAnnotation"/&gt;
 *     &lt;enumeration value="semanticAnnotation-certaintyLevel"/&gt;
 *     &lt;enumeration value="semanticAnnotation-emotions"/&gt;
 *     &lt;enumeration value="semanticAnnotation-events"/&gt;
 *     &lt;enumeration value="semanticAnnotation-namedEntities"/&gt;
 *     &lt;enumeration value="semanticAnnotation-polarity"/&gt;
 *     &lt;enumeration value="semanticAnnotation-questionTopicalTarget"/&gt;
 *     &lt;enumeration value="semanticAnnotation-readabilty"/&gt;
 *     &lt;enumeration value="semanticAnnotation-semanticClasses"/&gt;
 *     &lt;enumeration value="semanticAnnotation-semanticRelations"/&gt;
 *     &lt;enumeration value="semanticAnnotation-semanticRoles"/&gt;
 *     &lt;enumeration value="semanticAnnotation-speechActs"/&gt;
 *     &lt;enumeration value="semanticAnnotation-subjectivity"/&gt;
 *     &lt;enumeration value="semanticAnnotation-temporalExpressions"/&gt;
 *     &lt;enumeration value="semanticAnnotation-textualEntailment"/&gt;
 *     &lt;enumeration value="semanticAnnotation-wordSenses"/&gt;
 *     &lt;enumeration value="syntacticAnnotation-semanticFrames"/&gt;
 *     &lt;enumeration value="speechAnnotation"/&gt;
 *     &lt;enumeration value="speechAnnotation-orthographicTranscription"/&gt;
 *     &lt;enumeration value="speechAnnotation-paralanguageAnnotation"/&gt;
 *     &lt;enumeration value="speechAnnotation-phoneticTranscription"/&gt;
 *     &lt;enumeration value="speechAnnotation-prosodicAnnotation"/&gt;
 *     &lt;enumeration value="speechAnnotation-soundEvents"/&gt;
 *     &lt;enumeration value="speechAnnotation-soundToTextAlignment"/&gt;
 *     &lt;enumeration value="speechAnnotation-speakerIdentification"/&gt;
 *     &lt;enumeration value="speechAnnotation-speakerTurns"/&gt;
 *     &lt;enumeration value="stemming"/&gt;
 *     &lt;enumeration value="structuralAnnotation"/&gt;
 *     &lt;enumeration value="structuralAnnotation-documentDivisions"/&gt;
 *     &lt;enumeration value="structuralAnnotation-sentences"/&gt;
 *     &lt;enumeration value="structuralAnnotation-clauses"/&gt;
 *     &lt;enumeration value="structuralAnnotation-phrases"/&gt;
 *     &lt;enumeration value="structuralAnnotation-words"/&gt;
 *     &lt;enumeration value="syntacticAnnotation-subcategorizationFrames"/&gt;
 *     &lt;enumeration value="syntacticAnnotation-dependencyTrees"/&gt;
 *     &lt;enumeration value="syntacticAnnotation-constituencyTrees"/&gt;
 *     &lt;enumeration value="syntacticAnnotation-chunks"/&gt;
 *     &lt;enumeration value="syntacticosemanticAnnotation-links"/&gt;
 *     &lt;enumeration value="translation"/&gt;
 *     &lt;enumeration value="transliteration"/&gt;
 *     &lt;enumeration value="modalityAnnotation-bodyMovements"/&gt;
 *     &lt;enumeration value="modalityAnnotation-facialExpressions"/&gt;
 *     &lt;enumeration value="modalityAnnotation-gazeEyeMovements"/&gt;
 *     &lt;enumeration value="modalityAnnotation-handArmGestures"/&gt;
 *     &lt;enumeration value="modalityAnnotation-handManipulationOfObjects"/&gt;
 *     &lt;enumeration value="modalityAnnotation-headMovements"/&gt;
 *     &lt;enumeration value="modalityAnnotation-lipMovements"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum AnnotationLevelEnum {

    @XmlEnumValue("alignment")
    ALIGNMENT("alignment"),
    @XmlEnumValue("discourseAnnotation")
    DISCOURSE_ANNOTATION("discourseAnnotation"),
    @XmlEnumValue("discourseAnnotation-argumentation")
    DISCOURSE_ANNOTATION_ARGUMENTATION("discourseAnnotation-argumentation"),
    @XmlEnumValue("discourseAnnotation-audienceReactions")
    DISCOURSE_ANNOTATION_AUDIENCE_REACTIONS("discourseAnnotation-audienceReactions"),
    @XmlEnumValue("discourseAnnotation-coreference")
    DISCOURSE_ANNOTATION_COREFERENCE("discourseAnnotation-coreference"),
    @XmlEnumValue("discourseAnnotation-dialogueActs")
    DISCOURSE_ANNOTATION_DIALOGUE_ACTS("discourseAnnotation-dialogueActs"),
    @XmlEnumValue("discourseAnnotation-discourseRelations")
    DISCOURSE_ANNOTATION_DISCOURSE_RELATIONS("discourseAnnotation-discourseRelations"),
    @XmlEnumValue("lemmatization")
    LEMMATIZATION("lemmatization"),
    @XmlEnumValue("morphosyntacticAnnotation-bPosTagging")
    MORPHOSYNTACTIC_ANNOTATION_B_POS_TAGGING("morphosyntacticAnnotation-bPosTagging"),
    @XmlEnumValue("morphosyntacticAnnotation-posTagging")
    MORPHOSYNTACTIC_ANNOTATION_POS_TAGGING("morphosyntacticAnnotation-posTagging"),
    @XmlEnumValue("segmentation")
    SEGMENTATION("segmentation"),
    @XmlEnumValue("semanticAnnotation")
    SEMANTIC_ANNOTATION("semanticAnnotation"),
    @XmlEnumValue("semanticAnnotation-certaintyLevel")
    SEMANTIC_ANNOTATION_CERTAINTY_LEVEL("semanticAnnotation-certaintyLevel"),
    @XmlEnumValue("semanticAnnotation-emotions")
    SEMANTIC_ANNOTATION_EMOTIONS("semanticAnnotation-emotions"),
    @XmlEnumValue("semanticAnnotation-events")
    SEMANTIC_ANNOTATION_EVENTS("semanticAnnotation-events"),
    @XmlEnumValue("semanticAnnotation-namedEntities")
    SEMANTIC_ANNOTATION_NAMED_ENTITIES("semanticAnnotation-namedEntities"),
    @XmlEnumValue("semanticAnnotation-polarity")
    SEMANTIC_ANNOTATION_POLARITY("semanticAnnotation-polarity"),
    @XmlEnumValue("semanticAnnotation-questionTopicalTarget")
    SEMANTIC_ANNOTATION_QUESTION_TOPICAL_TARGET("semanticAnnotation-questionTopicalTarget"),
    @XmlEnumValue("semanticAnnotation-readabilty")
    SEMANTIC_ANNOTATION_READABILTY("semanticAnnotation-readabilty"),
    @XmlEnumValue("semanticAnnotation-semanticClasses")
    SEMANTIC_ANNOTATION_SEMANTIC_CLASSES("semanticAnnotation-semanticClasses"),
    @XmlEnumValue("semanticAnnotation-semanticRelations")
    SEMANTIC_ANNOTATION_SEMANTIC_RELATIONS("semanticAnnotation-semanticRelations"),
    @XmlEnumValue("semanticAnnotation-semanticRoles")
    SEMANTIC_ANNOTATION_SEMANTIC_ROLES("semanticAnnotation-semanticRoles"),
    @XmlEnumValue("semanticAnnotation-speechActs")
    SEMANTIC_ANNOTATION_SPEECH_ACTS("semanticAnnotation-speechActs"),
    @XmlEnumValue("semanticAnnotation-subjectivity")
    SEMANTIC_ANNOTATION_SUBJECTIVITY("semanticAnnotation-subjectivity"),
    @XmlEnumValue("semanticAnnotation-temporalExpressions")
    SEMANTIC_ANNOTATION_TEMPORAL_EXPRESSIONS("semanticAnnotation-temporalExpressions"),
    @XmlEnumValue("semanticAnnotation-textualEntailment")
    SEMANTIC_ANNOTATION_TEXTUAL_ENTAILMENT("semanticAnnotation-textualEntailment"),
    @XmlEnumValue("semanticAnnotation-wordSenses")
    SEMANTIC_ANNOTATION_WORD_SENSES("semanticAnnotation-wordSenses"),
    @XmlEnumValue("syntacticAnnotation-semanticFrames")
    SYNTACTIC_ANNOTATION_SEMANTIC_FRAMES("syntacticAnnotation-semanticFrames"),
    @XmlEnumValue("speechAnnotation")
    SPEECH_ANNOTATION("speechAnnotation"),
    @XmlEnumValue("speechAnnotation-orthographicTranscription")
    SPEECH_ANNOTATION_ORTHOGRAPHIC_TRANSCRIPTION("speechAnnotation-orthographicTranscription"),
    @XmlEnumValue("speechAnnotation-paralanguageAnnotation")
    SPEECH_ANNOTATION_PARALANGUAGE_ANNOTATION("speechAnnotation-paralanguageAnnotation"),
    @XmlEnumValue("speechAnnotation-phoneticTranscription")
    SPEECH_ANNOTATION_PHONETIC_TRANSCRIPTION("speechAnnotation-phoneticTranscription"),
    @XmlEnumValue("speechAnnotation-prosodicAnnotation")
    SPEECH_ANNOTATION_PROSODIC_ANNOTATION("speechAnnotation-prosodicAnnotation"),
    @XmlEnumValue("speechAnnotation-soundEvents")
    SPEECH_ANNOTATION_SOUND_EVENTS("speechAnnotation-soundEvents"),
    @XmlEnumValue("speechAnnotation-soundToTextAlignment")
    SPEECH_ANNOTATION_SOUND_TO_TEXT_ALIGNMENT("speechAnnotation-soundToTextAlignment"),
    @XmlEnumValue("speechAnnotation-speakerIdentification")
    SPEECH_ANNOTATION_SPEAKER_IDENTIFICATION("speechAnnotation-speakerIdentification"),
    @XmlEnumValue("speechAnnotation-speakerTurns")
    SPEECH_ANNOTATION_SPEAKER_TURNS("speechAnnotation-speakerTurns"),
    @XmlEnumValue("stemming")
    STEMMING("stemming"),
    @XmlEnumValue("structuralAnnotation")
    STRUCTURAL_ANNOTATION("structuralAnnotation"),
    @XmlEnumValue("structuralAnnotation-documentDivisions")
    STRUCTURAL_ANNOTATION_DOCUMENT_DIVISIONS("structuralAnnotation-documentDivisions"),
    @XmlEnumValue("structuralAnnotation-sentences")
    STRUCTURAL_ANNOTATION_SENTENCES("structuralAnnotation-sentences"),
    @XmlEnumValue("structuralAnnotation-clauses")
    STRUCTURAL_ANNOTATION_CLAUSES("structuralAnnotation-clauses"),
    @XmlEnumValue("structuralAnnotation-phrases")
    STRUCTURAL_ANNOTATION_PHRASES("structuralAnnotation-phrases"),
    @XmlEnumValue("structuralAnnotation-words")
    STRUCTURAL_ANNOTATION_WORDS("structuralAnnotation-words"),
    @XmlEnumValue("syntacticAnnotation-subcategorizationFrames")
    SYNTACTIC_ANNOTATION_SUBCATEGORIZATION_FRAMES("syntacticAnnotation-subcategorizationFrames"),
    @XmlEnumValue("syntacticAnnotation-dependencyTrees")
    SYNTACTIC_ANNOTATION_DEPENDENCY_TREES("syntacticAnnotation-dependencyTrees"),
    @XmlEnumValue("syntacticAnnotation-constituencyTrees")
    SYNTACTIC_ANNOTATION_CONSTITUENCY_TREES("syntacticAnnotation-constituencyTrees"),
    @XmlEnumValue("syntacticAnnotation-chunks")
    SYNTACTIC_ANNOTATION_CHUNKS("syntacticAnnotation-chunks"),
    @XmlEnumValue("syntacticosemanticAnnotation-links")
    SYNTACTICOSEMANTIC_ANNOTATION_LINKS("syntacticosemanticAnnotation-links"),
    @XmlEnumValue("translation")
    TRANSLATION("translation"),
    @XmlEnumValue("transliteration")
    TRANSLITERATION("transliteration"),
    @XmlEnumValue("modalityAnnotation-bodyMovements")
    MODALITY_ANNOTATION_BODY_MOVEMENTS("modalityAnnotation-bodyMovements"),
    @XmlEnumValue("modalityAnnotation-facialExpressions")
    MODALITY_ANNOTATION_FACIAL_EXPRESSIONS("modalityAnnotation-facialExpressions"),
    @XmlEnumValue("modalityAnnotation-gazeEyeMovements")
    MODALITY_ANNOTATION_GAZE_EYE_MOVEMENTS("modalityAnnotation-gazeEyeMovements"),
    @XmlEnumValue("modalityAnnotation-handArmGestures")
    MODALITY_ANNOTATION_HAND_ARM_GESTURES("modalityAnnotation-handArmGestures"),
    @XmlEnumValue("modalityAnnotation-handManipulationOfObjects")
    MODALITY_ANNOTATION_HAND_MANIPULATION_OF_OBJECTS("modalityAnnotation-handManipulationOfObjects"),
    @XmlEnumValue("modalityAnnotation-headMovements")
    MODALITY_ANNOTATION_HEAD_MOVEMENTS("modalityAnnotation-headMovements"),
    @XmlEnumValue("modalityAnnotation-lipMovements")
    MODALITY_ANNOTATION_LIP_MOVEMENTS("modalityAnnotation-lipMovements"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    AnnotationLevelEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AnnotationLevelEnum fromValue(String v) {
        for (AnnotationLevelEnum c: AnnotationLevelEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
