package eu.openminted.registry.beans;


import eu.openminted.registry.core.backup.dump.DumpResourcePartitioner;
import eu.openminted.registry.core.backup.dump.DumpResourceReader;
import eu.openminted.registry.core.configuration.BatchConfig;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.ParserService;
import eu.openminted.registry.domain.file.FileStats;
import eu.openminted.registry.domain.operation.Corpus;
import eu.openminted.registry.domain.operation.Operation;
import eu.openminted.registry.service.process.ProcessResourceStep;
import eu.openminted.registry.service.process.ProcessStatisticsProcessor;
import eu.openminted.registry.service.process.SizeCorpusProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.skip.AlwaysSkipItemSkipPolicy;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;

import java.util.Arrays;
import java.util.concurrent.Callable;

@Configuration
@ComponentScan(basePackageClasses = {BatchConfig.class})
public class AdminToolsConfig {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Autowired
    ParserService parserService;

    @Bean
    @JobScope
    Step calculateSizeStep(
            DumpResourcePartitioner partitioner,
            DumpResourceReader reader,
            SizeCorpusProcessor processor,
            Callable<TaskExecutor> threadPoolExecutor
    ) throws Exception {
        ProcessResourceStep<Corpus> converter = new ProcessResourceStep<>(parserService,Corpus.class);
        CompositeItemProcessor<Resource,FileStats> composition = new CompositeItemProcessor<>();
        composition.setDelegates(Arrays.asList(converter,processor));
        Step slave = steps.get("resourceProcess")
                .<Resource,FileStats>chunk(10)
                .reader(reader)
                .processor(composition)
                .writer(processor)
                .faultTolerant()
                .skipPolicy(new AlwaysSkipItemSkipPolicy())
                .build();
        return steps.get("corpusSizeStep")
                .partitioner("resourcePartitioner",partitioner)
                .taskExecutor(threadPoolExecutor.call())
                .step(slave)
                .build();
    }

    @Bean
    Job calculateSizes(Step calculateSizeStep){
        return jobs.get("corpusSize").start(calculateSizeStep).build();
    }

    @Bean
    @JobScope
    Step calculateProcessStatisticsStep(
            DumpResourcePartitioner partitioner,
            DumpResourceReader reader,
            ProcessStatisticsProcessor processor,
            Callable<TaskExecutor> threadPoolExecutor
    ) throws Exception {
        ProcessResourceStep<Operation> converter = new ProcessResourceStep<>(parserService,Operation.class);
        CompositeItemProcessor<Resource,Operation> composition = new CompositeItemProcessor<>();
        composition.setDelegates(Arrays.asList(converter,processor));
        Step slave = steps.get("resourceProcess")
                .<Resource,Operation>chunk(10)
                .reader(reader)
                .processor(composition)
                .writer(processor)
                .faultTolerant()
                .skipPolicy(new AlwaysSkipItemSkipPolicy())
                .build();
        return steps.get("processStatisticsStep")
                .partitioner("resourcePartitioner",partitioner)
                .taskExecutor(threadPoolExecutor.call())
                .step(slave)
                .build();
    }

    @Bean
    Job calculateProcessStatistics(Step calculateProcessStatisticsStep){
        return jobs.get("processStatistics").start(calculateProcessStatisticsStep).build();
    }
}
