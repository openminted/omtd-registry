package eu.openminted.registry.domain;

import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class ModalityInfo {

    //required
    private List<ModalityType> modalityTypes;
    private String modalityTypeDetails;
    private SizeInfo sizePerModality;

    public ModalityInfo() {
    }

    public ModalityInfo(List<ModalityType> modalityTypes) {
        this.modalityTypes = modalityTypes;
    }

    public ModalityInfo(List<ModalityType> modalityTypes, String modalityTypeDetails, SizeInfo sizePerModality) {
        this.modalityTypes = modalityTypes;
        this.modalityTypeDetails = modalityTypeDetails;
        this.sizePerModality = sizePerModality;
    }

    public List<ModalityType> getModalityTypes() {
        return modalityTypes;
    }

    public void setModalityTypes(List<ModalityType> modalityTypes) {
        this.modalityTypes = modalityTypes;
    }

    public String getModalityTypeDetails() {
        return modalityTypeDetails;
    }

    public void setModalityTypeDetails(String modalityTypeDetails) {
        this.modalityTypeDetails = modalityTypeDetails;
    }

    public SizeInfo getSizePerModality() {
        return sizePerModality;
    }

    public void setSizePerModality(SizeInfo sizePerModality) {
        this.sizePerModality = sizePerModality;
    }
}
