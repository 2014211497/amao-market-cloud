package com.amao.market.commons.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author LinYuchang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderItem extends BaseModel {

    // ååID
    protected String wareId;

    // æ°é
    protected Double count;
}
