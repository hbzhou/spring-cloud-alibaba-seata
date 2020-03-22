package com.itsz.springcloud.alibaba.seata.storage.controller;

import com.itsz.springcloud.alibaba.seata.domain.Storage;
import com.itsz.springcloud.alibaba.seata.service.StorageService;
import com.itsz.springcloud.alibaba.seata.storage.service.StorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    StorageService storageService;

    @GetMapping
    public List<Storage> getStorageList(){
        return storageService.selectAll();
    }
}
