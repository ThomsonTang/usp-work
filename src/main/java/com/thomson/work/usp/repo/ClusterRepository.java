package com.thomson.work.usp.repo;

import com.thomson.work.usp.entity.ClusterDO;

import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 07/04/2017.
 */
public interface ClusterRepository extends Repository<ClusterDO, Long> {

    ClusterDO findById(Long id);

    List<ClusterDO> findByName(String name);

    List<ClusterDO> findByType(Integer type);
}
