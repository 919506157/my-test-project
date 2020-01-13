package com.mybatis.entity;

import java.util.Date;

public class CpsSettlementExchange {
    private String id;

    private String collectOrderId;

    private String accountId;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCollectOrderId() {
        return collectOrderId;
    }

    public void setCollectOrderId(String collectOrderId) {
        this.collectOrderId = collectOrderId == null ? null : collectOrderId.trim();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}