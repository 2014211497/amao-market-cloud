package com.amao.market.commons.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author LinYuchang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderItem extends BaseModel {

    // 商品ID
    protected String wareId;

    // 数量
    protected Double count;
}
