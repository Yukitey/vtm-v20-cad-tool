package com.yukitey.spring.vtmv20.vtmv20cadtool.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:5435/vtm_v20_cad_db")
                .username("cad_admin")
                .password("cad_admin_13")
                .build();
    }
}