package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class GeographicCoverageInfo {

    //required
    private String geographicCoverage;
    private SizeInfo sizePerGeographicCoverage;

    public GeographicCoverageInfo() {
    }

    public GeographicCoverageInfo(String geographicCoverage) {
        this.geographicCoverage = geographicCoverage;
    }

    public GeographicCoverageInfo(String geographicCoverage, SizeInfo sizePerGeographicCoverage) {
        this.geographicCoverage = geographicCoverage;
        this.sizePerGeographicCoverage = sizePerGeographicCoverage;
    }

    public String getGeographicCoverage() {
        return geographicCoverage;
    }

    public void setGeographicCoverage(String geographicCoverage) {
        this.geographicCoverage = geographicCoverage;
    }

    public SizeInfo getSizePerGeographicCoverage() {
        return sizePerGeographicCoverage;
    }

    public void setSizePerGeographicCoverage(SizeInfo sizePerGeographicCoverage) {
        this.sizePerGeographicCoverage = sizePerGeographicCoverage;
    }
}
