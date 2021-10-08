package com.amao.market.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AmaoMarketGatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmaoMarketGatewayServerApplication.class, args);
    }

}
