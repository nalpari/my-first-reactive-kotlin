package net.devgrr.myfirstreactivekotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class MyFirstReactiveKotlinApplication

fun main(args: Array<String>) {
	runApplication<MyFirstReactiveKotlinApplication>(*args)
}
