package com.pasantia.abmlibros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@SpringBootApplication
public class AbmlibrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbmlibrosApplication.class, args);
	}

}
