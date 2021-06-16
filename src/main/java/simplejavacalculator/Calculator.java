/**
 * @name        Simple Java Calculator
 * @package     ph.calculator
 * @file        Main.java
 * @author      SORIA Pierre-Henry
 * @email       pierrehs@hotmail.com
 * @link        http://github.com/pH-7
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 */

package simplejavacalculator;
import static java.lang.Double.NaN;

public class Calculator {

    public enum BiOperatorModes {
        normal, add, minus, multiply, divide , xpowerofy 
    }

    public enum MonoOperatorModes {
        square, squareRoot, oneDevidedBy, cos, sin, tan ,log , rate, abs
    }

    private Double num1, num2;
    private BiOperatorModes mode = BiOperatorModes.normal;

    private Double calculateBiImpl() {
        if (mode == BiOperatorModes.normal) {
            return num2;
        }
        if (mode == BiOperatorModes.add) {
            return add(num1, num2);
        }
        if (mode == BiOperatorModes.minus) {
            return minus(num1, num2);
        }
        if (mode == BiOperatorModes.multiply) {
            return mutiple(num1, num2);
        }
        if (mode == BiOperatorModes.divide) {
            return divide(num1, num2);
        }
        if (mode == BiOperatorModes.xpowerofy) {
            return pow(num1,num2);
        }

        // never reach
        throw new Error();
    }

    public Double calculateBi(BiOperatorModes newMode, Double num) {
        if (mode == BiOperatorModes.normal) {
            num2 = 0.0;
            num1 = num;
            mode = newMode;
            return NaN;
        } else {
            num2 = num;
            num1 = calculateBiImpl();
            mode = newMode;
            return num1;
        }
    }

    public Double calculateEqual(Double num) {
        return calculateBi(BiOperatorModes.normal, num);
    }

    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        mode = BiOperatorModes.normal;

        return NaN;
    }

    public Double calculateMono(MonoOperatorModes newMode, Double num) {
        if (newMode == MonoOperatorModes.square) {
            return square(num);
        }
        if (newMode == MonoOperatorModes.squareRoot) {
            return squareroot(num);
        }
        if (newMode == MonoOperatorModes.oneDevidedBy) {
            return oneDevideBy(num);
        }
        if (newMode == MonoOperatorModes.cos) {
            return cos(num);
        }
        if (newMode == MonoOperatorModes.sin) {
            return sin(num);
        }
        if (newMode == MonoOperatorModes.tan) {
            return tan(num);
        }
        if (newMode == MonoOperatorModes.log) {
            return log(num);
        }
        if (newMode == MonoOperatorModes.rate) {
           return rate(num);
        }
        if (newMode == MonoOperatorModes.abs){
            return abs(num);
        }

        // never reach
        throw new Error();
    }


    //Operator

    public Double add(Double a, Double b) {
        return a+b;
    }

    public Double minus(Double a, Double b) {
        return a-b;
    }

    public Double mutiple(Double a, Double b) { return divide(a,oneDevideBy(b));}

    public Double divide(Double a, Double b) {return a/b;}

    public Double pow(Double a, Double b) { return  Math.pow(a,b); }

    public Double square(Double x){
        return x*x;
    }

    public Double squareroot(Double x) { return  Math.sqrt(x);}

    public Double oneDevideBy(Double x) { return 1/x;}

    public Double cos(Double x) { return Math.cos(x);}

    public Double sin(Double x) {return Math.sin(x);}

    public Double tan(Double x) {
        if (x == 0 || x % 180 == 0) {
            return 0.0;
        }
        if (x % 90 == 0 && x % 180 != 0) {
            return NaN;
        }

        return sin(x)/cos(x);
    }

    public Double log(Double x) { return Math.log10(x);}

    public Double rate(Double x) { return x/100;}

    public Double abs(Double x) { return squareroot(square(x));}
}
