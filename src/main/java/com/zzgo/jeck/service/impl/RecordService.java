package com.zzgo.jeck.service.impl;

import com.zzgo.jeck.dao.RecordDao;
import com.zzgo.jeck.entity.Record;
import com.zzgo.jeck.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class RecordService implements IRecordService {

    @Autowired
    private RecordDao recordDao;

    public void save(Record record) {
        recordDao.save(record);
    }

    public void delete(String id) {
        recordDao.delete(id);
    }

    public Record findRecordById(String id) {
        return recordDao.findOne(id);
    }

    public Page<Record> findPage(int first, int max) {
        if (first < 1) first = 1;
        Pageable pageable = new PageRequest(first - 1, max);
        return recordDao.findAll(pageable);
    }

    public Page<Record> findPage(Specification<Record> specification, int first, int max) {
        if (first < 1) first = 1;
        Pageable pageable = new PageRequest(first - 1, max);
        return recordDao.findAll(specification, pageable);
    }
}
