package com.tanjiaming99.config;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Slf4j
@Configuration
@Order(-1)
public class FlywayConfig {

    @Autowired
    private DataSource dataSource;
    @Value("${spring.flyway.enabled:}")
    private Boolean enabled;

    @PostConstruct
    public void migrate() {
        log.info("开始初始化flyway-" + enabled);
        if (enabled) {
            Flyway flyway = Flyway.configure()
                    .dataSource(dataSource)
                    .locations("db/migration")
                    .baselineOnMigrate(true)
                    .load();
            flyway.migrate();
        }
    }
}
