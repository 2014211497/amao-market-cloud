package com.amao.market.commons.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 订单类
 *
 * @author LinYuchang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MarketOrder extends BaseModel {

    // 商品明细列表
    protected List<OrderItem> itemList;

    // 应付总价
    protected Double totalPrice;
}
