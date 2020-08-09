package com.mkyong;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class SpringBootCommandLineRunnerApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCommandLineRunnerApp.class, args);
    }

    // Initialize Repository bean using hard-coded way
    @Bean
    CommandLineRunner initRepositoryBean(EsEmployeeRepository repository) {
        return args -> {
            repository.save(new EsEmployeeEntity(1L, "Gita", "吉塔", new BigDecimal("1.11")));
            repository.save(new EsEmployeeEntity(2L, "Urvashi", "乌尔瓦希", new BigDecimal("2.22")));
            repository.save(new EsEmployeeEntity(3L, "Alpna", "阿尔普纳", new BigDecimal("3.33")));
        };
    }
}
