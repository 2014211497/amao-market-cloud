package com.amao.market.outwardservice.controller;

import com.amao.market.commons.param.order.CreateMarketOrderParam;
import com.amao.market.commons.ropo.Result;
import com.amao.market.outwardservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LinYuchang
 */
@Slf4j
@RestController
public class OrderController {

    @Value("${eureka.instance.instance-id:random-outward-service-id}")
    private String eurekaInstanceId;

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/order/create", method = RequestMethod.POST)
    public Result<String> createOrder(@RequestBody CreateMarketOrderParam param) {
//        log.info("{} creating order by calling remote service", eurekaInstanceId);
        String orderId = orderService.createOrder(param);
        String data = eurekaInstanceId + " created order id " + orderId;
        return Result.C200(data);
    }
}
