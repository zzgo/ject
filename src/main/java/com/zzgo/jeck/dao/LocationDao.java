package com.zzgo.jeck.dao;

import com.zzgo.jeck.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by 9527 on 2017/11/16.
 */
public interface LocationDao extends JpaRepository<Location, String>, JpaSpecificationExecutor<Location>,
        LocationDaoCustom {
}
