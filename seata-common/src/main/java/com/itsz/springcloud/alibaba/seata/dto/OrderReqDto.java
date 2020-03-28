package com.itsz.springcloud.alibaba.seata.dto;


import lombok.Data;

@Data
public class OrderReqDto {

    private long userId;

    private long  productId;

    private int count;

    private long money;


}
