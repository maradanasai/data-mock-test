package com.example.datamocktest;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JdbcConfiguration extends AbstractJdbcConfiguration {
  @Value("${f.jdbc.url}")
  private String fUrl;

  @Value("${f.jdbc.username}")
  private String fUsername;

  @Value("${f.jdbc.password}")
  private String fPassword;

  @Bean
  NamedParameterJdbcOperations operations(DataSource dataSource) {
    return new NamedParameterJdbcTemplate(dataSource);
  }

  @Bean(name = "fOperations")
  NamedParameterJdbcOperations fOperations() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl(fUrl);
    dataSource.setUsername(fUsername);
    dataSource.setPassword(fPassword);
    return new NamedParameterJdbcTemplate(dataSource);
  }
}
