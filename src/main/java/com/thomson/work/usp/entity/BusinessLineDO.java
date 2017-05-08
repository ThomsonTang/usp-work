package com.thomson.work.usp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 08/05/2017.
 */
@Entity
@Table(name = "t_busline")
public class BusinessLineDO implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "busline_id")
    private Integer businessLineId;

    @Column(name = "busline_code")
    private String businessCode;

    @Column(name = "busline_name")
    private String businessName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBusinessLineId() {
        return businessLineId;
    }

    public void setBusinessLineId(Integer businessLineId) {
        this.businessLineId = businessLineId;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
}
