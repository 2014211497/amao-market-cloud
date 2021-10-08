package com.amao.market.commons.param.order;

import com.amao.market.commons.model.BaseModel;
import com.amao.market.commons.model.OrderItem;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author LinYuchang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CreateMarketOrderParam extends BaseModel {

    protected List<OrderItem> itemList;
}
