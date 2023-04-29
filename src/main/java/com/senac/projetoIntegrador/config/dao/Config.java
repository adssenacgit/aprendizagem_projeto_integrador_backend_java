package com.senac.projetoIntegrador.config.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import javax.sql.DataSource;



@Configuration
public class Config {
    
    @Autowired
    private Environment environment;

    @Bean(destroyMethod = "close")
    DataSource dbConnection(){

        org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl(environment.getProperty("spring.datasource.url"));
        ds.setUsername(environment.getProperty("spring.datasource.username"));
        ds.setPassword(environment.getProperty("spring.datasource.password"));
        ds.isTestOnBorrow();
        ds.setValidationQuery("SELECT 1");
        
        ds.setValidationInterval(30000);
        ds.setTimeBetweenEvictionRunsMillis(30000);
        ds.setMaxActive(Integer.valueOf(environment.getProperty("spring.datasource.maxsize")));
        ds.setInitialSize(Integer.valueOf(environment.getProperty("spring.datasource.minsize")));
        ds.setMaxWait(10000);
        ds.setRemoveAbandonedTimeout(60);
        ds.setMinEvictableIdleTimeMillis(30000);
        ds.setMinIdle(10);
        // ds.isTestOnReturn = false;
        // ds.minIdle = 10;
        // ds.isLogAbandoned = true;
        // ds.isRemoveAbandoned = true;
        System.out.println(ds);
        return ds;
    }
}
