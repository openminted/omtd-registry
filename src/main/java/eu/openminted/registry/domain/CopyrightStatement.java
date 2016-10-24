
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A free text statement that may be included with the resource, usually containing the name(s) of copyright holders and licensing terms (intended for resources that already have such a statement); the element can be repeated for the different language versions using the "lang" attribute to specify the language.
 * 
 * <p>Java class for copyrightStatement element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="copyrightStatement"&gt;
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
@XmlRootElement(name = "copyrightStatement")
public class CopyrightStatement
    extends MyString
{


}
