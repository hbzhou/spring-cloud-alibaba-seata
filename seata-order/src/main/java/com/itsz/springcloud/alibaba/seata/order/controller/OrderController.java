package com.itsz.springcloud.alibaba.seata.order.controller;

import com.itsz.springcloud.alibaba.seata.domain.Account;
import com.itsz.springcloud.alibaba.seata.domain.Order;
import com.itsz.springcloud.alibaba.seata.domain.Storage;
import com.itsz.springcloud.alibaba.seata.dto.OrderReqDto;
import com.itsz.springcloud.alibaba.seata.order.service.OrderServiceImpl;
import com.itsz.springcloud.alibaba.seata.service.AccountService;
import com.itsz.springcloud.alibaba.seata.service.OrderService;
import com.itsz.springcloud.alibaba.seata.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Reference
    OrderService orderService;


    @GetMapping()
    public List<Order> getOrderList(){
        return orderService.selectAll();
    }


    @PostMapping("/create")
    public void createOrder(@RequestBody OrderReqDto request) {
        orderService.createOrder(request);
    }
}
