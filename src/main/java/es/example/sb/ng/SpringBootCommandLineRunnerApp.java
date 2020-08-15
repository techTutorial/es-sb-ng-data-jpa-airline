package es.example.sb.ng;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.example.sb.ng.model.EsEmployeeEntity;
import es.example.sb.ng.repository.EsEmployeeRepository;

import java.math.BigDecimal;

import javax.persistence.GenerationType;

@SpringBootApplication
public class SpringBootCommandLineRunnerApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCommandLineRunnerApp.class, args);
    }

    // Initialize Repository bean using hard-coded way
    // it is mandatory to use GenerationType.IDENTITY
    // because it allows to maintain unique primary key automatically
    // provided id value is not effective
    @Bean
    CommandLineRunner initRepositoryBean(EsEmployeeRepository repository) {
        return args -> {
            repository.save(new EsEmployeeEntity(101L, "Gita", "CH吉塔", new BigDecimal("511.11"), 18));
            repository.save(new EsEmployeeEntity(102L, "Urvashi", "CH乌尔瓦希", new BigDecimal("522.22"), 18));
            repository.save(new EsEmployeeEntity(103L, "Alpna", "CH阿尔普纳", new BigDecimal("533.33"), 18));
        };
    }
}
