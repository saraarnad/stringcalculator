package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

     	public static void main(String args[]) {
        	org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
     	}

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(2, Calculator.add("2"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    	public void testMultipleNumbers(){
    	 	assertEquals(9, Calculator.add("2,3,4"));
        }

	@Test
	public void testNewLine(){
		assertEquals(7, Calculator.add("1\n2,3\n1"));
	}
		
	@Test
	public void testDelimiterMultipleNumbers(){
		assertEquals(6, Calculator.add("//8\n18283"));
	}
	
	@Test
	public void testDelimeter(){
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test
	public void testDelimeterOneNumber(){
		assertEquals(1, Calculator.add("//;\n1"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testNegativeNumber(){
            	Calculator.add("-1,2");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testManyNegativeNumbers(){
		Calculator.add("2,-4,3,-5");
	}
	
	@Test 
	public void testBig(){
		assertEquals(2, Calculator.add("1001,2"));
	}
	
	@Test
	public void testAnyLenghtDelimiter(){
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}
	
	@Test
	public void testAnyLenghtDelimiterNumber(){
		assertEquals(6, Calculator.add("//[88]\n1882883"));
	}
}
