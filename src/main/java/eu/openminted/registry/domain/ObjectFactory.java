
package eu.openminted.registry.domain;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.openminted.registry.domain package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Date_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "date");
    private final static QName _EndDate_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "endDate");
    private final static QName _StartDate_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "startDate");
    private final static QName _DateRange_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "dateRange");
    private final static QName _MetadataHeaderInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "metadataHeaderInfo");
    private final static QName _PersonInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "personInfo");
    private final static QName _CommunicationInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "communicationInfo");
    private final static QName _OrganizationInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "organizationInfo");
    private final static QName _Sex_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "sex");
    private final static QName _ProjectInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "projectInfo");
    private final static QName _TextFormatInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "textFormatInfo");
    private final static QName _StructuralEncodingInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "structuralEncodingInfo");
    private final static QName _TextClassificationInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "textClassificationInfo");
    private final static QName _DocumentDistributionInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "documentDistributionInfo");
    private final static QName _DatasetDistributionInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "datasetDistributionInfo");
    private final static QName _ComponentDistributionInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "componentDistributionInfo");
    private final static QName _LicenceInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "licenceInfo");
    private final static QName _RightsStatementInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "rightsStatementInfo");
    private final static QName _DistributionMedium_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "distributionMedium");
    private final static QName _DownloadURL_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "downloadURL");
    private final static QName _AccessURL_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "accessURL");
    private final static QName _RightsHolder_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "rightsHolder");
    private final static QName _AvailabilityStartDate_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "availabilityStartDate");
    private final static QName _AvailabilityEndDate_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "availabilityEndDate");
    private final static QName _Fee_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "fee");
    private final static QName _UserType_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "userType");
    private final static QName _Language_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "language");
    private final static QName _UsageInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "usageInfo");
    private final static QName _ForeseenUseInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "foreseenUseInfo");
    private final static QName _ActualUseInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "actualUseInfo");
    private final static QName _IdentificationInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "identificationInfo");
    private final static QName _ContactInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "contactInfo");
    private final static QName _VersionInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "versionInfo");
    private final static QName _ValidationInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "validationInfo");
    private final static QName _ResourceCreationInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "resourceCreationInfo");
    private final static QName _ResourceDocumentationInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "resourceDocumentationInfo");
    private final static QName _DomainInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "domainInfo");
    private final static QName _AnnotationInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "annotationInfo");
    private final static QName _ModalityInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "modalityInfo");
    private final static QName _CreationInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "creationInfo");
    private final static QName _RunningEnvironmentInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "runningEnvironmentInfo");
    private final static QName _TheoreticModel_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "theoreticModel");
    private final static QName _HasOriginalSource_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "hasOriginalSource");
    private final static QName _CharacterEncodingInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "characterEncodingInfo");
    private final static QName _TimeCoverageInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "timeCoverageInfo");
    private final static QName _GeographicCoverageInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "geographicCoverageInfo");
    private final static QName _LingualityInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "lingualityInfo");
    private final static QName _LanguageInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "languageInfo");
    private final static QName _MetalanguageInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "metalanguageInfo");
    private final static QName _LanguageVarietyInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "languageVarietyInfo");
    private final static QName _LanguageVarietyName_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "languageVarietyName");
    private final static QName _ModalityType_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "modalityType");
    private final static QName _MediaType_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "mediaType");
    private final static QName _CharacterEncoding_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "characterEncoding");
    private final static QName _AnnotationLevel_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "annotationLevel");
    private final static QName _UseNLPSpecific_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "useNLPSpecific");
    private final static QName _Tagset_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "tagset");
    private final static QName _Typesystem_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "typesystem");
    private final static QName _MimeType_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "mimeType");
    private final static QName _SizeInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "sizeInfo");
    private final static QName _Size_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "size");
    private final static QName _Keyword_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "keyword");
    private final static QName _EncodingLevel_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "encodingLevel");
    private final static QName _ComponentInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "componentInfo");
    private final static QName _ComponentEvaluationInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "componentEvaluationInfo");
    private final static QName _ComponentOperationInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "componentOperationInfo");
    private final static QName _ComponentCreationInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "componentCreationInfo");
    private final static QName _ComponentDocumentationInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "componentDocumentationInfo");
    private final static QName _AnnotationResource_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "annotationResource");
    private final static QName _CorpusInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "corpusInfo");
    private final static QName _CorpusTextPartInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "corpusTextPartInfo");
    private final static QName _RawCorpusInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "rawCorpusInfo");
    private final static QName _AnnotatedCorpusInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "annotatedCorpusInfo");
    private final static QName _AnnotationsInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "annotationsInfo");
    private final static QName _LanguageDescriptionInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "languageDescriptionInfo");
    private final static QName _LanguageDescriptionEncodingInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "languageDescriptionEncodingInfo");
    private final static QName _LanguageDescriptionOperationInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "languageDescriptionOperationInfo");
    private final static QName _LanguageDescriptionPerformanceInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "languageDescriptionPerformanceInfo");
    private final static QName _LanguageDescriptionTextInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "languageDescriptionTextInfo");
    private final static QName _LexicalConceptualResourceInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "lexicalConceptualResourceInfo");
    private final static QName _LexicalConceptualResourceEncodingInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "lexicalConceptualResourceEncodingInfo");
    private final static QName _LexicalConceptualResourceTextInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "lexicalConceptualResourceTextInfo");
    private final static QName _ModelInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "modelInfo");
    private final static QName _ModelTextInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "modelTextInfo");
    private final static QName _DocumentMetadataRecord_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "documentMetadataRecord");
    private final static QName _Publication_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "publication");
    private final static QName _AnnotatedPublication_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "annotatedPublication");
    private final static QName _Publisher_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "publisher");
    private final static QName _Journal_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "journal");
    private final static QName _Repository_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "repository");
    private final static QName _RelationInfo_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "relationInfo");
    private final static QName _ContactInfoContactEmail_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "contactEmail");
    private final static QName _ContactInfoLandingPage_QNAME = new QName("http://www.meta-share.org/OMTD-SHARE_XMLSchema", "landingPage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.openminted.registry.domain
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Date }
     * 
     */
    public Date createDate() {
        return new Date();
    }

    /**
     * Create an instance of {@link DateRange }
     * 
     */
    public DateRange createDateRange() {
        return new DateRange();
    }

    /**
     * Create an instance of {@link Subject }
     * 
     */
    public Subject createSubject() {
        return new Subject();
    }

    /**
     * Create an instance of {@link MetadataHeaderInfo }
     * 
     */
    public MetadataHeaderInfo createMetadataHeaderInfo() {
        return new MetadataHeaderInfo();
    }

    /**
     * Create an instance of {@link PersonInfo }
     * 
     */
    public PersonInfo createPersonInfo() {
        return new PersonInfo();
    }

    /**
     * Create an instance of {@link CommunicationInfo }
     * 
     */
    public CommunicationInfo createCommunicationInfo() {
        return new CommunicationInfo();
    }

    /**
     * Create an instance of {@link OrganizationInfo }
     * 
     */
    public OrganizationInfo createOrganizationInfo() {
        return new OrganizationInfo();
    }

    /**
     * Create an instance of {@link ProjectInfo }
     * 
     */
    public ProjectInfo createProjectInfo() {
        return new ProjectInfo();
    }

    /**
     * Create an instance of {@link TextFormatInfo }
     * 
     */
    public TextFormatInfo createTextFormatInfo() {
        return new TextFormatInfo();
    }

    /**
     * Create an instance of {@link StructuralEncodingInfo }
     * 
     */
    public StructuralEncodingInfo createStructuralEncodingInfo() {
        return new StructuralEncodingInfo();
    }

    /**
     * Create an instance of {@link TextGenre }
     * 
     */
    public TextGenre createTextGenre() {
        return new TextGenre();
    }

    /**
     * Create an instance of {@link Text }
     * 
     */
    public Text createText() {
        return new Text();
    }

    /**
     * Create an instance of {@link TextClassificationInfo }
     * 
     */
    public TextClassificationInfo createTextClassificationInfo() {
        return new TextClassificationInfo();
    }

    /**
     * Create an instance of {@link DocumentDistributionInfo }
     * 
     */
    public DocumentDistributionInfo createDocumentDistributionInfo() {
        return new DocumentDistributionInfo();
    }

    /**
     * Create an instance of {@link DatasetDistributionInfo }
     * 
     */
    public DatasetDistributionInfo createDatasetDistributionInfo() {
        return new DatasetDistributionInfo();
    }

    /**
     * Create an instance of {@link ComponentDistributionInfo }
     * 
     */
    public ComponentDistributionInfo createComponentDistributionInfo() {
        return new ComponentDistributionInfo();
    }

    /**
     * Create an instance of {@link LicenceInfo }
     * 
     */
    public LicenceInfo createLicenceInfo() {
        return new LicenceInfo();
    }

    /**
     * Create an instance of {@link RightsStatementInfo }
     * 
     */
    public RightsStatementInfo createRightsStatementInfo() {
        return new RightsStatementInfo();
    }

    /**
     * Create an instance of {@link RightsInfo }
     * 
     */
    public RightsInfo createRightsInfo() {
        return new RightsInfo();
    }

    /**
     * Create an instance of {@link CopyrightStatement }
     * 
     */
    public CopyrightStatement createCopyrightStatement() {
        return new CopyrightStatement();
    }

    /**
     * Create an instance of {@link AttributionText }
     * 
     */
    public AttributionText createAttributionText() {
        return new AttributionText();
    }

    /**
     * Create an instance of {@link ActorInfo }
     * 
     */
    public ActorInfo createActorInfo() {
        return new ActorInfo();
    }

    /**
     * Create an instance of {@link Language }
     * 
     */
    public Language createLanguage() {
        return new Language();
    }

    /**
     * Create an instance of {@link UsageInfo }
     * 
     */
    public UsageInfo createUsageInfo() {
        return new UsageInfo();
    }

    /**
     * Create an instance of {@link ForeseenUseInfo }
     * 
     */
    public ForeseenUseInfo createForeseenUseInfo() {
        return new ForeseenUseInfo();
    }

    /**
     * Create an instance of {@link ActualUseInfo }
     * 
     */
    public ActualUseInfo createActualUseInfo() {
        return new ActualUseInfo();
    }

    /**
     * Create an instance of {@link IdentificationInfo }
     * 
     */
    public IdentificationInfo createIdentificationInfo() {
        return new IdentificationInfo();
    }

    /**
     * Create an instance of {@link ContactInfo }
     * 
     */
    public ContactInfo createContactInfo() {
        return new ContactInfo();
    }

    /**
     * Create an instance of {@link VersionInfo }
     * 
     */
    public VersionInfo createVersionInfo() {
        return new VersionInfo();
    }

    /**
     * Create an instance of {@link ValidationInfo }
     * 
     */
    public ValidationInfo createValidationInfo() {
        return new ValidationInfo();
    }

    /**
     * Create an instance of {@link ResourceCreationInfo }
     * 
     */
    public ResourceCreationInfo createResourceCreationInfo() {
        return new ResourceCreationInfo();
    }

    /**
     * Create an instance of {@link ResourceDocumentationInfo }
     * 
     */
    public ResourceDocumentationInfo createResourceDocumentationInfo() {
        return new ResourceDocumentationInfo();
    }

    /**
     * Create an instance of {@link DomainInfoType }
     * 
     */
    public DomainInfoType createDomainInfoType() {
        return new DomainInfoType();
    }

    /**
     * Create an instance of {@link AnnotationInfo }
     * 
     */
    public AnnotationInfo createAnnotationInfo() {
        return new AnnotationInfo();
    }

    /**
     * Create an instance of {@link Domain }
     * 
     */
    public Domain createDomain() {
        return new Domain();
    }

    /**
     * Create an instance of {@link ModalityInfo }
     * 
     */
    public ModalityInfo createModalityInfo() {
        return new ModalityInfo();
    }

    /**
     * Create an instance of {@link CreationInfo }
     * 
     */
    public CreationInfo createCreationInfo() {
        return new CreationInfo();
    }

    /**
     * Create an instance of {@link RunningEnvironmentInfo }
     * 
     */
    public RunningEnvironmentInfo createRunningEnvironmentInfo() {
        return new RunningEnvironmentInfo();
    }

    /**
     * Create an instance of {@link ResourceIdentifier }
     * 
     */
    public ResourceIdentifier createResourceIdentifier() {
        return new ResourceIdentifier();
    }

    /**
     * Create an instance of {@link CharacterEncodingInfo }
     * 
     */
    public CharacterEncodingInfo createCharacterEncodingInfo() {
        return new CharacterEncodingInfo();
    }

    /**
     * Create an instance of {@link TimeCoverageInfo }
     * 
     */
    public TimeCoverageInfo createTimeCoverageInfo() {
        return new TimeCoverageInfo();
    }

    /**
     * Create an instance of {@link GeographicCoverageInfo }
     * 
     */
    public GeographicCoverageInfo createGeographicCoverageInfo() {
        return new GeographicCoverageInfo();
    }

    /**
     * Create an instance of {@link LingualityInfo }
     * 
     */
    public LingualityInfo createLingualityInfo() {
        return new LingualityInfo();
    }

    /**
     * Create an instance of {@link LanguageInfo }
     * 
     */
    public LanguageInfo createLanguageInfo() {
        return new LanguageInfo();
    }

    /**
     * Create an instance of {@link LanguageVarietyInfo }
     * 
     */
    public LanguageVarietyInfo createLanguageVarietyInfo() {
        return new LanguageVarietyInfo();
    }

    /**
     * Create an instance of {@link RelatedResource }
     * 
     */
    public RelatedResource createRelatedResource() {
        return new RelatedResource();
    }

    /**
     * Create an instance of {@link DataFormat }
     * 
     */
    public DataFormat createDataFormat() {
        return new DataFormat();
    }

    /**
     * Create an instance of {@link SizeInfo }
     * 
     */
    public SizeInfo createSizeInfo() {
        return new SizeInfo();
    }

    /**
     * Create an instance of {@link Register }
     * 
     */
    public Register createRegister() {
        return new Register();
    }

    /**
     * Create an instance of {@link Component }
     * 
     */
    public Component createComponent() {
        return new Component();
    }

    /**
     * Create an instance of {@link ComponentInfo }
     * 
     */
    public ComponentInfo createComponentInfo() {
        return new ComponentInfo();
    }

    /**
     * Create an instance of {@link ComponentEvaluationInfo }
     * 
     */
    public ComponentEvaluationInfo createComponentEvaluationInfo() {
        return new ComponentEvaluationInfo();
    }

    /**
     * Create an instance of {@link ComponentOperationInfo }
     * 
     */
    public ComponentOperationInfo createComponentOperationInfo() {
        return new ComponentOperationInfo();
    }

    /**
     * Create an instance of {@link ComponentCreationInfo }
     * 
     */
    public ComponentCreationInfo createComponentCreationInfo() {
        return new ComponentCreationInfo();
    }

    /**
     * Create an instance of {@link ComponentDocumentationInfo }
     * 
     */
    public ComponentDocumentationInfo createComponentDocumentationInfo() {
        return new ComponentDocumentationInfo();
    }

    /**
     * Create an instance of {@link Corpus }
     * 
     */
    public Corpus createCorpus() {
        return new Corpus();
    }

    /**
     * Create an instance of {@link CorpusInfo }
     * 
     */
    public CorpusInfo createCorpusInfo() {
        return new CorpusInfo();
    }

    /**
     * Create an instance of {@link CorpusTextPartInfo }
     * 
     */
    public CorpusTextPartInfo createCorpusTextPartInfo() {
        return new CorpusTextPartInfo();
    }

    /**
     * Create an instance of {@link RawCorpusInfo }
     * 
     */
    public RawCorpusInfo createRawCorpusInfo() {
        return new RawCorpusInfo();
    }

    /**
     * Create an instance of {@link AnnotatedCorpusInfo }
     * 
     */
    public AnnotatedCorpusInfo createAnnotatedCorpusInfo() {
        return new AnnotatedCorpusInfo();
    }

    /**
     * Create an instance of {@link AnnotationsInfo }
     * 
     */
    public AnnotationsInfo createAnnotationsInfo() {
        return new AnnotationsInfo();
    }

    /**
     * Create an instance of {@link LanguageDescription }
     * 
     */
    public LanguageDescription createLanguageDescription() {
        return new LanguageDescription();
    }

    /**
     * Create an instance of {@link LanguageDescriptionInfo }
     * 
     */
    public LanguageDescriptionInfo createLanguageDescriptionInfo() {
        return new LanguageDescriptionInfo();
    }

    /**
     * Create an instance of {@link LanguageDescriptionEncodingInfo }
     * 
     */
    public LanguageDescriptionEncodingInfo createLanguageDescriptionEncodingInfo() {
        return new LanguageDescriptionEncodingInfo();
    }

    /**
     * Create an instance of {@link LanguageDescriptionOperationInfo }
     * 
     */
    public LanguageDescriptionOperationInfo createLanguageDescriptionOperationInfo() {
        return new LanguageDescriptionOperationInfo();
    }

    /**
     * Create an instance of {@link LanguageDescriptionPerformanceInfo }
     * 
     */
    public LanguageDescriptionPerformanceInfo createLanguageDescriptionPerformanceInfo() {
        return new LanguageDescriptionPerformanceInfo();
    }

    /**
     * Create an instance of {@link LanguageDescriptionTextInfo }
     * 
     */
    public LanguageDescriptionTextInfo createLanguageDescriptionTextInfo() {
        return new LanguageDescriptionTextInfo();
    }

    /**
     * Create an instance of {@link Lexical }
     * 
     */
    public Lexical createLexical() {
        return new Lexical();
    }

    /**
     * Create an instance of {@link LexicalConceptualResourceInfo }
     * 
     */
    public LexicalConceptualResourceInfo createLexicalConceptualResourceInfo() {
        return new LexicalConceptualResourceInfo();
    }

    /**
     * Create an instance of {@link LexicalConceptualResourceEncodingInfo }
     * 
     */
    public LexicalConceptualResourceEncodingInfo createLexicalConceptualResourceEncodingInfo() {
        return new LexicalConceptualResourceEncodingInfo();
    }

    /**
     * Create an instance of {@link LexicalConceptualResourceTextInfo }
     * 
     */
    public LexicalConceptualResourceTextInfo createLexicalConceptualResourceTextInfo() {
        return new LexicalConceptualResourceTextInfo();
    }

    /**
     * Create an instance of {@link Model }
     * 
     */
    public Model createModel() {
        return new Model();
    }

    /**
     * Create an instance of {@link ModelInfo }
     * 
     */
    public ModelInfo createModelInfo() {
        return new ModelInfo();
    }

    /**
     * Create an instance of {@link ModelTextInfo }
     * 
     */
    public ModelTextInfo createModelTextInfo() {
        return new ModelTextInfo();
    }

    /**
     * Create an instance of {@link DocumentMetadataRecord }
     * 
     */
    public DocumentMetadataRecord createDocumentMetadataRecord() {
        return new DocumentMetadataRecord();
    }

    /**
     * Create an instance of {@link DocumentInfo }
     * 
     */
    public DocumentInfo createDocumentInfo() {
        return new DocumentInfo();
    }

    /**
     * Create an instance of {@link AnnotatedDocumentInfo }
     * 
     */
    public AnnotatedDocumentInfo createAnnotatedDocumentInfo() {
        return new AnnotatedDocumentInfo();
    }

    /**
     * Create an instance of {@link RelatedJournal }
     * 
     */
    public RelatedJournal createRelatedJournal() {
        return new RelatedJournal();
    }

    /**
     * Create an instance of {@link RelatedRepository }
     * 
     */
    public RelatedRepository createRelatedRepository() {
        return new RelatedRepository();
    }

    /**
     * Create an instance of {@link RelationInfo }
     * 
     */
    public RelationInfo createRelationInfo() {
        return new RelationInfo();
    }

    /**
     * Create an instance of {@link MyString }
     * 
     */
    public MyString createMyString() {
        return new MyString();
    }

    /**
     * Create an instance of {@link DateCombination }
     * 
     */
    public DateCombination createDateCombination() {
        return new DateCombination();
    }

    /**
     * Create an instance of {@link MetadataIdentifier }
     * 
     */
    public MetadataIdentifier createMetadataIdentifier() {
        return new MetadataIdentifier();
    }

    /**
     * Create an instance of {@link PublicationIdentifier }
     * 
     */
    public PublicationIdentifier createPublicationIdentifier() {
        return new PublicationIdentifier();
    }

    /**
     * Create an instance of {@link JournalIdentifier }
     * 
     */
    public JournalIdentifier createJournalIdentifier() {
        return new JournalIdentifier();
    }

    /**
     * Create an instance of {@link RepositoryIdentifier }
     * 
     */
    public RepositoryIdentifier createRepositoryIdentifier() {
        return new RepositoryIdentifier();
    }

    /**
     * Create an instance of {@link PersonIdentifier }
     * 
     */
    public PersonIdentifier createPersonIdentifier() {
        return new PersonIdentifier();
    }

    /**
     * Create an instance of {@link OrganizationIdentifier }
     * 
     */
    public OrganizationIdentifier createOrganizationIdentifier() {
        return new OrganizationIdentifier();
    }

    /**
     * Create an instance of {@link ProjectIdentifier }
     * 
     */
    public ProjectIdentifier createProjectIdentifier() {
        return new ProjectIdentifier();
    }

    /**
     * Create an instance of {@link RelatedPerson }
     * 
     */
    public RelatedPerson createRelatedPerson() {
        return new RelatedPerson();
    }

    /**
     * Create an instance of {@link RelatedOrganization }
     * 
     */
    public RelatedOrganization createRelatedOrganization() {
        return new RelatedOrganization();
    }

    /**
     * Create an instance of {@link RelatedGroup }
     * 
     */
    public RelatedGroup createRelatedGroup() {
        return new RelatedGroup();
    }

    /**
     * Create an instance of {@link RelatedProject }
     * 
     */
    public RelatedProject createRelatedProject() {
        return new RelatedProject();
    }

    /**
     * Create an instance of {@link RelatedDocumentInfo }
     * 
     */
    public RelatedDocumentInfo createRelatedDocumentInfo() {
        return new RelatedDocumentInfo();
    }

    /**
     * Create an instance of {@link MailingListInfo }
     * 
     */
    public MailingListInfo createMailingListInfo() {
        return new MailingListInfo();
    }

    /**
     * Create an instance of {@link ProcessingResourceInfo }
     * 
     */
    public ProcessingResourceInfo createProcessingResourceInfo() {
        return new ProcessingResourceInfo();
    }

    /**
     * Create an instance of {@link RelatedLexiconInfo }
     * 
     */
    public RelatedLexiconInfo createRelatedLexiconInfo() {
        return new RelatedLexiconInfo();
    }

    /**
     * Create an instance of {@link JournalInfo }
     * 
     */
    public JournalInfo createJournalInfo() {
        return new JournalInfo();
    }

    /**
     * Create an instance of {@link JournalTitle }
     * 
     */
    public JournalTitle createJournalTitle() {
        return new JournalTitle();
    }


    /**
     * Create an instance of {@link ProjectName }
     * 
     */
    public ProjectName createProjectName() {
        return new ProjectName();
    }

    /**
     * Create an instance of {@link GroupName }
     * 
     */
    public GroupName createGroupName() {
        return new GroupName();
    }


    /**
     * Create an instance of {@link OrganizationName }
     * 
     */
    public OrganizationName createOrganizationName() {
        return new OrganizationName();
    }


    /**
     * Create an instance of {@link PersonName }
     * 
     */
    public PersonName createPersonName() {
        return new PersonName();
    }


    /**
     * Create an instance of {@link RepositoryName }
     * 
     */
    public RepositoryName createRepositoryName() {
        return new RepositoryName();
    }

    /**
     * Create an instance of {@link Abstract }
     * 
     */
    public Abstract createAbstract() {
        return new Abstract();
    }

    /**
     * Create an instance of {@link Contributor }
     * 
     */
    public Contributor createContributor() {
        return new Contributor();
    }


    /**
     * Create an instance of {@link Title }
     * 
     */
    public Title createTitle() {
        return new Title();
    }

    /**
     * Create an instance of {@link Document }
     * 
     */
    public Document createDocument() {
        return new Document();
    }

    /**
     * Create an instance of {@link ModelOperationInfo }
     * 
     */
    public ModelOperationInfo createModelOperationInfo() {
        return new ModelOperationInfo();
    }

    /**
     * Create an instance of {@link ModelMediaType }
     * 
     */
    public ModelMediaType createModelMediaType() {
        return new ModelMediaType();
    }

    /**
     * Create an instance of {@link LexicalConceptualResourceMediaType }
     * 
     */
    public LexicalConceptualResourceMediaType createLexicalConceptualResourceMediaType() {
        return new LexicalConceptualResourceMediaType();
    }

    /**
     * Create an instance of {@link Formalisms }
     * 
     */
    public Formalisms createFormalisms() {
        return new Formalisms();
    }

    /**
     * Create an instance of {@link GrammaticalPhenomenaCoverages }
     * 
     */
    public GrammaticalPhenomenaCoverages createGrammaticalPhenomenaCoverages() {
        return new GrammaticalPhenomenaCoverages();
    }

    /**
     * Create an instance of {@link LanguageDescriptionMediaType }
     * 
     */
    public LanguageDescriptionMediaType createLanguageDescriptionMediaType() {
        return new LanguageDescriptionMediaType();
    }

    /**
     * Create an instance of {@link CorpusMediaParts }
     * 
     */
    public CorpusMediaParts createCorpusMediaParts() {
        return new CorpusMediaParts();
    }

    /**
     * Create an instance of {@link CorpusMediaPartsType }
     * 
     */
    public CorpusMediaPartsType createCorpusMediaPartsType() {
        return new CorpusMediaPartsType();
    }

    /**
     * Create an instance of {@link CorpusSubtypeSpecificInfo }
     * 
     */
    public CorpusSubtypeSpecificInfo createCorpusSubtypeSpecificInfo() {
        return new CorpusSubtypeSpecificInfo();
    }

    /**
     * Create an instance of {@link ComponentDependencies }
     * 
     */
    public ComponentDependencies createComponentDependencies() {
        return new ComponentDependencies();
    }


    /**
     * Create an instance of {@link ResourceName }
     * 
     */
    public ResourceName createResourceName() {
        return new ResourceName();
    }

    /**
     * Create an instance of {@link ResourceShortName }
     * 
     */
    public ResourceShortName createResourceShortName() {
        return new ResourceShortName();
    }

    /**
     * Create an instance of {@link Description }
     * 
     */
    public Description createDescription() {
        return new Description();
    }


    /**
     * Create an instance of {@link LicenceInfos }
     * 
     */
    public LicenceInfos createLicenceInfos() {
        return new LicenceInfos();
    }

    /**
     * Create an instance of {@link NonStandardLicenceName }
     * 
     */
    public NonStandardLicenceName createNonStandardLicenceName() {
        return new NonStandardLicenceName();
    }

    /**
     * Create an instance of {@link NonStandaradLicenceTermsText }
     * 
     */
    public NonStandaradLicenceTermsText createNonStandaradLicenceTermsText() {
        return new NonStandaradLicenceTermsText();
    }

    /**
     * Create an instance of {@link FullText }
     * 
     */
    public FullText createFullText() {
        return new FullText();
    }

    /**
     * Create an instance of {@link StructuralEncoding }
     * 
     */
    public StructuralEncoding createStructuralEncoding() {
        return new StructuralEncoding();
    }

    /**
     * Create an instance of {@link ProjectShortName }
     * 
     */
    public ProjectShortName createProjectShortName() {
        return new ProjectShortName();
    }


    /**
     * Create an instance of {@link DepartmentName }
     * 
     */
    public DepartmentName createDepartmentName() {
        return new DepartmentName();
    }

    /**
     * Create an instance of {@link OrganizationAlternativeName }
     * 
     */
    public OrganizationAlternativeName createOrganizationAlternativeName() {
        return new OrganizationAlternativeName();
    }


    /**
     * Create an instance of {@link PostalAddress }
     * 
     */
    public PostalAddress createPostalAddress() {
        return new PostalAddress();
    }


    /**
     * Create an instance of {@link Affiliation }
     * 
     */
    public Affiliation createAffiliation() {
        return new Affiliation();
    }

    /**
     * Create an instance of {@link Name }
     * 
     */
    public Name createName() {
        return new Name();
    }

    /**
     * Create an instance of {@link GivenName }
     * 
     */
    public GivenName createGivenName() {
        return new GivenName();
    }

    /**
     * Create an instance of {@link Surname }
     * 
     */
    public Surname createSurname() {
        return new Surname();
    }

    /**
     * Create an instance of {@link SourceOfMetadataRecord }
     * 
     */
    public SourceOfMetadataRecord createSourceOfMetadataRecord() {
        return new SourceOfMetadataRecord();
    }

    /**
     * Create an instance of {@link OriginalDataProviderInfo }
     * 
     */
    public OriginalDataProviderInfo createOriginalDataProviderInfo() {
        return new OriginalDataProviderInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Date }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "date")
    public JAXBElement<Date> createDate(Date value) {
        return new JAXBElement<Date>(_Date_QNAME, Date.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Date }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "endDate")
    public JAXBElement<Date> createEndDate(Date value) {
        return new JAXBElement<Date>(_EndDate_QNAME, Date.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Date }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "startDate")
    public JAXBElement<Date> createStartDate(Date value) {
        return new JAXBElement<Date>(_StartDate_QNAME, Date.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateRange }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "dateRange")
    public JAXBElement<DateRange> createDateRange(DateRange value) {
        return new JAXBElement<DateRange>(_DateRange_QNAME, DateRange.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MetadataHeaderInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "metadataHeaderInfo")
    public JAXBElement<MetadataHeaderInfo> createMetadataHeaderInfo(MetadataHeaderInfo value) {
        return new JAXBElement<MetadataHeaderInfo>(_MetadataHeaderInfo_QNAME, MetadataHeaderInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "personInfo")
    public JAXBElement<PersonInfo> createPersonInfo(PersonInfo value) {
        return new JAXBElement<PersonInfo>(_PersonInfo_QNAME, PersonInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommunicationInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "communicationInfo")
    public JAXBElement<CommunicationInfo> createCommunicationInfo(CommunicationInfo value) {
        return new JAXBElement<CommunicationInfo>(_CommunicationInfo_QNAME, CommunicationInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "organizationInfo")
    public JAXBElement<OrganizationInfo> createOrganizationInfo(OrganizationInfo value) {
        return new JAXBElement<OrganizationInfo>(_OrganizationInfo_QNAME, OrganizationInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SexEnum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "sex")
    public JAXBElement<SexEnum> createSex(SexEnum value) {
        return new JAXBElement<SexEnum>(_Sex_QNAME, SexEnum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProjectInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "projectInfo")
    public JAXBElement<ProjectInfo> createProjectInfo(ProjectInfo value) {
        return new JAXBElement<ProjectInfo>(_ProjectInfo_QNAME, ProjectInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextFormatInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "textFormatInfo")
    public JAXBElement<TextFormatInfo> createTextFormatInfo(TextFormatInfo value) {
        return new JAXBElement<TextFormatInfo>(_TextFormatInfo_QNAME, TextFormatInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StructuralEncodingInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "structuralEncodingInfo")
    public JAXBElement<StructuralEncodingInfo> createStructuralEncodingInfo(StructuralEncodingInfo value) {
        return new JAXBElement<StructuralEncodingInfo>(_StructuralEncodingInfo_QNAME, StructuralEncodingInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextClassificationInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "textClassificationInfo")
    public JAXBElement<TextClassificationInfo> createTextClassificationInfo(TextClassificationInfo value) {
        return new JAXBElement<TextClassificationInfo>(_TextClassificationInfo_QNAME, TextClassificationInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentDistributionInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "documentDistributionInfo")
    public JAXBElement<DocumentDistributionInfo> createDocumentDistributionInfo(DocumentDistributionInfo value) {
        return new JAXBElement<DocumentDistributionInfo>(_DocumentDistributionInfo_QNAME, DocumentDistributionInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatasetDistributionInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "datasetDistributionInfo")
    public JAXBElement<DatasetDistributionInfo> createDatasetDistributionInfo(DatasetDistributionInfo value) {
        return new JAXBElement<DatasetDistributionInfo>(_DatasetDistributionInfo_QNAME, DatasetDistributionInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComponentDistributionInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "componentDistributionInfo")
    public JAXBElement<ComponentDistributionInfo> createComponentDistributionInfo(ComponentDistributionInfo value) {
        return new JAXBElement<ComponentDistributionInfo>(_ComponentDistributionInfo_QNAME, ComponentDistributionInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LicenceInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "licenceInfo")
    public JAXBElement<LicenceInfo> createLicenceInfo(LicenceInfo value) {
        return new JAXBElement<LicenceInfo>(_LicenceInfo_QNAME, LicenceInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RightsStatementInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "rightsStatementInfo")
    public JAXBElement<RightsStatementInfo> createRightsStatementInfo(RightsStatementInfo value) {
        return new JAXBElement<RightsStatementInfo>(_RightsStatementInfo_QNAME, RightsStatementInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DistributionMediumEnum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "distributionMedium")
    public JAXBElement<DistributionMediumEnum> createDistributionMedium(DistributionMediumEnum value) {
        return new JAXBElement<DistributionMediumEnum>(_DistributionMedium_QNAME, DistributionMediumEnum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "downloadURL")
    public JAXBElement<String> createDownloadURL(String value) {
        return new JAXBElement<String>(_DownloadURL_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "accessURL")
    public JAXBElement<String> createAccessURL(String value) {
        return new JAXBElement<String>(_AccessURL_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActorInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "rightsHolder")
    public JAXBElement<ActorInfo> createRightsHolder(ActorInfo value) {
        return new JAXBElement<ActorInfo>(_RightsHolder_QNAME, ActorInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "availabilityStartDate")
    public JAXBElement<XMLGregorianCalendar> createAvailabilityStartDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_AvailabilityStartDate_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "availabilityEndDate")
    public JAXBElement<XMLGregorianCalendar> createAvailabilityEndDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_AvailabilityEndDate_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "fee")
    public JAXBElement<String> createFee(String value) {
        return new JAXBElement<String>(_Fee_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserTypeEnum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "userType")
    public JAXBElement<UserTypeEnum> createUserType(UserTypeEnum value) {
        return new JAXBElement<UserTypeEnum>(_UserType_QNAME, UserTypeEnum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Language }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "language")
    public JAXBElement<Language> createLanguage(Language value) {
        return new JAXBElement<Language>(_Language_QNAME, Language.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsageInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "usageInfo")
    public JAXBElement<UsageInfo> createUsageInfo(UsageInfo value) {
        return new JAXBElement<UsageInfo>(_UsageInfo_QNAME, UsageInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ForeseenUseInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "foreseenUseInfo")
    public JAXBElement<ForeseenUseInfo> createForeseenUseInfo(ForeseenUseInfo value) {
        return new JAXBElement<ForeseenUseInfo>(_ForeseenUseInfo_QNAME, ForeseenUseInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualUseInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "actualUseInfo")
    public JAXBElement<ActualUseInfo> createActualUseInfo(ActualUseInfo value) {
        return new JAXBElement<ActualUseInfo>(_ActualUseInfo_QNAME, ActualUseInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "identificationInfo")
    public JAXBElement<IdentificationInfo> createIdentificationInfo(IdentificationInfo value) {
        return new JAXBElement<IdentificationInfo>(_IdentificationInfo_QNAME, IdentificationInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContactInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "contactInfo")
    public JAXBElement<ContactInfo> createContactInfo(ContactInfo value) {
        return new JAXBElement<ContactInfo>(_ContactInfo_QNAME, ContactInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VersionInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "versionInfo")
    public JAXBElement<VersionInfo> createVersionInfo(VersionInfo value) {
        return new JAXBElement<VersionInfo>(_VersionInfo_QNAME, VersionInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidationInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "validationInfo")
    public JAXBElement<ValidationInfo> createValidationInfo(ValidationInfo value) {
        return new JAXBElement<ValidationInfo>(_ValidationInfo_QNAME, ValidationInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResourceCreationInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "resourceCreationInfo")
    public JAXBElement<ResourceCreationInfo> createResourceCreationInfo(ResourceCreationInfo value) {
        return new JAXBElement<ResourceCreationInfo>(_ResourceCreationInfo_QNAME, ResourceCreationInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResourceDocumentationInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "resourceDocumentationInfo")
    public JAXBElement<ResourceDocumentationInfo> createResourceDocumentationInfo(ResourceDocumentationInfo value) {
        return new JAXBElement<ResourceDocumentationInfo>(_ResourceDocumentationInfo_QNAME, ResourceDocumentationInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DomainInfoType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "domainInfo")
    public JAXBElement<DomainInfoType> createDomainInfo(DomainInfoType value) {
        return new JAXBElement<DomainInfoType>(_DomainInfo_QNAME, DomainInfoType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnnotationInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "annotationInfo")
    public JAXBElement<AnnotationInfo> createAnnotationInfo(AnnotationInfo value) {
        return new JAXBElement<AnnotationInfo>(_AnnotationInfo_QNAME, AnnotationInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModalityInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "modalityInfo")
    public JAXBElement<ModalityInfo> createModalityInfo(ModalityInfo value) {
        return new JAXBElement<ModalityInfo>(_ModalityInfo_QNAME, ModalityInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreationInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "creationInfo")
    public JAXBElement<CreationInfo> createCreationInfo(CreationInfo value) {
        return new JAXBElement<CreationInfo>(_CreationInfo_QNAME, CreationInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RunningEnvironmentInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "runningEnvironmentInfo")
    public JAXBElement<RunningEnvironmentInfo> createRunningEnvironmentInfo(RunningEnvironmentInfo value) {
        return new JAXBElement<RunningEnvironmentInfo>(_RunningEnvironmentInfo_QNAME, RunningEnvironmentInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "theoreticModel")
    public JAXBElement<String> createTheoreticModel(String value) {
        return new JAXBElement<String>(_TheoreticModel_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResourceIdentifier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "hasOriginalSource")
    public JAXBElement<ResourceIdentifier> createHasOriginalSource(ResourceIdentifier value) {
        return new JAXBElement<ResourceIdentifier>(_HasOriginalSource_QNAME, ResourceIdentifier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CharacterEncodingInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "characterEncodingInfo")
    public JAXBElement<CharacterEncodingInfo> createCharacterEncodingInfo(CharacterEncodingInfo value) {
        return new JAXBElement<CharacterEncodingInfo>(_CharacterEncodingInfo_QNAME, CharacterEncodingInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeCoverageInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "timeCoverageInfo")
    public JAXBElement<TimeCoverageInfo> createTimeCoverageInfo(TimeCoverageInfo value) {
        return new JAXBElement<TimeCoverageInfo>(_TimeCoverageInfo_QNAME, TimeCoverageInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeographicCoverageInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "geographicCoverageInfo")
    public JAXBElement<GeographicCoverageInfo> createGeographicCoverageInfo(GeographicCoverageInfo value) {
        return new JAXBElement<GeographicCoverageInfo>(_GeographicCoverageInfo_QNAME, GeographicCoverageInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LingualityInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "lingualityInfo")
    public JAXBElement<LingualityInfo> createLingualityInfo(LingualityInfo value) {
        return new JAXBElement<LingualityInfo>(_LingualityInfo_QNAME, LingualityInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LanguageInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "languageInfo")
    public JAXBElement<LanguageInfo> createLanguageInfo(LanguageInfo value) {
        return new JAXBElement<LanguageInfo>(_LanguageInfo_QNAME, LanguageInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LanguageInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "metalanguageInfo")
    public JAXBElement<LanguageInfo> createMetalanguageInfo(LanguageInfo value) {
        return new JAXBElement<LanguageInfo>(_MetalanguageInfo_QNAME, LanguageInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LanguageVarietyInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "languageVarietyInfo")
    public JAXBElement<LanguageVarietyInfo> createLanguageVarietyInfo(LanguageVarietyInfo value) {
        return new JAXBElement<LanguageVarietyInfo>(_LanguageVarietyInfo_QNAME, LanguageVarietyInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "languageVarietyName")
    public JAXBElement<String> createLanguageVarietyName(String value) {
        return new JAXBElement<String>(_LanguageVarietyName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModalityTypeEnum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "modalityType")
    public JAXBElement<ModalityTypeEnum> createModalityType(ModalityTypeEnum value) {
        return new JAXBElement<ModalityTypeEnum>(_ModalityType_QNAME, ModalityTypeEnum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MediaTypeEnum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "mediaType")
    public JAXBElement<MediaTypeEnum> createMediaType(MediaTypeEnum value) {
        return new JAXBElement<MediaTypeEnum>(_MediaType_QNAME, MediaTypeEnum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CharacterEncodingEnum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "characterEncoding")
    public JAXBElement<CharacterEncodingEnum> createCharacterEncoding(CharacterEncodingEnum value) {
        return new JAXBElement<CharacterEncodingEnum>(_CharacterEncoding_QNAME, CharacterEncodingEnum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnnotationLevelEnum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "annotationLevel")
    public JAXBElement<AnnotationLevelEnum> createAnnotationLevel(AnnotationLevelEnum value) {
        return new JAXBElement<AnnotationLevelEnum>(_AnnotationLevel_QNAME, AnnotationLevelEnum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UseNLPSpecificEnum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "useNLPSpecific")
    public JAXBElement<UseNLPSpecificEnum> createUseNLPSpecific(UseNLPSpecificEnum value) {
        return new JAXBElement<UseNLPSpecificEnum>(_UseNLPSpecific_QNAME, UseNLPSpecificEnum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelatedResource }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "tagset")
    public JAXBElement<RelatedResource> createTagset(RelatedResource value) {
        return new JAXBElement<RelatedResource>(_Tagset_QNAME, RelatedResource.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelatedResource }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "typesystem")
    public JAXBElement<RelatedResource> createTypesystem(RelatedResource value) {
        return new JAXBElement<RelatedResource>(_Typesystem_QNAME, RelatedResource.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MimeTypeEnum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "mimeType")
    public JAXBElement<MimeTypeEnum> createMimeType(MimeTypeEnum value) {
        return new JAXBElement<MimeTypeEnum>(_MimeType_QNAME, MimeTypeEnum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SizeInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "sizeInfo")
    public JAXBElement<SizeInfo> createSizeInfo(SizeInfo value) {
        return new JAXBElement<SizeInfo>(_SizeInfo_QNAME, SizeInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "size")
    public JAXBElement<String> createSize(String value) {
        return new JAXBElement<String>(_Size_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "keyword")
    public JAXBElement<String> createKeyword(String value) {
        return new JAXBElement<String>(_Keyword_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EncodingLevelEnum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "encodingLevel")
    public JAXBElement<EncodingLevelEnum> createEncodingLevel(EncodingLevelEnum value) {
        return new JAXBElement<EncodingLevelEnum>(_EncodingLevel_QNAME, EncodingLevelEnum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComponentInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "componentInfo")
    public JAXBElement<ComponentInfo> createComponentInfo(ComponentInfo value) {
        return new JAXBElement<ComponentInfo>(_ComponentInfo_QNAME, ComponentInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComponentEvaluationInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "componentEvaluationInfo")
    public JAXBElement<ComponentEvaluationInfo> createComponentEvaluationInfo(ComponentEvaluationInfo value) {
        return new JAXBElement<ComponentEvaluationInfo>(_ComponentEvaluationInfo_QNAME, ComponentEvaluationInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComponentOperationInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "componentOperationInfo")
    public JAXBElement<ComponentOperationInfo> createComponentOperationInfo(ComponentOperationInfo value) {
        return new JAXBElement<ComponentOperationInfo>(_ComponentOperationInfo_QNAME, ComponentOperationInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComponentCreationInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "componentCreationInfo")
    public JAXBElement<ComponentCreationInfo> createComponentCreationInfo(ComponentCreationInfo value) {
        return new JAXBElement<ComponentCreationInfo>(_ComponentCreationInfo_QNAME, ComponentCreationInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComponentDocumentationInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "componentDocumentationInfo")
    public JAXBElement<ComponentDocumentationInfo> createComponentDocumentationInfo(ComponentDocumentationInfo value) {
        return new JAXBElement<ComponentDocumentationInfo>(_ComponentDocumentationInfo_QNAME, ComponentDocumentationInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelatedResource }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "annotationResource")
    public JAXBElement<RelatedResource> createAnnotationResource(RelatedResource value) {
        return new JAXBElement<RelatedResource>(_AnnotationResource_QNAME, RelatedResource.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CorpusInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "corpusInfo")
    public JAXBElement<CorpusInfo> createCorpusInfo(CorpusInfo value) {
        return new JAXBElement<CorpusInfo>(_CorpusInfo_QNAME, CorpusInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CorpusTextPartInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "corpusTextPartInfo")
    public JAXBElement<CorpusTextPartInfo> createCorpusTextPartInfo(CorpusTextPartInfo value) {
        return new JAXBElement<CorpusTextPartInfo>(_CorpusTextPartInfo_QNAME, CorpusTextPartInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RawCorpusInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "rawCorpusInfo")
    public JAXBElement<RawCorpusInfo> createRawCorpusInfo(RawCorpusInfo value) {
        return new JAXBElement<RawCorpusInfo>(_RawCorpusInfo_QNAME, RawCorpusInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnnotatedCorpusInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "annotatedCorpusInfo")
    public JAXBElement<AnnotatedCorpusInfo> createAnnotatedCorpusInfo(AnnotatedCorpusInfo value) {
        return new JAXBElement<AnnotatedCorpusInfo>(_AnnotatedCorpusInfo_QNAME, AnnotatedCorpusInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnnotationsInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "annotationsInfo")
    public JAXBElement<AnnotationsInfo> createAnnotationsInfo(AnnotationsInfo value) {
        return new JAXBElement<AnnotationsInfo>(_AnnotationsInfo_QNAME, AnnotationsInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LanguageDescriptionInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "languageDescriptionInfo")
    public JAXBElement<LanguageDescriptionInfo> createLanguageDescriptionInfo(LanguageDescriptionInfo value) {
        return new JAXBElement<LanguageDescriptionInfo>(_LanguageDescriptionInfo_QNAME, LanguageDescriptionInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LanguageDescriptionEncodingInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "languageDescriptionEncodingInfo")
    public JAXBElement<LanguageDescriptionEncodingInfo> createLanguageDescriptionEncodingInfo(LanguageDescriptionEncodingInfo value) {
        return new JAXBElement<LanguageDescriptionEncodingInfo>(_LanguageDescriptionEncodingInfo_QNAME, LanguageDescriptionEncodingInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LanguageDescriptionOperationInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "languageDescriptionOperationInfo")
    public JAXBElement<LanguageDescriptionOperationInfo> createLanguageDescriptionOperationInfo(LanguageDescriptionOperationInfo value) {
        return new JAXBElement<LanguageDescriptionOperationInfo>(_LanguageDescriptionOperationInfo_QNAME, LanguageDescriptionOperationInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LanguageDescriptionPerformanceInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "languageDescriptionPerformanceInfo")
    public JAXBElement<LanguageDescriptionPerformanceInfo> createLanguageDescriptionPerformanceInfo(LanguageDescriptionPerformanceInfo value) {
        return new JAXBElement<LanguageDescriptionPerformanceInfo>(_LanguageDescriptionPerformanceInfo_QNAME, LanguageDescriptionPerformanceInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LanguageDescriptionTextInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "languageDescriptionTextInfo")
    public JAXBElement<LanguageDescriptionTextInfo> createLanguageDescriptionTextInfo(LanguageDescriptionTextInfo value) {
        return new JAXBElement<LanguageDescriptionTextInfo>(_LanguageDescriptionTextInfo_QNAME, LanguageDescriptionTextInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LexicalConceptualResourceInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "lexicalConceptualResourceInfo")
    public JAXBElement<LexicalConceptualResourceInfo> createLexicalConceptualResourceInfo(LexicalConceptualResourceInfo value) {
        return new JAXBElement<LexicalConceptualResourceInfo>(_LexicalConceptualResourceInfo_QNAME, LexicalConceptualResourceInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LexicalConceptualResourceEncodingInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "lexicalConceptualResourceEncodingInfo")
    public JAXBElement<LexicalConceptualResourceEncodingInfo> createLexicalConceptualResourceEncodingInfo(LexicalConceptualResourceEncodingInfo value) {
        return new JAXBElement<LexicalConceptualResourceEncodingInfo>(_LexicalConceptualResourceEncodingInfo_QNAME, LexicalConceptualResourceEncodingInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LexicalConceptualResourceTextInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "lexicalConceptualResourceTextInfo")
    public JAXBElement<LexicalConceptualResourceTextInfo> createLexicalConceptualResourceTextInfo(LexicalConceptualResourceTextInfo value) {
        return new JAXBElement<LexicalConceptualResourceTextInfo>(_LexicalConceptualResourceTextInfo_QNAME, LexicalConceptualResourceTextInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModelInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "modelInfo")
    public JAXBElement<ModelInfo> createModelInfo(ModelInfo value) {
        return new JAXBElement<ModelInfo>(_ModelInfo_QNAME, ModelInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModelTextInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "modelTextInfo")
    public JAXBElement<ModelTextInfo> createModelTextInfo(ModelTextInfo value) {
        return new JAXBElement<ModelTextInfo>(_ModelTextInfo_QNAME, ModelTextInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentMetadataRecord }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "documentMetadataRecord")
    public JAXBElement<DocumentMetadataRecord> createDocumentMetadataRecord(DocumentMetadataRecord value) {
        return new JAXBElement<DocumentMetadataRecord>(_DocumentMetadataRecord_QNAME, DocumentMetadataRecord.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "publication")
    public JAXBElement<DocumentInfo> createPublication(DocumentInfo value) {
        return new JAXBElement<DocumentInfo>(_Publication_QNAME, DocumentInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnnotatedDocumentInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "annotatedPublication")
    public JAXBElement<AnnotatedDocumentInfo> createAnnotatedPublication(AnnotatedDocumentInfo value) {
        return new JAXBElement<AnnotatedDocumentInfo>(_AnnotatedPublication_QNAME, AnnotatedDocumentInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActorInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "publisher")
    public JAXBElement<ActorInfo> createPublisher(ActorInfo value) {
        return new JAXBElement<ActorInfo>(_Publisher_QNAME, ActorInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelatedJournal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "journal")
    public JAXBElement<RelatedJournal> createJournal(RelatedJournal value) {
        return new JAXBElement<RelatedJournal>(_Journal_QNAME, RelatedJournal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelatedRepository }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "repository")
    public JAXBElement<RelatedRepository> createRepository(RelatedRepository value) {
        return new JAXBElement<RelatedRepository>(_Repository_QNAME, RelatedRepository.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelationInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "relationInfo")
    public JAXBElement<RelationInfo> createRelationInfo(RelationInfo value) {
        return new JAXBElement<RelationInfo>(_RelationInfo_QNAME, RelationInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "contactEmail", scope = ContactInfo.class)
    public JAXBElement<String> createContactInfoContactEmail(String value) {
        return new JAXBElement<String>(_ContactInfoContactEmail_QNAME, String.class, ContactInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.meta-share.org/OMTD-SHARE_XMLSchema", name = "landingPage", scope = ContactInfo.class)
    public JAXBElement<String> createContactInfoLandingPage(String value) {
        return new JAXBElement<String>(_ContactInfoLandingPage_QNAME, String.class, ContactInfo.class, value);
    }

}
