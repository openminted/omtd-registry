package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class DateType {

    private int day;
    private int month;
    //required
    private int year;

    public DateType() {
    }

    public DateType(int year) {
        this.year = year;
    }

    public DateType(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
