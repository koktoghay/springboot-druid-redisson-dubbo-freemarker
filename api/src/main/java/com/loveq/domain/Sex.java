package com.loveq.domain;

import com.enterprise.data.type.DBEnum;

public enum Sex implements DBEnum {
    
    /**
     * 男
     */
    MALE(1, "男"),
    
    /**
     * 女
     */
    FEMALE(2, "女");

    private int type;

    private String name;

    Sex(int type, String name) {
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