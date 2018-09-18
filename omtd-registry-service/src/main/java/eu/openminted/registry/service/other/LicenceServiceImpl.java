package eu.openminted.registry.service.other;

import eu.openminted.registry.LicenceService;
import eu.openminted.registry.core.domain.Paging;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.exception.ResourceNotFoundException;
import eu.openminted.registry.core.service.ParserService;
import eu.openminted.registry.core.service.SearchService;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.domain.licence.Licence;
import eu.openminted.registry.domain.licence.LicenceCompatibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LicenceServiceImpl implements LicenceService {

    private static final String licenceId = "omtdId";

    private static final String licenceSchema = "licence";

    private static final String compatibilitySchema = "licencecompatibility";

    @Autowired
    SearchService searchService;

    @Autowired
    ParserService parserService;

    @Override
    public Licence get(String id) {
        Paging<Resource> answer = searchService.cqlQuery(licenceId +"=" + id,licenceSchema);
        if(answer.getResults() == null || answer.getResults().isEmpty())
            throw new ServiceException("Licence not found");
        Resource resource = answer.getResults().get(0);
        return parserService.deserialize(resource,Licence.class);
    }

    @Override
    public List<Licence> getAll() {
        Paging<Resource> answer = searchService.cqlQuery("*",licenceSchema);
        return answer
                .getResults()
                .stream()
                .map(x -> parserService.deserialize(x,Licence.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Licence> getAll(String category) {
        Paging<Resource> answer = searchService.cqlQuery("category="+category,licenceSchema);
        return answer
                .getResults()
                .stream()
                .map(x -> parserService.deserialize(x,Licence.class))
                .collect(Collectors.toList());
    }

    @Override
    public LicenceCompatibility compare(String l1, String l2) throws ResourceNotFoundException {
        final String format = "(licence=%s and compare=%s) or (licence=%s and compare=%s)";
        String query = String.format(format,l1,l2,l2,l1);
        Paging<Resource> answer = searchService.cqlQuery(query,compatibilitySchema);
        if(answer.getResults() == null || answer.getResults().isEmpty())
            throw new ResourceNotFoundException();
        Resource resource = answer.getResults().get(0);
        return parserService.deserialize(resource,LicenceCompatibility.class);
    }
}
