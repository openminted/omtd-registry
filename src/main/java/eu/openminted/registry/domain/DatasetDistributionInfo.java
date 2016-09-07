package eu.openminted.registry.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class DatasetDistributionInfo {

    enum DistributionMedium {

        WEB_EXECUTABLE("webExecutable"),
        PAPER_COPY("paperCopy"),
        HARD_DISK("hardDisk"),
        BLU_RAY("bluRay"),
        DVD_R("DVD-R"),
        CD_ROM("CD-ROM"),
        DOWNLOADABLE("downloadable"),
        ACCESSIBLE_THROUGH_INTERFACE("accessibleThroughInterface"),
        OTHER("other");

        private String value;

        DistributionMedium(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    //required
    private List<DistributionMedium> distributionMediums;
    private List<String> downloadURLs;
    private List<String> accessURLs;
    private List<TextFormatInfo> textFormats;
    private List<CharacterEncodingInfo> characterEncodings;
    private List<SizeInfo> sizes;
    //required
    private RightsInfo rightsInfo;
    private List<String> copyrightStatements;
    private List<String> attributionTexts;
    private List<ActorInfo> rightsHolders;
    private Date availabilityStartDate;
    private Date availabilityEndDate;
    private String fee;
    private List<UserType> userTypes;

    public DatasetDistributionInfo() {
    }

    public DatasetDistributionInfo(List<DistributionMedium> distributionMediums, RightsInfo rightsInfo) {
        this.distributionMediums = distributionMediums;
        this.rightsInfo = rightsInfo;
    }

    public DatasetDistributionInfo(List<DistributionMedium> distributionMediums, List<String> downloadURLs, List<String> accessURLs,
                                   List<TextFormatInfo> textFormats, List<CharacterEncodingInfo> characterEncodings, List<SizeInfo> sizes,
                                   RightsInfo rightsInfo, List<String> copyrightStatements, List<String> attributionTexts,
                                   List<ActorInfo> rightsHolders, Date availabilityStartDate, Date availabilityEndDate,
                                   String fee, List<UserType> userTypes) {
        this.distributionMediums = distributionMediums;
        this.downloadURLs = downloadURLs;
        this.accessURLs = accessURLs;
        this.textFormats = textFormats;
        this.characterEncodings = characterEncodings;
        this.sizes = sizes;
        this.rightsInfo = rightsInfo;
        this.copyrightStatements = copyrightStatements;
        this.attributionTexts = attributionTexts;
        this.rightsHolders = rightsHolders;
        this.availabilityStartDate = availabilityStartDate;
        this.availabilityEndDate = availabilityEndDate;
        this.fee = fee;
        this.userTypes = userTypes;
    }

    public List<DistributionMedium> getDistributionMediums() {
        return distributionMediums;
    }

    public void setDistributionMediums(List<DistributionMedium> distributionMediums) {
        this.distributionMediums = distributionMediums;
    }

    public List<String> getDownloadURLs() {
        return downloadURLs;
    }

    public void setDownloadURLs(List<String> downloadURLs) {
        this.downloadURLs = downloadURLs;
    }

    public List<String> getAccessURLs() {
        return accessURLs;
    }

    public void setAccessURLs(List<String> accessURLs) {
        this.accessURLs = accessURLs;
    }

    public List<TextFormatInfo> getTextFormats() {
        return textFormats;
    }

    public void setTextFormats(List<TextFormatInfo> textFormats) {
        this.textFormats = textFormats;
    }

    public List<CharacterEncodingInfo> getCharacterEncodings() {
        return characterEncodings;
    }

    public void setCharacterEncodings(List<CharacterEncodingInfo> characterEncodings) {
        this.characterEncodings = characterEncodings;
    }

    public List<SizeInfo> getSizes() {
        return sizes;
    }

    public void setSizes(List<SizeInfo> sizes) {
        this.sizes = sizes;
    }

    public RightsInfo getRightsInfo() {
        return rightsInfo;
    }

    public void setRightsInfo(RightsInfo rightsInfo) {
        this.rightsInfo = rightsInfo;
    }

    public List<String> getCopyrightStatements() {
        return copyrightStatements;
    }

    public void setCopyrightStatements(List<String> copyrightStatements) {
        this.copyrightStatements = copyrightStatements;
    }

    public List<String> getAttributionTexts() {
        return attributionTexts;
    }

    public void setAttributionTexts(List<String> attributionTexts) {
        this.attributionTexts = attributionTexts;
    }

    public List<ActorInfo> getRightsHolders() {
        return rightsHolders;
    }

    public void setRightsHolders(List<ActorInfo> rightsHolders) {
        this.rightsHolders = rightsHolders;
    }

    public Date getAvailabilityStartDate() {
        return availabilityStartDate;
    }

    public void setAvailabilityStartDate(Date availabilityStartDate) {
        this.availabilityStartDate = availabilityStartDate;
    }

    public Date getAvailabilityEndDate() {
        return availabilityEndDate;
    }

    public void setAvailabilityEndDate(Date availabilityEndDate) {
        this.availabilityEndDate = availabilityEndDate;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public List<UserType> getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(List<UserType> userTypes) {
        this.userTypes = userTypes;
    }
}
