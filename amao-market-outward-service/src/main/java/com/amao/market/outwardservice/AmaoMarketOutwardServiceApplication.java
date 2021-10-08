package com.amao.market.outwardservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class AmaoMarketOutwardServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmaoMarketOutwardServiceApplication.class, args);
    }

}
