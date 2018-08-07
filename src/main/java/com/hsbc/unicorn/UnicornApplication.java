package com.hsbc.unicorn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hsbc.unicorn"})
@EnableJpaRepositories("com.hsbc.unicorn.repository")
@EntityScan("com.hsbc.unicorn.entity")
@EnableGlobalMethodSecurity(prePostEnabled=true)//只有当这个注解启动了之后，才能让权限配置生效
public class UnicornApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnicornApplication.class, args);
	}
}
