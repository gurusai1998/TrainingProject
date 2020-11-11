package com.cg.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import com.cg.main.Calculation;
import com.cg.main.Calculator;
import com.cg.main.CalculatorTestingImpl;

@SuppressWarnings("deprecation")
public class CalcualtorTest {
	Resource res =new ClassPathResource("calculation.xml");
	BeanFactory factory = new XmlBeanFactory(res);
	Calculator calc = (Calculator) factory.getBean("Calculator");
	
	CalculatorTestingImpl calculatorImpl;
	Calculation calculation;
	
	@Before
	public void Init() {
		calculatorImpl = new CalculatorTestingImpl();
		calculation = new Calculation();
	}
	
	@Test
	public void testingAddition() {
		double add = calc.addition();
		int actualAdditionResult=(int)add;
		assertEquals(3, actualAdditionResult);
	}
	
	@Test
	public void testingSubtraction() {
		double sub = calc.subtraction();
		int actualSubtractionResult=(int)sub;
		assertEquals(1, actualSubtractionResult);
	}
	
	@Test
	public void testingMultiplication() {
		double mul = calc.multiplication();
		int actualMultiplicationResult=(int)mul;
		assertEquals(2, actualMultiplicationResult);
	}
	
	@Test
	public void testingDivision() {
		double div = calc.division();
		int actualDivisionResult=(int)div;
		assertEquals(2, actualDivisionResult);
	}
}
