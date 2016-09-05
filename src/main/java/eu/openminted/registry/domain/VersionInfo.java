package eu.openminted.registry.domain;

/**
 * Created by stefania on 9/5/16.
 */
public class VersionInfo {

    //required
    private String version;
    private String revision;
    private DateType lastDateUpdated;
    private String updateFrequency;

    public VersionInfo() {
    }

    public VersionInfo(String version) {
        this.version = version;
    }

    public VersionInfo(String version, String revision, DateType lastDateUpdated, String updateFrequency) {
        this.version = version;
        this.revision = revision;
        this.lastDateUpdated = lastDateUpdated;
        this.updateFrequency = updateFrequency;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public DateType getLastDateUpdated() {
        return lastDateUpdated;
    }

    public void setLastDateUpdated(DateType lastDateUpdated) {
        this.lastDateUpdated = lastDateUpdated;
    }

    public String getUpdateFrequency() {
        return updateFrequency;
    }

    public void setUpdateFrequency(String updateFrequency) {
        this.updateFrequency = updateFrequency;
    }
}
