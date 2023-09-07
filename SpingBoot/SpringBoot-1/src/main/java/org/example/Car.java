package org.example;

import org.springframework.stereotype.Component;

@Component
public class Car {
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Car() {
		this.color = "yellow";
		System.out.println("car created");
	}
}
