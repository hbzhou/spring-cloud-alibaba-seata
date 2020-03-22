package com.itsz.springcloud.alibaba.seata.account.service;

import com.itsz.springcloud.alibaba.seata.domain.Account;
import com.itsz.springcloud.alibaba.seata.service.AccountService;

import javax.annotation.Resource;

import com.itsz.springcloud.alibaba.seata.account.mapper.AccountMapper;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;


    public int deleteByPrimaryKey(Long id) {
        return accountMapper.deleteByPrimaryKey(id);
    }


    public int insert(Account record) {
        return accountMapper.insert(record);
    }


    public int insertSelective(Account record) {
        return accountMapper.insertSelective(record);
    }


    public Account selectByPrimaryKey(Long id) {
        return accountMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(Account record) {
        return accountMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Account record) {
        return accountMapper.updateByPrimaryKey(record);
    }

    public List<Account> selectAll() {
        return accountMapper.selectAll();
    }

}
