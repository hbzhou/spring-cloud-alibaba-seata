package com.itsz.springcloud.alibaba.seata.order.service;

import com.itsz.springcloud.alibaba.seata.domain.Order;
import com.itsz.springcloud.alibaba.seata.order.mapper.OrderMapper;
import com.itsz.springcloud.alibaba.seata.service.OrderService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    
    public int deleteByPrimaryKey(Long id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Order record) {
        return orderMapper.insert(record);
    }

    
    public int insertSelective(Order record) {
        return orderMapper.insertSelective(record);
    }

    
    public Order selectByPrimaryKey(Long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Order record) {
        return orderMapper.updateByPrimaryKey(record);
    }

    public List<Order> selectAll() {
        return orderMapper.selectAll();
    }
}
