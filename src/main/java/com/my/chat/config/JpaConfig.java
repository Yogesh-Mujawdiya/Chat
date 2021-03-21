package com.my.chat.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ConfigurationProperties(prefix = "params.datasource")
public class JpaConfig extends HikariConfig {

	String driveClassName = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://127.0.0.1/my-chat";
	String username = "root";
	String password = "";

	@Bean
	public DataSource dataSource() throws SQLException {
		HikariDataSource hikariDataSource = new HikariDataSource();
		hikariDataSource.setDriverClassName(driveClassName);
		hikariDataSource.setJdbcUrl(url);
		hikariDataSource.setUsername(username);
		hikariDataSource.setPassword(password);
		hikariDataSource.setMaximumPoolSize(10000000);
		hikariDataSource.setConnectionTimeout(30000);
		hikariDataSource.setIdleTimeout(600000);
		hikariDataSource.setMaxLifetime(3600000);
		
		return hikariDataSource;
	}

}
