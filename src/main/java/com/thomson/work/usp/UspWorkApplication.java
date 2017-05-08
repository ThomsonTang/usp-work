package com.thomson.work.usp;

import com.thomson.work.usp.service.CmdbClusterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UspWorkApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(UspWorkApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(UspWorkApplication.class, args);
        CmdbClusterService clusterService = applicationContext.getBean(CmdbClusterService.class);
        LOGGER.info("start to resolve the clusters which were be used in usp...");
        clusterService.resolveBeUsedClusters();
        LOGGER.info("resolve completed!");
    }
}
