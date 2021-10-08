package com.amao.market.orderservice.service;

import com.amao.market.commons.param.order.CancelMarketOrderParam;
import com.amao.market.commons.param.order.CreateMarketOrderParam;

/**
 * 订单服务接口
 *
 * @author LinYuchang
 */
public interface OrderService {

    String createOrder(CreateMarketOrderParam param);

    String cancelOrder(CancelMarketOrderParam param);
}
