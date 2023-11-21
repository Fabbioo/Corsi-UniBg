package com.example.demo;

// Come primo passo devo definire il Presentation Model, ovvero la risorsa che viene ritornata.
public class Result {
	
	int result;

	public Result(int result) {
		this.result = result;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	public String toString() {
		return "[Result]: " + result;
	}
	
}
