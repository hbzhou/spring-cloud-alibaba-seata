package com.itsz.springcloud.alibaba.seata.storage.service;

import com.itsz.springcloud.alibaba.seata.domain.Storage;
import com.itsz.springcloud.alibaba.seata.service.StorageService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.itsz.springcloud.alibaba.seata.storage.mapper.StorageMapper;

import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;


    public int deleteByPrimaryKey(Long id) {
        return storageMapper.deleteByPrimaryKey(id);
    }


    public int insert(Storage record) {
        return storageMapper.insert(record);
    }


    public int insertSelective(Storage record) {
        return storageMapper.insertSelective(record);
    }


    public Storage selectByPrimaryKey(Long id) {
        return storageMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(Storage record) {
        return storageMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Storage record) {
        return storageMapper.updateByPrimaryKey(record);
    }

    public List<Storage> selectAll() {
        return storageMapper.selectAll();
    }
}
