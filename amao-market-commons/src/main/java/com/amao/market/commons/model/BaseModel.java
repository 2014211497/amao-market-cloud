package com.amao.market.commons.model;

import lombok.Data;

/**
 * @author LinYuchang
 */
@Data
public class BaseModel {

    protected String id;

    protected String creatorId;

    protected String updaterId;

    protected String deleterId;

    protected Long createTime;

    protected Long updateTime;

    protected Long deleteTime;

    protected Long isDeleted;
}
