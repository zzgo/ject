package com.zzgo.jeck.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 9527 on 2017/11/9.
 */
@Entity
@Table(name = "tab_user")
public class User {
    private String id;
    private String loginName;//登录名称
    private String password;//密码
    private Date lastLoginTime;//上一次登录时间
    private String name;//姓名
    private String sex;//性别
    private String email;//邮箱
    private String tel;//电话
    private String note;//备注
    private Date createTime;//创建时间

    private Role role;

    @Id
    @GenericGenerator(name = "uuid", strategy = "assigned")
    @GeneratedValue(generator = "uuid")
    @Column(name = "user_id", unique = true, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "user_sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Column(name = "user_login_name")
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Column(name = "user_password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Column(name = "user_last_login_time")
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Column(name = "user_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "user_email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "user_tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Column(name = "user_note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Column(name = "user_create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = true)
    @JoinColumn(name = "role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", note='" + note + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
