package com.amao.market.outwardservice.service;

import com.amao.market.commons.param.order.CreateMarketOrderParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author LinYuchang
 */
@FeignClient(name = "amao-market-order-service", path = "/amao-market/api")
@Component
public interface OrderService {

    @RequestMapping(value = "/order/create", method = RequestMethod.POST)
    String createOrder(CreateMarketOrderParam param);
}
