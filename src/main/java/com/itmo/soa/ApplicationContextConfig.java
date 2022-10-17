package com.itmo.soa;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;

import javax.sql.DataSource;

/**
 * @program: SOA-Lab2
 * @description:
 * @author: Siyuan
 * @create: 2022-10-11 13:21
 **/
@Configuration
@MapperScan("com.itmo.soa.models.mappers")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class})
public class ApplicationContextConfig {

    /**
     * @return RestTemplate
     * @description: RestTemplate bean. We can use this bean to send http request to the first service.
     */
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public DataSource dataSource() {
        PGSimpleDataSource ds = new PGSimpleDataSource();
        String postgresURL = "jdbc:postgresql://pg:5432/studs";
        ds.setUrl(postgresURL);
        String postgresUser = "s273720";
        ds.setUser(postgresUser);
        String postgresPassword = "UDU8hfjQjziKasms";
        ds.setPassword(postgresPassword);
        return ds;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        return factoryBean.getObject();
    }
}
