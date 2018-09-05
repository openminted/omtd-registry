package eu.openminted.registry.service;

import eu.openminted.registry.domain.Totals;

import java.io.IOException;

/**
 * Created by jod on 7/05/18.
 */
public interface StatsService{

    void scheduled();

    Totals totals() throws IOException;
}
