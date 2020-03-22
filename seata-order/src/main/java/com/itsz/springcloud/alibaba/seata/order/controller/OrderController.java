package com.itsz.springcloud.alibaba.seata.order.controller;

import com.itsz.springcloud.alibaba.seata.domain.Order;
import com.itsz.springcloud.alibaba.seata.order.service.OrderServiceImpl;
import com.itsz.springcloud.alibaba.seata.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping()
    public List<Order> getOrderList(){
        return orderService.selectAll();
    }
}
