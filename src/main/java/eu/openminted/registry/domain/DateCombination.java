
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Base type to be used for choice betwwen range of dates and exact date
 * 
 * <p>Java class for dateCombinationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dateCombinationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}date"/&gt;
 *         &lt;element ref="{http://www.meta-share.org/OMTD-SHARE_XMLSchema}dateRange"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dateCombinationType", propOrder = {
    "date","dateRange"
})
public class DateCombination {

//    @XmlElements({
//        @XmlElement(name = "date", type = Date.class),
//        @XmlElement(name = "dateRange", type = DateRange.class)
//    })
//    protected Object dateOrDateRange;

	
	protected Date date;
	
	protected DateRange dateRange;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public DateRange getDateRange() {
		return dateRange;
	}

	public void setDateRange(DateRange dateRange) {
		this.dateRange = dateRange;
	}
	
	

}
