package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectFactory {

	public ObjectFactory() {
		System.out.println("object created!!!!!!!!!!!");
	}

	@Bean
	public Car createCar(){
		System.out.println("creating white color car");
		return new Car("white");
	}
}
