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
    //型号
    private String model;
    //名称
    private String name;
    //位置
    private Location location;
    //描述
    private String description;
    //创建时间
    private Date createTime;

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

    @OneToOne
    @JoinColumn(name = "location_id")
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Column(name = "sensor_description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "sensor_create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
