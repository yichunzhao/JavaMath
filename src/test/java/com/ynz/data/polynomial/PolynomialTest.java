package com.ynz.data.polynomial;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    @Test
    void evaluate() {
        Polynomial polynomial = Polynomial.of(new double[]{1, 2, 3});

        assertEquals(6.0, polynomial.evaluate(1.0));
        assertEquals(17.0, polynomial.evaluate(2.0));
        assertEquals(34.0, polynomial.evaluate(3.0));
    }
}