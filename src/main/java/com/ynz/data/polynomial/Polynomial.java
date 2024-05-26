package com.ynz.data.polynomial;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;

/**
 * A polynomial function, represented by a list of coefficients.
 */
public class Polynomial {
    private final PolynomialFunction polynomialFunction;

    private Polynomial(double[] coefficients) {
        polynomialFunction = new PolynomialFunction(coefficients);
    }

    /**
     * Factory method to create a polynomial function.
     *
     * @param coefficients the coefficients of the polynomial function.
     * @return a polynomial function.
     */
    public static Polynomial of(double[] coefficients){
        return new Polynomial(coefficients);
    }

    /**
     * Evaluate the polynomial function at a given value.
     *
     * @param x the value at which to evaluate the polynomial function.
     * @return the value of the polynomial function at the given value.
     */
    public  double evaluate(double x) {
        return polynomialFunction.value(x);
    }
}
