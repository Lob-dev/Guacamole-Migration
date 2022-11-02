package com.guacamole.migration

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GuacamoleMigrationApplication

fun main(args: Array<String>) {
	runApplication<GuacamoleMigrationApplication>(*args)
}
