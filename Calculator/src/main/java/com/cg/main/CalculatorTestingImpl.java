package com.cg.main;

public class CalculatorTestingImpl implements Calculator{


	double a,b;
	
	public CalculatorTestingImpl() {
		super();
	}
		
	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public CalculatorTestingImpl(double a, double b) {
		super();
		this.a = a;
		this.b = b;
	}	
	public double addition() {
		
		return a+b;
	}

	 public double subtraction() {
		
		return a-b;
	}

	 public double multiplication() {
		
		return a*b;
	}

	 public double division() {
		
		return a/b;
	}

	@Override
	public String toString() {
		return "CalculatorTestingImpl [a=" + a + ", b=" + b + "]";
	}

}