
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * Base type for related projects; choice between project names and identifiers
 * 
 * <p>Java class for relatedProjectType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="relatedProjectType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="projectNames"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="projectName" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;restriction base="&lt;http://www.meta-share.org/OMTD-SHARE_XMLSchema&gt;myString"&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="projectIdentifiers"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="projectIdentifier" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}projectIdentifierType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "relatedProjectType", propOrder = {
    "projectNames","projectIdentifiers"
})
public class RelatedProject {

//    @XmlElements({
//        @XmlElement(name = "projectNames", type = ProjectNames.class),
//        @XmlElement(name = "projectIdentifiers", type = ProjectIdentifiers.class)
//    })
//    protected Object projectNamesOrProjectIdentifiers;

    
	@XmlElementWrapper
    @XmlElement(name = "projectName", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ProjectName> projectNames;

    @XmlElementWrapper
    @XmlElement(name = "projectIdentifier", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ProjectIdentifier> projectIdentifiers;
    
    public List<ProjectName> getProjectNames() {
        if (projectNames == null) {
        	projectNames = new ArrayList<ProjectName>();
        }
        return projectNames;
    }

    public void setProjectNames(List<ProjectName> projectNames) {
        this.projectNames = projectNames;
    }
    
    public List<ProjectIdentifier> getProjectIdentifiers() {
        if (projectIdentifiers == null) {
        	projectIdentifiers = new ArrayList<ProjectIdentifier>();
        }
        return projectIdentifiers;
    }

    public void setProjectIdentifiers(List<ProjectIdentifier> projectIdentifiers) {
        this.projectIdentifiers = projectIdentifiers;
    }

}
