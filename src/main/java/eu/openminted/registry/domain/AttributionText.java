
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The text that must be quoted for attribution purposes when using a resource - for cases where a resource is provided with a restriction on attribution; you can use a standard text such as "Resource A by Resource Creator/Owner B used under licence C as accessed at D"
 * 
 * <p>Java class for attributionText element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="attributionText"&gt;
 *   &lt;complexType&gt;
 *     &lt;simpleContent&gt;
 *       &lt;restriction base="&lt;http://www.meta-share.org/OMTD-SHARE_XMLSchema&gt;myString"&gt;
 *       &lt;/restriction&gt;
 *     &lt;/simpleContent&gt;
 *   &lt;/complexType&gt;
 * &lt;/element&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "attributionText")
public class AttributionText
    extends MyString
{


}
