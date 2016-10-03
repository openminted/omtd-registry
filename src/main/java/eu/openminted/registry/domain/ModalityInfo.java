package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ModalityInfo {

    //required
	@XmlElement(name = "modalityType")
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
