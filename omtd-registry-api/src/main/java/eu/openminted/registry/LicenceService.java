package eu.openminted.registry;

import eu.openminted.registry.core.exception.ResourceNotFoundException;
import eu.openminted.registry.domain.licence.Licence;
import eu.openminted.registry.domain.licence.LicenceCompatibility;

import java.util.List;

public interface LicenceService{

    Licence get(String id);

    List<Licence> getAll();

    List<Licence> getAll(String category);

    LicenceCompatibility compare(String licence1, String licence2) throws ResourceNotFoundException;

}
