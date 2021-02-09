package com.manuja.shoppingapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.manuja.shoppingapp.repository.UserRepository;
import com.manuja.shoppingapp.storage.StorageProperties;
import com.manuja.shoppingapp.storage.StorageService;

@SpringBootApplication
@ComponentScan({"com.manuja.shoppingapp"})
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EnableConfigurationProperties(StorageProperties.class)
public class ShoppingappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingappApplication.class, args);
		
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

}


