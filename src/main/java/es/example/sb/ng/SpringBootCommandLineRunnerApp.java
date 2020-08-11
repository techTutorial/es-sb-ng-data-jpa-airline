package es.example.sb.ng;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.example.sb.ng.model.EsEmployeeEntity;
import es.example.sb.ng.repository.EsEmployeeRepository;

import java.math.BigDecimal;

@SpringBootApplication
public class SpringBootCommandLineRunnerApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCommandLineRunnerApp.class, args);
    }

    // can not enable database and hard-coded way features at the same time
    // Initialize Repository bean using hard-coded way
    /*@Bean
    CommandLineRunner initRepositoryBean(EsEmployeeRepository repository) {
        return args -> {
            repository.save(new EsEmployeeEntity(101L, "Gita", "CH吉塔", new BigDecimal("511.11")));
            repository.save(new EsEmployeeEntity(102L, "Urvashi", "CH乌尔瓦希", new BigDecimal("522.22")));
            repository.save(new EsEmployeeEntity(103L, "Alpna", "CH阿尔普纳", new BigDecimal("533.33")));
        };
    }*/
}
