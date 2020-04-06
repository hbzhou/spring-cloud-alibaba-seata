package com.itsz.springcloud.seata.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SeataGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataGatewayApplication.class, args);
    }
}
