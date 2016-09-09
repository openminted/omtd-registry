package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

/**
 * Created by stefania on 9/5/16.
 */
public class TextClassificationInfo {

    @XmlJavaTypeAdapter(ClassificationSchemeIdentifierAdapter.class)
    private Identifier<ClassificationScheme> textGenre;
    @XmlJavaTypeAdapter(ClassificationSchemeIdentifierAdapter.class)
    private Identifier<ClassificationScheme> textType;
    @XmlJavaTypeAdapter(ClassificationSchemeIdentifierAdapter.class)
    private Identifier<ClassificationScheme> register;
    @XmlJavaTypeAdapter(ClassificationSchemeIdentifierAdapter.class)
    private Identifier<ClassificationScheme> subject;
    @XmlElementWrapper(name="keywords")
    @XmlElement(name="keyword")
    private List<String> keywords;
    private SizeInfo sizePerTextClassification;

    public TextClassificationInfo() {
    }

    public TextClassificationInfo(Identifier<ClassificationScheme> textGenre, Identifier<ClassificationScheme> textType,
                                  Identifier<ClassificationScheme> register, Identifier<ClassificationScheme> subject,
                                  List<String> keywords, SizeInfo sizePerTextClassification) {
        this.textGenre = textGenre;
        this.textType = textType;
        this.register = register;
        this.subject = subject;
        this.keywords = keywords;
        this.sizePerTextClassification = sizePerTextClassification;
    }

    public Identifier<ClassificationScheme> getTextGenre() {
        return textGenre;
    }

    public void setTextGenre(Identifier<ClassificationScheme> textGenre) {
        this.textGenre = textGenre;
    }

    public Identifier<ClassificationScheme> getTextType() {
        return textType;
    }

    public void setTextType(Identifier<ClassificationScheme> textType) {
        this.textType = textType;
    }

    public Identifier<ClassificationScheme> getRegister() {
        return register;
    }

    public void setRegister(Identifier<ClassificationScheme> register) {
        this.register = register;
    }

    public Identifier<ClassificationScheme> getSubject() {
        return subject;
    }

    public void setSubject(Identifier<ClassificationScheme> subject) {
        this.subject = subject;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public SizeInfo getSizePerTextClassification() {
        return sizePerTextClassification;
    }

    public void setSizePerTextClassification(SizeInfo sizePerTextClassification) {
        this.sizePerTextClassification = sizePerTextClassification;
    }
}
