package com.itsz.springcloud.alibaba.seata.storage.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.itsz.springcloud.alibaba.seata.domain.Storage;
import com.itsz.springcloud.alibaba.seata.service.StorageService;
import com.itsz.springcloud.alibaba.seata.storage.handler.SentinelExceptionHandler;
import com.itsz.springcloud.alibaba.seata.storage.service.StorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    StorageService storageService;

    @GetMapping
    public List<Storage> getStorageList() {
        return storageService.selectAll();
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "testHotKeyHandler")
    public String testHotKey(@RequestParam(required = false) String p1,
                             @RequestParam(required = false) String p2) {
        return "testHotKey.......";
    }

    public String testHotKeyHandler(String p1, String p2, BlockException exception) {
        return "testHotKey Exception handler";
    }

    @GetMapping("/testHandler")
    @SentinelResource(value = "/testHandler", blockHandlerClass = SentinelExceptionHandler.class, blockHandler = "exceptionHandler")
    public String testHandlerByClazz(@RequestParam(required = false) String p1) {
        return " test handler By Clazz";
    }

    @GetMapping("/testRulePersist")
    public String testRulePersist(){
        return "test rule Persist";
    }
}
