package com.thomson.work.usp.repo;

import com.thomson.work.usp.entity.BusinessLineDO;

import org.springframework.data.repository.CrudRepository;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 08/05/2017.
 */
public interface BusinessLineRepository extends CrudRepository<BusinessLineDO, Integer> {

    BusinessLineDO findByBusinessLineId(Integer businessLineId);
}
