package com.ynz.data.neuralnetwork;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UtilsTest {

    @Test
    void whenXIsGreaterThanZero_thenSigmoidIsGreaterThanHalf() {
        double x = 1.0;
        double result = Utils.sigmoid(x);
        assertTrue(result > 0.5);
    }

    @Test
    void whenXIsLessThanZero_thenSigmoidIsLessThanHalf() {
        double x = -1.0;
        double result = Utils.sigmoid(x);
        assertTrue(result < 0.5);
    }

    @Test
    void whenXIsZero_thenSigmoidIsHalf() {
        double x = 0.0;
        double result = Utils.sigmoid(x);
        assertEquals(0.5, result);
    }
}