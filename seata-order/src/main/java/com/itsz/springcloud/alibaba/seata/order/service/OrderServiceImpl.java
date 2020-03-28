package com.itsz.springcloud.alibaba.seata.order.service;

import com.itsz.springcloud.alibaba.seata.domain.Account;
import com.itsz.springcloud.alibaba.seata.domain.Order;
import com.itsz.springcloud.alibaba.seata.domain.Storage;
import com.itsz.springcloud.alibaba.seata.dto.OrderReqDto;
import com.itsz.springcloud.alibaba.seata.order.mapper.OrderMapper;
import com.itsz.springcloud.alibaba.seata.service.AccountService;
import com.itsz.springcloud.alibaba.seata.service.OrderService;
import com.itsz.springcloud.alibaba.seata.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Reference(check = false)
    StorageService storageService;

    @Reference(check = false)
    AccountService accountService;

    
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

    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    @Override
    public void createOrder(OrderReqDto request) {
        long userId = request.getUserId();
        long productId = request.getProductId();
        int count = request.getCount();
        long money = request.getMoney();

        Order order = new Order();
        order.setCount(count);
        order.setProductId(productId);
        order.setUserId(userId);
        order.setMoney(money);
        order.setStatus(0);
        orderMapper.insert(order);

        Storage storage = storageService.findByProductId(productId);
        storage.setTotal(storage.getTotal() - count);
        storage.setUsed(storage.getUsed() + count);
        storage.setResidue(storage.getResidue() - count);
        storageService.updateByPrimaryKey(storage);

        Account account = accountService.findByUserId(userId);
        account.setTotal(account.getTotal() - money);
        account.setUsed(account.getUsed() + money);
        account.setResidue(account.getResidue() - money);
        accountService.updateByPrimaryKey(account);
    }
}
