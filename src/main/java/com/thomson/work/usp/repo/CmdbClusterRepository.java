package com.thomson.work.usp.repo;

import com.thomson.work.usp.entity.CmdbClusterDO;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 08/05/2017.
 */
public interface CmdbClusterRepository extends CrudRepository<CmdbClusterDO, Long> {

    List<CmdbClusterDO> findAll();
}
