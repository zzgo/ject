package com.zzgo.jeck.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by 9527 on 2017/11/9.
 */
@Entity
@Table(name = "tab_nav")
public class Nav {
    private String id;
    private String name;
    private String url;
    private Nav parent;
    private List<Nav> children;

    @Id
    @GenericGenerator(name = "uuid", strategy = "assigned")
    @GeneratedValue(generator = "uuid")
    @Column(name = "nav_id", unique = true, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "nav_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "nav_url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = true)
    @JoinColumn(name = "parent_id")
    public Nav getParent() {
        return parent;
    }

    public void setParent(Nav parent) {
        this.parent = parent;
    }

    @Transient
    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "nav")
    public List<Nav> getChildren() {
        return children;
    }

    public void setChildren(List<Nav> children) {
        this.children = children;
    }
}
