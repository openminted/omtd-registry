package eu.openminted.registry.service.process;

import eu.openminted.registry.service.AdminService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("adminService")
public class AdminServiceImpl implements AdminService {

    final private static Logger logger = LogManager.getLogger(AdminServiceImpl.class);

    @Autowired
    Job calculateSizes;

    @Autowired
    Job calculateProcessStatistics;

    @Autowired
    JobLauncher mySyncJobLauncher;

    @Override
    public void computeSizes() throws Exception {
        JobParametersBuilder builder = new JobParametersBuilder();
        builder.addString("resourceType","corpus");
        builder.addDate("date",new Date());
        mySyncJobLauncher.run(calculateSizes, builder.toJobParameters());
    }

    @Override
    public void computeProcessStatistics() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        JobParametersBuilder builder = new JobParametersBuilder();
        builder.addString("resourceType","operation");
        builder.addDate("date",new Date());
        JobExecution ex = mySyncJobLauncher.run(calculateProcessStatistics, builder.toJobParameters());
    }

}