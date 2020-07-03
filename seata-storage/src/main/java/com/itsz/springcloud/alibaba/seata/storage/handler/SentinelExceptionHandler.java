package com.itsz.springcloud.alibaba.seata.storage.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class SentinelExceptionHandler {

    public static String exceptionHandler(BlockException exception) {
        return "Sentinel Exception Handler handling exception";

    }
}
