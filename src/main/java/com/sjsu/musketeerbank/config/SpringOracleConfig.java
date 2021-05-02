package com.sjsu.musketeerbank.config;


import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;




@Configuration
public class SpringOracleConfig {
	
	

	private static final Logger LOG = LoggerFactory.getLogger(SpringOracleConfig.class);

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String usernameProp;
	
	@Value("${spring.datasource.password}")
	private String mysqlpassword;

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.hikari.maximumPoolSize}")
	private int maxPoolSize;

	@Value("${spring.datasource.hikari.connectionTimeout}")
	private int connTimeOut;

	@Value("${spring.datasource.hikari.minimumIdle}")
	private int minIdle;

	@Value("${spring.datasource.hikari.idleTimeout}")
	private int idleTimeOut;
	


	/**
	 * See <a href="http://google.com">http://www.baeldung.com/hikaricp</a>
	 */
	@Bean
	public HikariDataSource getHikariDataSource() {
		
	
		Properties prop = new Properties();
        prop.put("url", url);
        prop.put("user", usernameProp);
        prop.put("password", mysqlpassword);
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(driverClassName);
		hikariConfig.setUsername(usernameProp);
		hikariConfig.setJdbcUrl(url);
		hikariConfig.setDataSourceProperties(prop); 
		hikariConfig.setMaximumPoolSize(maxPoolSize);
		hikariConfig.setConnectionTimeout(connTimeOut);
		hikariConfig.setMinimumIdle(minIdle);
		hikariConfig.setIdleTimeout(idleTimeOut);
		

		HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);

		if (hikariDataSource.isRunning()) {
			LOG.info("------> MySQL DB connection successfully.");
		}

		return hikariDataSource;

	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getHikariDataSource());
		return jdbcTemplate;
	}
	
	

}