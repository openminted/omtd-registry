package eu.openminted.registry.domain;

import eu.openminted.registry.domain.file.FileStats;

import java.util.List;

public class SizeQuota {

    private String personIdentifier;
    private Long totalSize;
    private Long totalSizeOnDisk;
    private List<FileStats> fileStats;
    
    public SizeQuota() {
    }
    
    public SizeQuota(String personIdentifier, Long totalSize, Long totalSizeOnDisk, List<FileStats> fileStats) {
        this.personIdentifier = personIdentifier;
        this.totalSize = totalSize;
        this.totalSizeOnDisk = totalSizeOnDisk;
        this.fileStats = fileStats;
    }

    public SizeQuota(String personIdentifier, List<FileStats> fileStats) {
        assert fileStats != null;
        this.personIdentifier = personIdentifier;
        this.fileStats = fileStats;
        totalSize = fileStats.stream().mapToLong(FileStats::getSize).sum();
        totalSizeOnDisk = fileStats.stream().mapToLong(FileStats::getSizeOnDisk).sum();
    }

    public String getPersonIdentifier() {
        return personIdentifier;
    }

    public void setPersonIdentifier(String personIdentifier) {
        this.personIdentifier = personIdentifier;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public Long getTotalSizeOnDisk() {
        return totalSizeOnDisk;
    }

    public void setTotalSizeOnDisk(Long totalSizeOnDisk) {
        this.totalSizeOnDisk = totalSizeOnDisk;
    }

    public List<FileStats> getFileStats() {
        return fileStats;
    }

    public void setFileStats(List<FileStats> fileStats) {
        this.fileStats = fileStats;
    }
}
