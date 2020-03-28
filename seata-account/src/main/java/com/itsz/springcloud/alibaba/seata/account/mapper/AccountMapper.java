package com.itsz.springcloud.alibaba.seata.account.mapper;


import com.itsz.springcloud.alibaba.seata.domain.Account;

import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    List<Account> selectAll();

    Account findByUserId(long userId);
}