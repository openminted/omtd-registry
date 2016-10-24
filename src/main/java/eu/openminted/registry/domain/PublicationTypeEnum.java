
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
 *     &lt;maxLength value="30"/&gt;
 *     &lt;enumeration value="article"/&gt;
 *     &lt;enumeration value="bachelorThesis"/&gt;
 *     &lt;enumeration value="masterThesis"/&gt;
 *     &lt;enumeration value="doctoralThesis"/&gt;
 *     &lt;enumeration value="book"/&gt;
 *     &lt;enumeration value="bookPart"/&gt;
 *     &lt;enumeration value="review"/&gt;
 *     &lt;enumeration value="conferenceObject"/&gt;
 *     &lt;enumeration value="lecture"/&gt;
 *     &lt;enumeration value="workingPaper"/&gt;
 *     &lt;enumeration value="prePrint"/&gt;
 *     &lt;enumeration value="report"/&gt;
 *     &lt;enumeration value="annotation"/&gt;
 *     &lt;enumeration value="contributionToPeriodical"/&gt;
 *     &lt;enumeration value="patent"/&gt;
 *     &lt;enumeration value="inProceedings"/&gt;
 *     &lt;enumeration value="booklet"/&gt;
 *     &lt;enumeration value="manual"/&gt;
 *     &lt;enumeration value="techReport"/&gt;
 *     &lt;enumeration value="inCollection"/&gt;
 *     &lt;enumeration value="unpublished"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum PublicationTypeEnum {


    /**
     * An article from a journal or magazine
     * 
     */
    @XmlEnumValue("article")
    ARTICLE("article"),

    /**
     * Bachelor thesis
     * 
     */
    @XmlEnumValue("bachelorThesis")
    BACHELOR_THESIS("bachelorThesis"),

    /**
     * Master's thesis
     * 
     */
    @XmlEnumValue("masterThesis")
    MASTER_THESIS("masterThesis"),

    /**
     * A doctoral (PhD) thesis
     * 
     */
    @XmlEnumValue("doctoralThesis")
    DOCTORAL_THESIS("doctoralThesis"),

    /**
     * A book with an explicit publisher
     * 
     */
    @XmlEnumValue("book")
    BOOK("book"),

    /**
     * Part of a book
     * 
     */
    @XmlEnumValue("bookPart")
    BOOK_PART("bookPart"),

    /**
     * Review of a book published in a journal
     * 
     */
    @XmlEnumValue("review")
    REVIEW("review"),

    /**
     * The proceedings of a conference
     * 
     */
    @XmlEnumValue("conferenceObject")
    CONFERENCE_OBJECT("conferenceObject"),

    /**
     * Lecture from a university
     * 
     */
    @XmlEnumValue("lecture")
    LECTURE("lecture"),

    /**
     * Working paper
     * 
     */
    @XmlEnumValue("workingPaper")
    WORKING_PAPER("workingPaper"),

    /**
     * Pre-print version of an article
     * 
     */
    @XmlEnumValue("prePrint")
    PRE_PRINT("prePrint"),

    /**
     * Report (e.g. deliverable)
     * 
     */
    @XmlEnumValue("report")
    REPORT("report"),

    /**
     * Annotated version
     * 
     */
    @XmlEnumValue("annotation")
    ANNOTATION("annotation"),

    /**
     * contributionToPeriodical
     * 
     */
    @XmlEnumValue("contributionToPeriodical")
    CONTRIBUTION_TO_PERIODICAL("contributionToPeriodical"),

    /**
     * Patent
     * 
     */
    @XmlEnumValue("patent")
    PATENT("patent"),

    /**
     * An article in a conference proceedings
     * 
     */
    @XmlEnumValue("inProceedings")
    IN_PROCEEDINGS("inProceedings"),

    /**
     * A work that is printed and bound, but without a named  publisher or sponsoring institution
     * 
     */
    @XmlEnumValue("booklet")
    BOOKLET("booklet"),

    /**
     * Technical documentation
     * 
     */
    @XmlEnumValue("manual")
    MANUAL("manual"),

    /**
     * A report published by a school or other institution
     * 
     */
    @XmlEnumValue("techReport")
    TECH_REPORT("techReport"),

    /**
     * A part of a book having its own title
     * 
     */
    @XmlEnumValue("inCollection")
    IN_COLLECTION("inCollection"),

    /**
     * A document having an author and title, but not formally published
     * 
     */
    @XmlEnumValue("unpublished")
    UNPUBLISHED("unpublished"),

    /**
     * Use this type when nothing else fits
     * 
     */
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    PublicationTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PublicationTypeEnum fromValue(String v) {
        for (PublicationTypeEnum c: PublicationTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
