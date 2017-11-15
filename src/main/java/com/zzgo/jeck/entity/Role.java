package com.zzgo.jeck.entity;

import java.util.Date;

/**
 * <p>角色实体</p>
 * Created by 9527 on 2017/10/12.
 */
public class Role {
    private int id;
    private String name;//角色名称
    private String note;//备注
    private Date createTime;//创建时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
