package eu.openminted.registry.service;

import eu.openminted.registry.domain.SizeQuota;

public interface FileStatsService {

    SizeQuota getUserQuota(String sub);

}
