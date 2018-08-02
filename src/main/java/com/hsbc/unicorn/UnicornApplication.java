package com.hsbc.unicorn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hsbc.unicorn"})
@EnableJpaRepositories("com.hsbc.unicorn.repository")
@EntityScan("com.hsbc.unicorn.entity")
public class UnicornApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnicornApplication.class, args);
	}
}
