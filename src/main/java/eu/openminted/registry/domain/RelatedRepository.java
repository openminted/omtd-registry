
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * Base type for related repositories; choice between repository names and identifiers
 * 
 * <p>Java class for relatedRepositoryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="relatedRepositoryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="repositoryNames"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="repositoryName" maxOccurs="unbounded"&gt;
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
 *         &lt;element name="repositoryIdentifiers"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="repositoryIdentifier" type="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}repositoryIdentifierType" maxOccurs="unbounded"/&gt;
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
@XmlType(name = "relatedRepositoryType", propOrder = {
    "repositoryNames","repositoryIdentifiers"
})
public class RelatedRepository {

//    @XmlElements({
//        @XmlElement(name = "repositoryNames", type = RepositoryNames.class),
//        @XmlElement(name = "repositoryIdentifiers", type = RepositoryIdentifiers.class)
//    })
//    protected Object repositoryNamesOrRepositoryIdentifiers;

	@XmlElementWrapper
    @XmlElement(name = "repositoryName", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RepositoryName> repositoryNames;

    @XmlElementWrapper
    @XmlElement(name = "repositoryIdentifier", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<RepositoryIdentifier> repositoryIdentifiers;
    
    public List<RepositoryName> getrepositoryNames() {
        if (repositoryNames == null) {
        	repositoryNames = new ArrayList<RepositoryName>();
        }
        return repositoryNames;
    }

    public void setrepositoryNames(List<RepositoryName> repositoryNames) {
        this.repositoryNames = repositoryNames;
    }
    
    public List<RepositoryIdentifier> getrepositoryIdentifiers() {
        if (repositoryIdentifiers == null) {
        	repositoryIdentifiers = new ArrayList<RepositoryIdentifier>();
        }
        return repositoryIdentifiers;
    }

    public void setrepositoryIdentifiers(List<RepositoryIdentifier> repositoryIdentifiers) {
        this.repositoryIdentifiers = repositoryIdentifiers;
    }

}
