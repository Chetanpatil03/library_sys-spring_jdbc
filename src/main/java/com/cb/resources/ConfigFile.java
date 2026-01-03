package com.cb.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.cb")
public class ConfigFile {

	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName("com.mysql.cj.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
		source.setUsername("root");
		source.setPassword("root");
		return source;
	}
	
	@Bean
	public NamedParameterJdbcTemplate geNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(getDataSource());
	}
	
	@Bean
	public JdbcTemplate geTemplate() {
		return new JdbcTemplate(getDataSource());
	}
}

