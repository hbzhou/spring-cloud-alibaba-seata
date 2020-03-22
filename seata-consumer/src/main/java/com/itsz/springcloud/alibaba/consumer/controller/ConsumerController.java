package com.itsz.springcloud.alibaba.consumer.controller;

import com.itsz.springcloud.alibaba.seata.domain.Account;
import com.itsz.springcloud.alibaba.seata.domain.Order;
import com.itsz.springcloud.alibaba.seata.domain.Storage;
import com.itsz.springcloud.alibaba.seata.service.AccountService;
import com.itsz.springcloud.alibaba.seata.service.OrderService;
import com.itsz.springcloud.alibaba.seata.service.StorageService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Reference
    AccountService accountService;

    @Reference
    OrderService orderService;

    @Reference
    StorageService storageService;

    @PostMapping
    public void consume(){
        List<Account> accounts = accountService.selectAll();
        List<Order> orders = orderService.selectAll();
        List<Storage> storages = storageService.selectAll();
    }





}
