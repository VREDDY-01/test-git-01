package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiTest {
	@Autowired
	Car carObj;

	@GetMapping("api/v1/api1")
	public String api1(){
		return "Vishnu";
	}

	@GetMapping("api/v1/getCar")
	public Car getCar(){
		return carObj;
	}

	@PutMapping("api/v1/car/setColor")
	public String setColor(){
		carObj.setColor("red");
		return "color changed";
	}
}
