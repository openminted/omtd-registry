
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.meta-share.org/OMTD-SHARE_XMLSchema&gt;myString"&gt;
 *       &lt;attribute name="titleType"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="alternativeTitle"/&gt;
 *             &lt;enumeration value="subtitle"/&gt;
 *             &lt;enumeration value="translatedTitle"/&gt;
 *             &lt;enumeration value="other"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class Title
    extends MyString
{

    @XmlAttribute(name = "titleType")
    protected TitleTypeEnum titleType;

    /**
     * Gets the value of the titleType property.
     * 
     * @return
     *     possible object is
     *     {@link TitleTypeEnum }
     *     
     */
    public TitleTypeEnum getTitleType() {
        return titleType;
    }

    /**
     * Sets the value of the titleType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TitleTypeEnum }
     *     
     */
    public void setTitleType(TitleTypeEnum value) {
        this.titleType = value;
    }

}
