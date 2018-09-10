package eu.openminted.registry.controllers.other;


import eu.openminted.registry.core.service.ResourceCRUDService;
import eu.openminted.registry.domain.SizeQuota;
import eu.openminted.registry.domain.file.FileStats;
import eu.openminted.registry.service.FileStatsService;
import eu.openminted.registry.service.OperationService;
import io.swagger.annotations.Api;
import org.mitre.openid.connect.model.OIDCAuthenticationToken;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.SimpleBatchConfiguration;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/request/fileStats")
@Api(value = "/request/fileStats", description = "Operations about file quotas.", tags="File Quotas")
public class FileStatsController extends OtherRestController<FileStats> {

    @Autowired
    JobLauncher myJobLauncher;

    @Autowired
    Job dumpJob;

    @Autowired
    FileStatsController(ResourceCRUDService<FileStats,OIDCAuthenticationToken> service) {
        super(service);
    }

    @RequestMapping(value = "quota", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    ResponseEntity<SizeQuota> quotaPerUser(OIDCAuthenticationToken auth) {
        SizeQuota response = ((FileStatsService) service).getUserQuota(auth.getSub());
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    ResponseEntity test() throws Exception {
        JobParametersBuilder builder = new JobParametersBuilder();
//        builder.addString("resourceType","corpus");
//        builder.addString("resourceTypeDir","/home/steve/Desktop/testDump/versionDump/dump-big-versions/corpus");
        builder.addDate("date",new Date());
//        JobExecution job = myJobLauncher.run(dumpJob,builder.toJobParameters());
//        builder = new JobParametersBuilder();
        builder.addString("resourceTypes","corpus,operation,language");
        builder.addString("save","true");
        builder.addString("raw","false");
        builder.addString("versions","true");
//        builder.addString("resourceTypeDir","/home/steve/Desktop/testDump/versionDump/dump-big-versions/application");
//        builder.addDate("date",new Date());
//        JobExecution job2 = myJobLauncher.run(dumpJob,builder.toJobParameters());
//        System.out.println(job2.getStatus());
        JobExecution job = myJobLauncher.run(dumpJob,builder.toJobParameters());
        return ResponseEntity.ok(job.getAllFailureExceptions().stream().map(Throwable::getMessage).collect(Collectors.toList()));
    }
}
