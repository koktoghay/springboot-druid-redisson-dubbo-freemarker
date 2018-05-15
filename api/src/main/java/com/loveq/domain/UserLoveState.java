package com.loveq.domain;

import com.enterprise.data.type.DBEnum;

public enum UserLoveState implements DBEnum {
    
    /**
     * 单身狗
     */
    SINGLE(1, "单身狗"),
    
    /**
     * 已脱单
     */
    NON_SINGLE(2, "已脱单");

    private int type;

    private String name;

    UserLoveState(int type, String name) {
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