package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DateCombinationType {

    private DateType date;
    private DateRangeType dateRangeType;

    public DateCombinationType() {
    }

    public DateCombinationType(DateType date) {
        this.date = date;
    }

    public DateCombinationType(DateRangeType dateRangeType) {
        this.dateRangeType = dateRangeType;
    }

    public DateType getDate() {
        return date;
    }

    public void setDate(DateType date) {
        this.date = date;
    }

    public DateRangeType getDateRangeType() {
        return dateRangeType;
    }

    public void setDateRangeType(DateRangeType dateRangeType) {
        this.dateRangeType = dateRangeType;
    }
}
