package test;

import static org.junit.Assert.assertEquals;
import main.Operation;
import org.junit.Test;

/**
 *  Areeba Waheed
 *  SEP 17, 2018
 *  Comp 585: GUI
 *  Project 1: Calculator
 *
 **/

public class CalculatorTest {

    @Test
    public void testCalculator() {
        Operation b = new Operation();
        b.operate("22");
        b.operate("+");
        b.operate("2");
        b.operate("=");
        assertEquals("24.0", b.getOperand1() );
    }


}

