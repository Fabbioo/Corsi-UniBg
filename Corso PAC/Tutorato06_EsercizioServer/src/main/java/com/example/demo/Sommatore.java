package com.example.demo;

public class Sommatore {
	
	int num1;
	int num2;
	
	public Sommatore(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public Result getSum() {
		return new Result(num1 + num2);
	}
	
}
