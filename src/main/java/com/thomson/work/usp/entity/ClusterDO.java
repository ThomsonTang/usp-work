package com.thomson.work.usp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 07/04/2017.
 */
@Entity
@Table(name = "t_configuration_cluster")
public class ClusterDO implements Serializable {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "deploypath")
    private String deployPath;

    @Column(name = "version")
    private String version;

    @Column(name = "type")
    private Integer type;

    @Column(name = "deploytime")
    private Date deployTime;

    @Column(name = "deployer")
    private String deployer;

    public ClusterDO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeployPath() {
        return deployPath;
    }

    public void setDeployPath(String deployPath) {
        this.deployPath = deployPath;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getDeployTime() {
        return deployTime;
    }

    public void setDeployTime(Date deployTime) {
        this.deployTime = deployTime;
    }

    public String getDeployer() {
        return deployer;
    }

    public void setDeployer(String deployer) {
        this.deployer = deployer;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s\n", name, deployPath, version, deployTime, deployer);
    }
}
