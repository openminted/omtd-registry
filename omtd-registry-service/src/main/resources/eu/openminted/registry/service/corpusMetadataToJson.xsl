<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">

    <xsl:output method="text" indent="yes"/>

    <xsl:strip-space elements="*"/>

    <xsl:template match="/">

        <xsl:variable name="date"><xsl:value-of select="//*[local-name()='metadataCreationDate']"/></xsl:variable>
        {
        "metadata": {
        "upload_type": "dataset",
        "publication_date": "<xsl:value-of select="format-date($date, '[Y0001]-[M01]-[D01]')"/>",
        "title": "<xsl:value-of select=".//*[local-name()='resourceName']"/>",
        "description": "<xsl:value-of select=".//*[local-name()='description']"/>",
        "creators": [
        <xsl:for-each select=".//*[local-name()='metadataCreators']/*[local-name()='metadataCreator']">
        {"name": "<xsl:value-of select="*[local-name()='surname']"/>, <xsl:value-of select="*[local-name()='givenName']"/>",
        "affiliation": "<xsl:value-of select="*[local-name()='affiliation']/*[local-name()='affiliatedOrganization']
        /*[local-name()='organizationNames']/*[local-name()='organizationName']"/>"},
    </xsl:for-each>
    ],
    "access_right": <xsl:choose><xsl:when test=".//*[local-name()='rightsInfo']/*[local-name()='rightsStatement'] = 'openAccess'">"open"</xsl:when><xsl:otherwise>"closed"</xsl:otherwise></xsl:choose> ,
        "license": "<xsl:value-of select=".//*[local-name()='licenceInfo']/*[local-name()='licence']"/>",
        "keywords": [
<xsl:for-each select=".//*[local-name()='keyword']">
        "<xsl:apply-templates/>",
        </xsl:for-each>
<xsl:for-each select=".//*[local-name()='domainInfo']">
        "<xsl:value-of select="*[local-name()='domain']"/>",
        </xsl:for-each>
        ],

        <!--       <alternateIdentifiers>
                <xsl:for-each select=".//*[local-name()="metadataRecordIdentifier"]">
                  <alternateIdentifier alternateIdentifierType="{@metadataIdentifierSchemeName}"><xsl:apply-templates/></alternateIdentifier>
                </xsl:for-each>
                <xsl:for-each select=".//*[local-name()="resourceIdentifier"]">
                  <alternateIdentifier alternateIdentifierType="{@resourceIdentifierSchemeName}"><xsl:apply-templates/></alternateIdentifier>
                </xsl:for-each>
              </alternateIdentifiers> -->
        <!-- Keywords/domainInfo -> Subjects -->
        }
        }
        </xsl:template>

        </xsl:stylesheet>


        <!--       <dates>
                <date dateType="MetadataCreation"><xsl:value-of select="*[local-name()="metadataCreationDate"]"/></date>
                <date dateType="MetadataUpdate"><xsl:value-of select="*[local-name()="metadataLastDateUpdated"]"/></date>
              </dates>
         -->
        <!-- Publisher -->
        <!-- <xsl:template match="//*[local-name()="publication"]/*[local-name()="publisher"]/*/*">
          <publisher><xsl:apply-templates/></publisher>
        </xsl:template> -->
        <!-- Publication Year -->
        <!-- <xsl:template match="//*[local-name()="publication"]/*[local-name()="publicationDate"]/*[local-name()="year"]">
          <publicationYear><xsl:apply-templates/></publicationYear>
        </xsl:template> -->
        <!-- metadataRecordIdentifier/resourceIdentifier -> alternateIdentifiers -->