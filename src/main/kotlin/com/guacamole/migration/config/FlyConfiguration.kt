package com.guacamole.migration.config

import org.flywaydb.core.Flyway
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class FlyConfiguration(
    private val dataSource: DataSource,
) {

    @Bean
    protected fun flyway(): Flyway =
        Flyway.configure()
            .dataSource(dataSource)
            .baselineOnMigrate(true)
            .encoding("UTF-8")
            .load()
}
