package com.itsz.springcloud.alibaba.seata.service;

import com.itsz.springcloud.alibaba.seata.domain.Storage;

import java.util.List;

public interface StorageService {

    int deleteByPrimaryKey(Long id);


    int insert(Storage record);


    int insertSelective(Storage record);


    Storage selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(Storage record);


    int updateByPrimaryKey(Storage record);

    List<Storage> selectAll();
}
