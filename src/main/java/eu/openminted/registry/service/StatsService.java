package eu.openminted.registry.service;

import java.io.IOException;

/**
 * Created by jod on 7/05/18.
 */
public interface StatsService{

    String totals() throws IOException;
}
