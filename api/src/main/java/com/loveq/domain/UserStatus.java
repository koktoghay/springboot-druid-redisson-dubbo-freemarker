package com.loveq.domain;

import com.enterprise.data.type.DBEnum;

public enum UserStatus implements DBEnum {
    
    /**
     * 正常
     */
    NORMAL(1, "正常"),
    
    /**
     * 登陆锁定
     */
    LOGIN_LOCKED(2, "登陆锁定"),
    
    /**
     * 下单锁定
     */
    ORDER_LOCKED(3, "下单锁定"),
    
    /**
     * 删除
     */
    DELETED(4, "删除");

    private int type;

    private String name;

    UserStatus(int type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public int getTypeValue() {
        return type;
    }

    public String getName() {
        return name;
    }
}