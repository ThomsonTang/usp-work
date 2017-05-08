package com.thomson.work.usp.service;

import com.thomson.work.usp.entity.BusinessLineDO;
import com.thomson.work.usp.entity.CmdbClusterDO;
import com.thomson.work.usp.repo.BusinessLineRepository;
import com.thomson.work.usp.repo.CmdbClusterRepository;

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
public class CmdbClusterService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CmdbClusterService.class);
    private static final String SERVICE_IN_CMDB_FILE_PATH = "/opt/temp/common-service-in-cmdb.txt";

    @Autowired
    private CmdbClusterRepository cmdbClusterRepository;

    @Autowired
    private BusinessLineRepository businessLineRepository;

    @Autowired
    private ResourceLoader resourceLoader;

    public void resolveBeUsedClusters() {
        Resource resource = resourceLoader.getResource("classpath:service-name.txt");
        try {
            LOGGER.info("get stream from the URI {}", resource.getURI());
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(SERVICE_IN_CMDB_FILE_PATH));
            Stream<String> serviceNameStream = Files.lines(Paths.get(resource.getURI()));
            serviceNameStream.forEach((serviceName) -> beUsedCluster(writer, serviceName));
            writer.close();
            serviceNameStream.close();
        } catch (IOException e) {
            LOGGER.error("read the file error: {}", e);
        }
    }

    private void beUsedCluster(BufferedWriter writer, String serviceName) {
        List<CmdbClusterDO> all = cmdbClusterRepository.findAll();
        all.stream()
                .filter(cluster -> cluster.getClusterName().endsWith("scf_" + serviceName))
                .forEach(cluster -> writeUsedCluster(writer, cluster));

//        for (ClusterDO cluster : clusters) {
//            if (cluster.getName().endsWith(serviceName)) {
//                LOGGER.info("the service {} is in usp.", serviceName);
//                writeUsedCluster(writer, cluster);
//            }
//        }
    }

    private void writeUsedCluster(BufferedWriter writer, CmdbClusterDO cluster) {
        try {
            BusinessLineDO businessLine = businessLineRepository.findByBusinessLineId(cluster.getBusinessId());
            if (null != businessLine) {
                cluster.setBusinessLineCode(businessLine.getBusinessCode());
                cluster.setBusinessLineName(businessLine.getBusinessName());
            }
            writer.write(cluster.toString());
            LOGGER.info("write the cluster {} to file successfully!", cluster.getClusterName());
        } catch (IOException e) {
            LOGGER.error("write to the file error: {}", e);
        }
    }
}
