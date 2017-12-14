package com.zzgo.jeck.dao;

import com.zzgo.jeck.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RecordDao extends JpaRepository<Record, String>, JpaSpecificationExecutor<Record>, RecordDaoCustom {
}
