package com.uns.unspay.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CpsDeclareOrder {
    private String id;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String requestNo;

    private String accountId;

    private String accountName;

    private String declarePortId;

    private String currencyId;

    private String declareFee;

    private Integer totalDeclareNum;

    private Integer successDeclareNum;

    private BigDecimal totalDeclareAmount;

    private BigDecimal successDeclareAmount;

    private Integer isPurchase;

    private String requestSource;

    private String version;

    private String signType;

    private String notifyUrl;

    private String extJson;

    private String remark;

    private String resCode;

    private String resMsg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo == null ? null : requestNo.trim();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getDeclarePortId() {
        return declarePortId;
    }

    public void setDeclarePortId(String declarePortId) {
        this.declarePortId = declarePortId == null ? null : declarePortId.trim();
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId == null ? null : currencyId.trim();
    }

    public String getDeclareFee() {
        return declareFee;
    }

    public void setDeclareFee(String declareFee) {
        this.declareFee = declareFee == null ? null : declareFee.trim();
    }

    public Integer getTotalDeclareNum() {
        return totalDeclareNum;
    }

    public void setTotalDeclareNum(Integer totalDeclareNum) {
        this.totalDeclareNum = totalDeclareNum;
    }

    public Integer getSuccessDeclareNum() {
        return successDeclareNum;
    }

    public void setSuccessDeclareNum(Integer successDeclareNum) {
        this.successDeclareNum = successDeclareNum;
    }

    public BigDecimal getTotalDeclareAmount() {
        return totalDeclareAmount;
    }

    public void setTotalDeclareAmount(BigDecimal totalDeclareAmount) {
        this.totalDeclareAmount = totalDeclareAmount;
    }

    public BigDecimal getSuccessDeclareAmount() {
        return successDeclareAmount;
    }

    public void setSuccessDeclareAmount(BigDecimal successDeclareAmount) {
        this.successDeclareAmount = successDeclareAmount;
    }

    public Integer getIsPurchase() {
        return isPurchase;
    }

    public void setIsPurchase(Integer isPurchase) {
        this.isPurchase = isPurchase;
    }

    public String getRequestSource() {
        return requestSource;
    }

    public void setRequestSource(String requestSource) {
        this.requestSource = requestSource == null ? null : requestSource.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType == null ? null : signType.trim();
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    public String getExtJson() {
        return extJson;
    }

    public void setExtJson(String extJson) {
        this.extJson = extJson == null ? null : extJson.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode == null ? null : resCode.trim();
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg == null ? null : resMsg.trim();
    }
}