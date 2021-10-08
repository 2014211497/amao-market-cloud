package com.amao.market.orderservice.controller;

import com.amao.market.commons.param.order.CreateMarketOrderParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author LinYuchang
 */
@Slf4j
@RestController
public class OrderController {

    @Value("${eureka.instance.instance-id:random-amao-market-order-service}")
    private String eurekaInstanceId;

    @RequestMapping(value = "/order/create", method = RequestMethod.POST)
    public String createOrder(@RequestBody CreateMarketOrderParam param) {
//        log.info("creating market order with param: {}", param);
        String orderId = UUID.randomUUID().toString().replace("-", "");
        orderId += "(by " + eurekaInstanceId + ")";
        return orderId;
    }
}
