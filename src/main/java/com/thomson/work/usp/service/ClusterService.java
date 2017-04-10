package com.thomson.work.usp.service;

import com.thomson.work.usp.entity.ClusterDO;
import com.thomson.work.usp.repo.ClusterRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 10/04/2017.
 */
@Service
public class ClusterService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClusterService.class);
    private static final String SERVICE_IN_USP_FILE_PATH = "/opt/temp/service-in-usp.txt";

    @Autowired
    private ClusterRepository clusterRepository;

    @Autowired
    private ResourceLoader resourceLoader;

    public void resolveBeUsedClusters() {
        Resource resource = resourceLoader.getResource("classpath:service-name.txt");
        try {
            LOGGER.info("get stream from the URI {}", resource.getURI());
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(SERVICE_IN_USP_FILE_PATH));
            Stream<String> serviceNameStream = Files.lines(Paths.get(resource.getURI()));
            serviceNameStream.forEach((serviceName) -> beUsedCluster(writer, serviceName));
            writer.close();
            serviceNameStream.close();
        } catch (IOException e) {
            LOGGER.error("read the file error: {}", e);
        }
    }

    private void beUsedCluster(BufferedWriter writer, String serviceName) {
        List<ClusterDO> clusters = clusterRepository.findByType(1);
        for (ClusterDO cluster : clusters) {
            if (cluster.getName().endsWith(serviceName)) {
                LOGGER.info("the service {} is in usp.", serviceName);
                writeUsedCluster(writer, cluster);
            }
        }
    }

    private void writeUsedCluster(BufferedWriter writer, ClusterDO cluster) {
        try {
            writer.write(cluster.toString());
            LOGGER.info("write the cluster {} to file successfully!", cluster.getName());
        } catch (IOException e) {
            LOGGER.error("write to the file error: {}", e);
        }
    }
}
