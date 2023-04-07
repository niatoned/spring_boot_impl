package com.emonics.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.emonics.dao.ContactDao;
import com.emonics.dao.ContactDaoImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.emonics")
public class MvcConfiguration implements WebMvcConfigurer {
	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("WEB-INF/jsp/");
		bean.setSuffix(".jsp");
		return bean;
	}
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/emonics");
		dataSource.setUsername("root");
		dataSource.setPassword("admin");
		
		return dataSource;
	}
	
	@Bean
	public ContactDao getContactDao() {
		return new ContactDaoImpl(getDataSource());
	}
}
