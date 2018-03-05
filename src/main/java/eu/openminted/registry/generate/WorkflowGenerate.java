package eu.openminted.registry.generate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import eu.openminted.registry.core.service.ServiceException;
import eu.openminted.registry.service.WorkflowEngineComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class WorkflowGenerate {

    @Value("classpath:eu/openminted/registry/workflow/defaultApplicationWorkflow.json")
    private Resource defaultWorkflow;

    private ObjectMapper objectMapper;

    WorkflowGenerate() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT,true);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public String generateResource(WorkflowEngineComponent component) {
        try {
            ObjectNode node = (ObjectNode) objectMapper.readTree(defaultWorkflow.getFile());
            node.put("uuid", UUID.randomUUID().toString());
            node.put("name", component.getComponentID());
            ObjectNode step0 = (ObjectNode) node.path("steps").path("0");
            ObjectNode step1 = (ObjectNode) node.path("steps").path("1");
            ObjectNode step2 = (ObjectNode) node.path("steps").path("2");
            step0.put("uuid",UUID.randomUUID().toString());
            step1.put("uuid",UUID.randomUUID().toString());
            step2.put("uuid",UUID.randomUUID().toString());
            step2.put("tool_id",component.getComponentID());
            step2.put("contend_id", component.getComponentID());
            step2.put("name",component.getName());
            ObjectNode inputConnections = (ObjectNode) step2.get("input_connections");
            ObjectNode input = objectMapper.createObjectNode();
            input.put("id",1);
            input.put("output_name","output");
            inputConnections.set(component.getName() + "_InputFiles",input);
            String toolState = step2.get("tool_state").asText();
            toolState = toolState.replace("<inputFiles>",component.getName() + "_InputFiles");
            step2.put("tool_state",toolState);
            System.out.println(node.toString());
            return node.toString();
        } catch (IOException e) {
            throw new ServiceException(e);
        }
    }

}
