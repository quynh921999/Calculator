package simplejavacalculator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorBiTest {

    @Test
    public void calculateBiAddTest() {
        Calculator calculator = new Calculator();
        calculator.calculateBi(Calculator.BiOperatorModes.add, 3.0);
        calculator.calculateBi(Calculator.BiOperatorModes.add, 5.0);
        Assert.assertEquals(10.5, calculator.calculateBi(Calculator.BiOperatorModes.normal, 2.5), 0.01);
    }

    @Test
    public void calculateBiMinusTest() {
        Calculator calculator = new Calculator();
        calculator.calculateBi(Calculator.BiOperatorModes.minus, 3.1415);
        Assert.assertEquals(2.0415, calculator.calculateBi(Calculator.BiOperatorModes.normal, 1.1), 0.01);
    }

    @Test
    public void calculateBiMultiplyTest() {
        Calculator calculator = new Calculator();
        calculator.reset();
        calculator.calculateBi(Calculator.BiOperatorModes.multiply, 3.2);
        calculator.calculateBi(Calculator.BiOperatorModes.multiply, 2.5);
        Assert.assertEquals(16.0, calculator.calculateBi(Calculator.BiOperatorModes.normal, 2.0), 0.01);
    }

    @Test
    public void calculateBiDivideTest() {
        Calculator calculator = new Calculator();
        calculator.calculateBi(Calculator.BiOperatorModes.divide, 3.2);
        calculator.calculateBi(Calculator.BiOperatorModes.divide, 2.0);
        Assert.assertEquals(0.8, calculator.calculateBi(Calculator.BiOperatorModes.normal, 2.0), 0.01);
    }
}