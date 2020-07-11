package com.betpawa.task.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.betpawa.task.dao"),
	      @ComponentScan("com.betpawa.task.service") })
public class AppConfig {
	@Autowired
    private Environment env;	
	
	@Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(sessionFactory());
	}
	
	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(getDataSource());
		lsfb.setPackagesToScan("com.betpawa.task.model");
		lsfb.setHibernateProperties(hibernateProperties());
		try {
			lsfb.afterPropertiesSet();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lsfb.getObject();
	}
	
    @Bean
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName(env.getProperty("database.driverClassName"));
	    dataSource.setUrl(env.getProperty("database.url"));
	    dataSource.setUsername(env.getProperty("database.username"));
	    dataSource.setPassword(env.getProperty("database.password"));
	    return dataSource;
	}
    
	@Bean
	public HibernateTransactionManager hibernateTransactionManager(){
	    return new HibernateTransactionManager(sessionFactory());
	}
	
	
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.id.new_generator_mappings", env.getProperty("hibernate.id.new_generator_mappings"));
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        return properties;        
    }	
}
