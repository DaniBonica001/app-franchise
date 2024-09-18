package com.app.franchise;

import com.app.franchise.infrastructure.adapters.output.persistence.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@EnableReactiveMongoRepositories(basePackageClasses = ProductRepository.class)
public class FranchiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(FranchiseApplication.class, args);
	}

}
