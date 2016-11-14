
package eu.openminted.registry.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for usageInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="usageInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="foreseenUseInfos" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}foreseenUseInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="actualUseInfos" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}actualUseInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usageInfoType", propOrder = {
    "foreseenUseInfos",
    "actualUseInfos"
})
public class UsageInfo {

    @XmlElementWrapper
    @XmlElement(name = "foreseenUseInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ForeseenUseInfo> foreseenUseInfos;
    @XmlElementWrapper
    @XmlElement(name = "actualUseInfo", namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema")
    protected List<ActualUseInfo> actualUseInfos;

    public List<ForeseenUseInfo> getForeseenUseInfos() {
        if (foreseenUseInfos == null) {
            foreseenUseInfos = new ArrayList<ForeseenUseInfo>();
        }
        return foreseenUseInfos;
    }

    public void setForeseenUseInfos(List<ForeseenUseInfo> foreseenUseInfos) {
        this.foreseenUseInfos = foreseenUseInfos;
    }

    public List<ActualUseInfo> getActualUseInfos() {
        if (actualUseInfos == null) {
            actualUseInfos = new ArrayList<ActualUseInfo>();
        }
        return actualUseInfos;
    }

    public void setActualUseInfos(List<ActualUseInfo> actualUseInfos) {
        this.actualUseInfos = actualUseInfos;
    }

}
