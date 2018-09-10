package eu.openminted.registry.service.process;

import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.operation.Monitoring;
import eu.openminted.registry.domain.operation.Operation;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@StepScope
public class ProcessStatisticsProcessor implements ItemProcessor<Operation,Operation>, ItemWriter<Operation> {


    @Value("${monitoring.cpuCount:8}")
    private int cpuCount;

    @Value("${monitoring.vmCount:1}")
    private int vmCount;

    @Value("${monitoring.ramSize:8}")
    private int ramSize;

    private ResourceCRUDService<Operation,?> service;

    @Autowired
    public ProcessStatisticsProcessor(ResourceCRUDService<Operation,?> service) {
        this.service = service;
    }

    @Override
    public Operation process(Operation item) {
        if(item.getStatus().equals("FINISHED") && item.getMonitoring() == null) {
            Monitoring monitoring = new Monitoring();
            monitoring.setCpuCount(cpuCount);
            monitoring.setVmCount(vmCount);
            monitoring.setRamUsage(ramSize);
            long start = item.getDate().getStarted().getTime();
            long end = item.getDate().getFinished().getTime();
            monitoring.setCpuMilliseconds((int) ((end-start) * cpuCount));
            item.setMonitoring(monitoring);
            return item;
        }
        return null;
    }

    @Override
    public void write(List<? extends Operation> items) throws Exception {
        for (Operation operation: items) {
            service.update(operation,null);
        }
    }
}
