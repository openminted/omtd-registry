package eu.openminted.registry;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import eu.openminted.registry.domain.*;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.codehaus.groovy.runtime.powerassert.SourceText;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMergeOmtd {

    @Test
    public void mergeComponent() throws InvocationTargetException, IllegalAccessException, IOException, InstantiationException {
        Component left = new Component();
        MetadataHeaderInfo info = new MetadataHeaderInfo();
        info.setRevision("Revision");
        PersonInfo creator = new PersonInfo();
        SeparateNames names = new SeparateNames();
        Surname surname = new Surname();
        surname.setValue("Steve");
        surname.setLang("en");
        names.setSurnames(Arrays.asList(surname));
        creator.setSeparateNames(names);
        info.setMetadataCreators(Arrays.asList(creator));
        left.setMetadataHeaderInfo(info);

        Component right = new Component();
        MetadataHeaderInfo rinfo = new MetadataHeaderInfo();
        rinfo.setUserQuery("this is a test");
        right.setMetadataHeaderInfo(rinfo);
        PersonInfo creatorr = new PersonInfo();
        SeparateNames namesr = new SeparateNames();
        Surname surnamer = new Surname();
        surnamer.setValue("Steven");
        surnamer.setLang("en");
        namesr.setSurnames(Arrays.asList(surnamer));
        creatorr.setSeparateNames(namesr);
        rinfo.setMetadataCreators(Arrays.asList(creatorr));

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        Map leftMap = mapper.convertValue(left,Map.class);
        Map rightMap = mapper.convertValue(right,Map.class);
        Map resultMap = deepMerge(leftMap,rightMap);


        Component result = mapper.convertValue(resultMap,Component.class);
        System.out.println(mapper.writeValueAsString(result));
        assertEquals(result.getMetadataHeaderInfo().getUserQuery(),"this is a test");
        assertEquals(result.getMetadataHeaderInfo().getRevision(),"Revision");
        assertEquals(result.getMetadataHeaderInfo().getMetadataCreators().size(),1);
        assertEquals(result.getMetadataHeaderInfo().getMetadataCreators().get(0).getSeparateNames().getSurnames().get(0).getValue(),"Steven");



    }

    private static Map deepMerge(Map original, Map newMap) {
        for (Object key : newMap.keySet()) {
            if (newMap.get(key) instanceof Map && original.get(key) instanceof Map) {
                Map originalChild = (Map) original.get(key);
                Map newChild = (Map) newMap.get(key);
                original.put(key, deepMerge(originalChild, newChild));
            } else if (newMap.get(key) instanceof List && original.get(key) instanceof List) {
//                List originalChild = (List) original.get(key);
//                List newChild = (List) newMap.get(key);
//                for (Object each : newChild) {
//                    if (!originalChild.contains(each)) {
//                        originalChild.add(each);
//                    }
//                }
                original.put(key,newMap.get(key));
            } else {
                original.put(key, newMap.get(key));
            }
        }
        return original;
    }

}
