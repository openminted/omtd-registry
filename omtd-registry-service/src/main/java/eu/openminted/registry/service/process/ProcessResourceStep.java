package eu.openminted.registry.service.process;

import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ParserService;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;

public class ProcessResourceStep<T> implements ItemProcessor<Resource,T>, StepExecutionListener {

    private final Class<T> returnType;

    private ParserService parser;

    public ProcessResourceStep(ParserService parser, Class<T> returnType) {
        this.returnType = returnType;
        this.parser = parser;
    }

    @Override
    public T process(Resource item) throws Exception {
        return parser.deserialize(item,returnType);
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println(stepExecution);
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return ExitStatus.COMPLETED;
    }
}
