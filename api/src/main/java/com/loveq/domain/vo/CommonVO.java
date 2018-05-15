package com.loveq.domain.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommonVO implements Serializable {

    /**
     * 默认第一页
     */
    private Integer pageNum = 1;

    /**
     * 每页条数
     */
    private Integer pageSize = 10;

    /**
     * 排序
     */
    private String orderBy;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

}
