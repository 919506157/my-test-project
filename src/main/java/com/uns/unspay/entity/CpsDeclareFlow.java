package com.uns.unspay.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CpsDeclareFlow {
    private String id;

    private String declareDetailId;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String payerName;

    private String payerCertType;

    private String payerCertNo;

    private BigDecimal amount;

    private String currencyId;

    private String payerMobile;

    private String resCode;

    private String resMsg;

    private String extJson;

    private String remark;

    private String requestNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDeclareDetailId() {
        return declareDetailId;
    }

    public void setDeclareDetailId(String declareDetailId) {
        this.declareDetailId = declareDetailId == null ? null : declareDetailId.trim();
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

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName == null ? null : payerName.trim();
    }

    public String getPayerCertType() {
        return payerCertType;
    }

    public void setPayerCertType(String payerCertType) {
        this.payerCertType = payerCertType == null ? null : payerCertType.trim();
    }

    public String getPayerCertNo() {
        return payerCertNo;
    }

    public void setPayerCertNo(String payerCertNo) {
        this.payerCertNo = payerCertNo == null ? null : payerCertNo.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId == null ? null : currencyId.trim();
    }

    public String getPayerMobile() {
        return payerMobile;
    }

    public void setPayerMobile(String payerMobile) {
        this.payerMobile = payerMobile == null ? null : payerMobile.trim();
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

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo == null ? null : requestNo.trim();
    }
}