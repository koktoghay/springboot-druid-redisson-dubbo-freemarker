package com.loveq.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author tommy
 */
@Data
@Component
@ConfigurationProperties(prefix = "coreConfig", ignoreUnknownFields = false)
public class CoreConfig {

    /**
     * 每页数目
     */
    private Integer pageSize;

    /**
     * IP白名单(没有配置或者为空，则允许所有访问)
     */
    private String druidMonitorAllow = "127.0.0.1,192.168.12.38";

    /**
     * IP黑名单 (存在共同时，deny优先于allow)
     */
    private String druidMonitorDeny = "192.168.188.94,192.168.188.95,192.168.188.96";

    /**
     * 用户名
     */
    private String druidMonitorLoginUsername = "taominghua";

    /**
     * 密码
     */
    private String druidMonitorLoginPassword = "gold2018";

    /**
     * 禁用HTML页面上的“Reset All”功能
     */
    private String druidMonitorResetEnable = "false";

    /**
     * druid过滤器 忽略资源
     */
    private String druidMonitorExclusions = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*";

}
