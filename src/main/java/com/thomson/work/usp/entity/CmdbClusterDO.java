package com.thomson.work.usp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 08/05/2017.
 */
@Entity
@Table(name = "t_cluster")
public class CmdbClusterDO implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "cluster_id")
    private Long clusterId;

    @Column(name = "cluster_code")
    private String clusterCode;

    @Column(name = "cluster_name")
    private String clusterName;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "update_time")
    private String updateTime;

    @Column(name = "cluster_state")
    private Integer clusterState;

    @Column(name = "business_id")
    private Integer businessId;

    @Column(name = "clusterLevel")
    private Integer cluster_level;

    @Column(name = "cluster_tag")
    private String clusterTag;

    @Column(name = "cluster_type")
    private Integer clusterType;

    @Transient
    private String businessLineCode;

    @Transient
    private String businessLineName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getClusterId() {
        return clusterId;
    }

    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
    }

    public String getClusterCode() {
        return clusterCode;
    }

    public void setClusterCode(String clusterCode) {
        this.clusterCode = clusterCode;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getClusterState() {
        return clusterState;
    }

    public void setClusterState(Integer clusterState) {
        this.clusterState = clusterState;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Integer getCluster_level() {
        return cluster_level;
    }

    public void setCluster_level(Integer cluster_level) {
        this.cluster_level = cluster_level;
    }

    public String getClusterTag() {
        return clusterTag;
    }

    public void setClusterTag(String clusterTag) {
        this.clusterTag = clusterTag;
    }

    public Integer getClusterType() {
        return clusterType;
    }

    public void setClusterType(Integer clusterType) {
        this.clusterType = clusterType;
    }

    public String getBusinessLineCode() {
        return businessLineCode;
    }

    public void setBusinessLineCode(String businessLineCode) {
        this.businessLineCode = businessLineCode;
    }

    public String getBusinessLineName() {
        return businessLineName;
    }

    public void setBusinessLineName(String businessLineName) {
        this.businessLineName = businessLineName;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s\n", clusterCode, clusterName, businessLineCode, businessLineName);
    }
}
