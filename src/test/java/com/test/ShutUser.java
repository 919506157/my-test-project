package com.test;

import com.alibaba.fastjson.annotation.JSONField;

public class ShutUser {
    @JSONField(name = "Member_Account")
    private String userId;
    @JSONField(name = "ShuttedUntil")
    private Long time;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
