package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for rightsInfo element declaration.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;element name="rightsInfo"&gt;
 *   &lt;complexType&gt;
 *     &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="licenceInfos"&gt;
 *               &lt;complexType&gt;
 *                 &lt;complexContent&gt;
 *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                     &lt;sequence&gt;
 *                       &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}licenceInfo" maxOccurs="unbounded"/&gt;
 *                     &lt;/sequence&gt;
 *                   &lt;/restriction&gt;
 *                 &lt;/complexContent&gt;
 *               &lt;/complexType&gt;
 *             &lt;/element&gt;
 *             &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}rightsStatementInfo" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}rightsStatementInfo"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/restriction&gt;
 *     &lt;/complexContent&gt;
 *   &lt;/complexType&gt;
 * &lt;/element&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "licenceInfos", "rightsStatementInfo" })
@XmlRootElement(name = "rightsInfo")
public class RightsInfo {

	// @XmlElements({
	// @XmlElement(name = "licenceInfos", type = LicenceInfos.class, namespace =
	// "http://www.meta-share.org/OMTD-SHARE_XMLSchema"),
	// @XmlElement(name = "rightsStatementInfo", type =
	// RightsStatementInfo.class, namespace =
	// "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
	// })
	// protected List<Object>
	// licenceInfosAndRightsStatementInfoOrRightsStatementInfo;

	@XmlElementWrapper
	@XmlElement(name = "licenceInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
	protected List<LicenceInfo> licenceInfos;

	protected RightsStatementInfo rightsStatementInfo;

	public List<LicenceInfo> getLicenceInfos() {
		if (licenceInfos == null) {
			licenceInfos = new ArrayList<LicenceInfo>();
		}
		return licenceInfos;
	}

	public void setLicenceInfos(List<LicenceInfo> licenceInfos) {
		this.licenceInfos = licenceInfos;
	}

	public RightsStatementInfo getRightsStatementInfo() {
		return rightsStatementInfo;
	}

	public void setRightsStatementInfo(RightsStatementInfo rightsStatementInfo) {
		this.rightsStatementInfo = rightsStatementInfo;
	}

}
