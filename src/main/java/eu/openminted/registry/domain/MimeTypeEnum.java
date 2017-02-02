
package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for null.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;maxLength value="50"/&gt;
 *     &lt;enumeration value="text/plain"/&gt;
 *     &lt;enumeration value="application/vnd.xmi+xml"/&gt;
 *     &lt;enumeration value="text/xml"/&gt;
 *     &lt;enumeration value="application/x-tmx+xml"/&gt;
 *     &lt;enumeration value="application/x-xces+xml"/&gt;
 *     &lt;enumeration value="application/tei+xml"/&gt;
 *     &lt;enumeration value="application/rdf+xml"/&gt;
 *     &lt;enumeration value="application/xhtml+xml"/&gt;
 *     &lt;enumeration value="application/emma+xml"/&gt;
 *     &lt;enumeration value="application/pls+xml"/&gt;
 *     &lt;enumeration value="application/postscript"/&gt;
 *     &lt;enumeration value="application/voicexml+xml"/&gt;
 *     &lt;enumeration value="text/sgml"/&gt;
 *     &lt;enumeration value="text/html"/&gt;
 *     &lt;enumeration value="application/x-tex"/&gt;
 *     &lt;enumeration value="application/rtf"/&gt;
 *     &lt;enumeration value="application/json+ld"/&gt;
 *     &lt;enumeration value="application/x-latex"/&gt;
 *     &lt;enumeration value="text/csv"/&gt;
 *     &lt;enumeration value="text/tab-separated-values"/&gt;
 *     &lt;enumeration value="application/pdf"/&gt;
 *     &lt;enumeration value="application/x-msaccess"/&gt;
 *     &lt;enumeration value="audio/mp4"/&gt;
 *     &lt;enumeration value="audio/mpeg"/&gt;
 *     &lt;enumeration value="audio/wav"/&gt;
 *     &lt;enumeration value="image/bmp"/&gt;
 *     &lt;enumeration value="image/gif"/&gt;
 *     &lt;enumeration value="image/jpeg"/&gt;
 *     &lt;enumeration value="image/png"/&gt;
 *     &lt;enumeration value="image/svg+xml"/&gt;
 *     &lt;enumeration value="image/tiff"/&gt;
 *     &lt;enumeration value="video/jpeg"/&gt;
 *     &lt;enumeration value="video/mp4"/&gt;
 *     &lt;enumeration value="video/mpeg"/&gt;
 *     &lt;enumeration value="video/x-flv"/&gt;
 *     &lt;enumeration value="video/x-msvideo"/&gt;
 *     &lt;enumeration value="video/x-ms-wmv"/&gt;
 *     &lt;enumeration value="application/msword"/&gt;
 *     &lt;enumeration value="application/vnd.ms-excel"/&gt;
 *     &lt;enumeration value="audio/mpeg3"/&gt;
 *     &lt;enumeration value="text/turtle"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *     &lt;enumeration value="audio/PCMA"/&gt;
 *     &lt;enumeration value="audio/flac"/&gt;
 *     &lt;enumeration value="audio/speex"/&gt;
 *     &lt;enumeration value="audio/vorbis"/&gt;
 *     &lt;enumeration value="video/mp2t"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "")
@XmlEnum
public enum MimeTypeEnum {

    @XmlEnumValue("text/plain")
    TEXT_PLAIN("text/plain"),
    @XmlEnumValue("application/vnd.xmi+xml")
    APPLICATION_VND_XMI_XML("application/vnd.xmi+xml"),
    @XmlEnumValue("text/xml")
    TEXT_XML("text/xml"),
    @XmlEnumValue("application/x-tmx+xml")
    APPLICATION_X_TMX_XML("application/x-tmx+xml"),
    @XmlEnumValue("application/x-xces+xml")
    APPLICATION_X_XCES_XML("application/x-xces+xml"),
    @XmlEnumValue("application/tei+xml")
    APPLICATION_TEI_XML("application/tei+xml"),
    @XmlEnumValue("application/rdf+xml")
    APPLICATION_RDF_XML("application/rdf+xml"),
    @XmlEnumValue("application/xhtml+xml")
    APPLICATION_XHTML_XML("application/xhtml+xml"),
    @XmlEnumValue("application/emma+xml")
    APPLICATION_EMMA_XML("application/emma+xml"),
    @XmlEnumValue("application/pls+xml")
    APPLICATION_PLS_XML("application/pls+xml"),
    @XmlEnumValue("application/postscript")
    APPLICATION_POSTSCRIPT("application/postscript"),
    @XmlEnumValue("application/voicexml+xml")
    APPLICATION_VOICEXML_XML("application/voicexml+xml"),
    @XmlEnumValue("text/sgml")
    TEXT_SGML("text/sgml"),
    @XmlEnumValue("text/html")
    TEXT_HTML("text/html"),
    @XmlEnumValue("application/x-tex")
    APPLICATION_X_TEX("application/x-tex"),
    @XmlEnumValue("application/rtf")
    APPLICATION_RTF("application/rtf"),
    @XmlEnumValue("application/json+ld")
    APPLICATION_JSON_LD("application/json+ld"),
    @XmlEnumValue("application/x-latex")
    APPLICATION_X_LATEX("application/x-latex"),
    @XmlEnumValue("text/csv")
    TEXT_CSV("text/csv"),
    @XmlEnumValue("text/tab-separated-values")
    TEXT_TAB_SEPARATED_VALUES("text/tab-separated-values"),
    @XmlEnumValue("application/pdf")
    APPLICATION_PDF("application/pdf"),
    @XmlEnumValue("application/x-msaccess")
    APPLICATION_X_MSACCESS("application/x-msaccess"),
    @XmlEnumValue("audio/mp4")
    AUDIO_MP_4("audio/mp4"),
    @XmlEnumValue("audio/mpeg")
    AUDIO_MPEG("audio/mpeg"),
    @XmlEnumValue("audio/wav")
    AUDIO_WAV("audio/wav"),
    @XmlEnumValue("image/bmp")
    IMAGE_BMP("image/bmp"),
    @XmlEnumValue("image/gif")
    IMAGE_GIF("image/gif"),
    @XmlEnumValue("image/jpeg")
    IMAGE_JPEG("image/jpeg"),
    @XmlEnumValue("image/png")
    IMAGE_PNG("image/png"),
    @XmlEnumValue("image/svg+xml")
    IMAGE_SVG_XML("image/svg+xml"),
    @XmlEnumValue("image/tiff")
    IMAGE_TIFF("image/tiff"),
    @XmlEnumValue("video/jpeg")
    VIDEO_JPEG("video/jpeg"),
    @XmlEnumValue("video/mp4")
    VIDEO_MP_4("video/mp4"),
    @XmlEnumValue("video/mpeg")
    VIDEO_MPEG("video/mpeg"),
    @XmlEnumValue("video/x-flv")
    VIDEO_X_FLV("video/x-flv"),
    @XmlEnumValue("video/x-msvideo")
    VIDEO_X_MSVIDEO("video/x-msvideo"),
    @XmlEnumValue("video/x-ms-wmv")
    VIDEO_X_MS_WMV("video/x-ms-wmv"),
    @XmlEnumValue("application/msword")
    APPLICATION_MSWORD("application/msword"),
    @XmlEnumValue("application/vnd.ms-excel")
    APPLICATION_VND_MS_EXCEL("application/vnd.ms-excel"),
    @XmlEnumValue("audio/mpeg3")
    AUDIO_MPEG_3("audio/mpeg3"),
    @XmlEnumValue("text/turtle")
    TEXT_TURTLE("text/turtle"),
    @XmlEnumValue("other")
    OTHER("other"),
    @XmlEnumValue("audio/PCMA")
    AUDIO_PCMA("audio/PCMA"),
    @XmlEnumValue("audio/flac")
    AUDIO_FLAC("audio/flac"),
    @XmlEnumValue("audio/speex")
    AUDIO_SPEEX("audio/speex"),
    @XmlEnumValue("audio/vorbis")
    AUDIO_VORBIS("audio/vorbis"),
    @XmlEnumValue("video/mp2t")
    VIDEO_MP_2_T("video/mp2t");
    private final String value;

    MimeTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MimeTypeEnum fromValue(String v) {
        for (MimeTypeEnum c: MimeTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
