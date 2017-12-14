package com.zzgo.jeck.service;

import com.zzgo.jeck.entity.Book;
import com.zzgo.jeck.entity.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface IRecordService {
    void save(Record Record);

    void delete(String id);

    Record findRecordById(String id);

    Page<Record> findPage(int first, int max);

    //用于过滤条件查询
    Page<Record> findPage(Specification<Record> specification, int first, int max);
}
