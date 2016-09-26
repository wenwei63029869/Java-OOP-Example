package com.wei;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;

/**
 * Created by weiwen on 9/24/16.
 */
public class RoundNumberTest {
    @Test
    public void testRoundForZeroIncrement() {
        BigDecimal testingInput = new BigDecimal("0.15");
        BigDecimal roundedNumber = RoundNumber.round(testingInput, BigDecimal.ZERO, RoundingMode.UP);
        assertEquals(roundedNumber, testingInput);
    }

    @Test
    public void testRoundForIncrement() {
        BigDecimal testingInput = new BigDecimal("0.13");
        BigDecimal expectedOutput = new BigDecimal("0.15");
        BigDecimal testingIncrement = new BigDecimal("0.05");
        BigDecimal roundedNumber = RoundNumber.round(testingInput, testingIncrement, RoundingMode.UP);
        assertEquals(roundedNumber, expectedOutput);
    }
}