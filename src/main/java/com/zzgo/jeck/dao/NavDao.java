package com.zzgo.jeck.dao;

import com.zzgo.jeck.entity.Nav;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by 9527 on 2017/11/9.
 */
public interface NavDao extends JpaRepository<Nav, String>, JpaSpecificationExecutor<Nav>, NavDaoCustom {
}
