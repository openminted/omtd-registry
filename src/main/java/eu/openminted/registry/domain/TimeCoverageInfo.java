package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class TimeCoverageInfo {

    //required
    private String timeCoverage;
    private SizeInfo sizePerTimeCoverage;

    public TimeCoverageInfo() {
    }

    public TimeCoverageInfo(String timeCoverage) {
        this.timeCoverage = timeCoverage;
    }

    public TimeCoverageInfo(String timeCoverage, SizeInfo sizePerTimeCoverage) {
        this.timeCoverage = timeCoverage;
        this.sizePerTimeCoverage = sizePerTimeCoverage;
    }

    public String getTimeCoverage() {
        return timeCoverage;
    }

    public void setTimeCoverage(String timeCoverage) {
        this.timeCoverage = timeCoverage;
    }

    public SizeInfo getSizePerTimeCoverage() {
        return sizePerTimeCoverage;
    }

    public void setSizePerTimeCoverage(SizeInfo sizePerTimeCoverage) {
        this.sizePerTimeCoverage = sizePerTimeCoverage;
    }
}
