package com.cg.main;


import org.springframework.beans.factory.*;
import org.springframework.beans.factory.xml.*;
import org.springframework.core.io.*;

public class Calculation {
	
	public static void main(String args[]) throws Exception {
		Resource res =new ClassPathResource("calculation.xml");
			BeanFactory factory = new XmlBeanFactory(res);
			Calculator calculator = (Calculator) factory.getBean("Calculator");
			double add = calculator.addition();
			System.out.println("a+b: "+add);
			double sub =calculator.subtraction();
			System.out.println("a-b: "+sub);
			double mul =calculator.multiplication();
			System.out.println("a*b: "+mul);
			double div =calculator.division();
			System.out.println("a/b: "+div);
		}
	}