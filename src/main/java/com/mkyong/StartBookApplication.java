package com.mkyong;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class StartBookApplication {

    // start everything
    public static void main(String[] args) {
        SpringApplication.run(StartBookApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            repository.save(new Book(1L, "Gita", "吉塔", new BigDecimal("1.11")));
            repository.save(new Book(2L, "Urvashi", "乌尔瓦希", new BigDecimal("2.22")));
            repository.save(new Book(3L, "Alpna", "阿尔普纳", new BigDecimal("3.33")));
        };
    }
}
