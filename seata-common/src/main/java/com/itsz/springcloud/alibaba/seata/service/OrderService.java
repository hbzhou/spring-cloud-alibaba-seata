package com.itsz.springcloud.alibaba.seata.service;

import com.itsz.springcloud.alibaba.seata.domain.Order;

import java.util.List;

public interface OrderService {

    int deleteByPrimaryKey(Long id);


    int insert(Order record);


    int insertSelective(Order record);


    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);


    int updateByPrimaryKey(Order record);

    List<Order> selectAll();
}
