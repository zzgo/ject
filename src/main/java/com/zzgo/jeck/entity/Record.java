package com.zzgo.jeck.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 9527 on 2017/11/22.
 */
@Entity
@Table(name = "tab_record")
public class Record {
    private String id;
    private String name;//管理者
    private String situation;//情况
    private Date recordTime;//记录时间

    @Id
    @GenericGenerator(name = "uuid", strategy = "assigned")
    @GeneratedValue(generator = "uuid")
    @Column(name = "record_id", unique = true, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "record_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "record_situation")
    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    @Column(name = "record_record_time")
    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

}
