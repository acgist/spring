package com.acgist.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "c3p0.properties")
public class C3P0DataSource {

	@Primary
	@Bean(name = "dataSource")
	@Qualifier(value = "dataSource")
	@ConfigurationProperties(prefix = "c3p0")
	public DataSource dataSource() {
		return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
	}
	
}