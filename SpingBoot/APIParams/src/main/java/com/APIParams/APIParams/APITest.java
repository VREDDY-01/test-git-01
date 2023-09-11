package com.APIParams.APIParams;

import org.springframework.web.bind.annotation.*;

@RestController
public class APITest {

	@GetMapping("vishnu")
	public String getName(){
		return "Vishnu";
	}

//	1)Path Variables
	@GetMapping("vishnu/{surname}")
	public String getSurname(@PathVariable String surname){
		return surname;
	}
	@GetMapping("vishnu/{surname}/{age}")
	public String getSurname(@PathVariable String surname,@PathVariable Integer age){
		return surname+" "+age;
	}

//	2)HashTable - Request Params
	@GetMapping("multiply")   //-->localhost:8080/multiply?num1=5&num2=4
	public Integer multiply(@RequestParam Integer num1,@RequestParam Integer num2){
		return num1*num2;
	}

//	3)Request bodyParams
	@GetMapping("fullName")  //--> Only one parameter can be used
	public String fullName(@RequestBody String fName){
		return fName;
	}

}
