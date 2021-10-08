package com.amao.market.commons.param.order;

import com.amao.market.commons.param.BaseParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author LinYuchang
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CancelMarketOrderParam extends BaseParam {

    protected String orderId;
}
