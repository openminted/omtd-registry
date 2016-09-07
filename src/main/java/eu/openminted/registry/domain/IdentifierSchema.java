package eu.openminted.registry.domain;

import javax.xml.bind.annotation.XmlValue;

/**
 * Created by stefania on 9/5/16.
 */
public interface IdentifierSchema {

    @XmlValue
    public String getValue();
}
