package com.example.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@EnableJpaAuditing
@SpringBootApplication
public class TransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}

    @Bean
    HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		return new HiddenHttpMethodFilter();
	}

}
