package com.vishnu.ecommerceMVC.repo;

import com.vishnu.ecommerceMVC.entities.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class DataSource {
	@Bean
	public HashMap<Integer, Product> createDataSource(){
		return new HashMap<>();
	}
}
