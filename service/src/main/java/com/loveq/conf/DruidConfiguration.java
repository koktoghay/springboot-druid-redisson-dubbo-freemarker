package com.loveq.conf;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tommy
 */
@Slf4j
@Configuration
public class DruidConfiguration {

    @Autowired
    private CoreConfig coreConfig;

    @Bean
    public ServletRegistrationBean druidServlet() {
        log.info("init Druid Servlet Configuration ");
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        Map<String, String> initParameters = new HashMap<>();
        // IP白名单 (没有配置或者为空，则允许所有访问)
        initParameters.put("allow", coreConfig.getDruidMonitorAllow());
        // IP黑名单 (存在共同时，deny优先于allow)
        initParameters.put("deny", coreConfig.getDruidMonitorDeny());
        // 用户名
        initParameters.put("loginUsername", coreConfig.getDruidMonitorLoginUsername());
        // 密码
        initParameters.put("loginPassword", coreConfig.getDruidMonitorLoginPassword());
        // 禁用HTML页面上的“Reset All”功能
        initParameters.put("resetEnable", coreConfig.getDruidMonitorResetEnable());
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", coreConfig.getDruidMonitorExclusions());
        return filterRegistrationBean;
    }
}
