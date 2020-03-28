package com.itsz.springcloud.alibaba.seata.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;

    /**
    * 用户id
    */
    private Long userId;

    /**
    * 总额度
    */
    private long total;

    /**
    * 已用额度
    */
    private long used;

    /**
    * 剩余额度
    */
    private long residue;
}