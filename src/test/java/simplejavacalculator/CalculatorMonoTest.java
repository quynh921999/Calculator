package simplejavacalculator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorMonoTest {

    @Test
    public void calculateSquare() {
        Calculator calculator = new Calculator();
        Double res =  calculator.calculateMono(Calculator.MonoOperatorModes.square, 3.0);
        res = calculator.calculateMono(Calculator.MonoOperatorModes.square, res);
        Assert.assertEquals(81.0, res, 0.01);
    }

    @Test
    public void calculateAbs() {
        Calculator calculator = new Calculator();
        Double res =  calculator.calculateMono(Calculator.MonoOperatorModes.abs, -63.0);
        Assert.assertEquals(63.0, res, 0.01);
    }

    @Test
    public void calculateSin() {
        Calculator calculator = new Calculator();
        calculator.reset();
        Double res =  calculator.calculateMono(Calculator.MonoOperatorModes.sin, 1.0);
        Assert.assertTrue(res - 0.84 < 0.02);
    }

    @Test
    public void calculateTan() {
        Calculator calculator = new Calculator();
        Double res =  calculator.calculateMono(Calculator.MonoOperatorModes.tan, 1.0);
        Assert.assertTrue(res - 1.55 < 0.01);
    }
}