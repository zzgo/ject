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
    private String name;
    private String situation;
    private Date recordTime;
    private int year;//区别年
    private int mouth;//区分月
    private int happendCount;

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

    @Column(name = "record_year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Column(name = "record_mouth")
    public int getMouth() {
        return mouth;
    }

    public void setMouth(int mouth) {
        this.mouth = mouth;
    }

    @Column(name = "record_happend_count")
    public int getHappendCount() {
        return happendCount;
    }

    public void setHappendCount(int happendCount) {
        this.happendCount = happendCount;
    }
}
