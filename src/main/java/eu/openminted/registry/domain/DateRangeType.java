package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DateRangeType {

    //required
    private DateType startDate;
    //required
    private DateType endDate;

    public DateRangeType() {
    }

    public DateRangeType(DateType startDate, DateType endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public DateType getStartDate() {
        return startDate;
    }

    public void setStartDate(DateType startDate) {
        this.startDate = startDate;
    }

    public DateType getEndDate() {
        return endDate;
    }

    public void setEndDate(DateType endDate) {
        this.endDate = endDate;
    }
}
