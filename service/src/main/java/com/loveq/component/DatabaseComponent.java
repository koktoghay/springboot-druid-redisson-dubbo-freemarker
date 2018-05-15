package com.loveq.component;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import com.enterprise.data.factory.EnterpriseSqlSessionFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.stream.Stream;

/**
 * Created by tommy
 */
@Slf4j
@Configuration
@MapperScan(basePackages = {"com.loveq.dao"}, sqlSessionFactoryRef = "sqlSessionFactoryWrite")
public class DatabaseComponent {

    @Bean(name = "dataSourceWrite")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.wall.config")
    public WallConfig wallConfig() {
        return new WallConfig();
    }

    @Bean
    public WallFilter wallFilter() {
        WallFilter filter = new WallFilter();
        filter.setConfig(wallConfig());
        filter.setDbType("mysql");
        return filter;
    }

    @Bean
    @Primary
    public PlatformTransactionManager transactionManager(@Qualifier("dataSourceWrite") DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        return dataSourceTransactionManager;
    }

    @Bean(name = "sqlSessionFactoryWrite")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ConfigurableApplicationContext applicationContext) throws Exception {

        EnterpriseSqlSessionFactory sessionFactoryBean = new EnterpriseSqlSessionFactory();
        sessionFactoryBean.setDataSource(dataSource());

//        sessionFactoryBean.addInterfaceTypeHandler(DBEnum.class, DBEnumTypeHandler.class);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:mybatis/**/*Mapper.xml");
        Resource[] resourcesGen = resolver.getResources("classpath*:mybatis-generator/**/*Mapper.xml");
        sessionFactoryBean.setMapperLocations(Stream.of(resources, resourcesGen).flatMap(Stream::of).toArray(Resource[]::new));

        sessionFactoryBean.addScanInterfacePackages("com.loveq.launch");
        SqlSessionFactory object;
        try {
            object = sessionFactoryBean.getObject();
        } catch (Exception e) {
            log.error("mybatis启动出错", e);
            throw e;
        }

        return object;
    }

}
