package org.example;

//@Component
public class Car {
	private String color = "yellow";
	public Car() {
		System.out.println("car object created !!!!!!");
	}

	public Car(String color){
		System.out.println("Color changed : "+ color);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
