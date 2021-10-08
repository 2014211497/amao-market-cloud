package com.amao.market.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AmaoMarketEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmaoMarketEurekaServerApplication.class, args);
    }

}
