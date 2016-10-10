package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class DateType {

    private Integer day;
    private Integer month;
    //required
    private Integer year;

    public DateType() {
    }

    public DateType(Integer year) {
        this.year = year;
    }

    public DateType(Integer day, Integer month, Integer year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
