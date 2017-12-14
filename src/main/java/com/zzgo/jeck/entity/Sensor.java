package com.zzgo.jeck.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>传感器实体</p>
 * <d>支持文件导入</d>
 * Created by 9527 on 2017/10/12.
 */
@Entity
@Table(name = "tab_sensor")
public class Sensor {
    //id
    private String id;
    //通信标识码
    private String model;
    //名称
    private String name;
    //位置
    private String location;
    //描述
    private String description;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;


    @Id
    @GenericGenerator(name = "uuid", strategy = "assigned")
    @GeneratedValue(generator = "uuid")
    @Column(name = "sensor_id", unique = true, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "sensor_model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "sensor_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "sensor_location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "sensor_description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "sensor_createTime")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "sensor_updateTime")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
