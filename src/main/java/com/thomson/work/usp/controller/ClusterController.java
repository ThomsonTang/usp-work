package com.thomson.work.usp.controller;

import com.thomson.work.usp.entity.ClusterDO;
import com.thomson.work.usp.repo.ClusterRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 10/04/2017.
 */
public class ClusterController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClusterController.class);

    private ClusterRepository clusterRepository;

    public List<ClusterDO> query(String name) {
        LOGGER.info("Query the cluster with the name equals {}", name);
        List<ClusterDO> cluster = clusterRepository.findByName(name);
        LOGGER.info("Query OK! the size is {}", cluster.size());
        return cluster;
    }
}
