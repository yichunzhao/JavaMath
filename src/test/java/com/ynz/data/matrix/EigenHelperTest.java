package com.ynz.data.matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EigenHelperTest {
    private EigenHelper eigenHelper;

    @BeforeEach
    void setUp() {
        // Define a 2x2 matrix, Matrix A
        var matrix = new double[][]{
                {2, 1},
                {1, 2}
        };

        eigenHelper = EigenHelper.of(matrix);
    }

    @Test
    void calculateEigenvalue() {
        var eigenvalues = eigenHelper.calculateEigenvalue();

        System.out.println("Eigenvalues: ");
        for (double eigenvalue : eigenvalues) {
            System.out.println(eigenvalue);
        }
    }

    @Test
    void calculateEigenVector() {
        var eigenVectors = eigenHelper.calculateEigenVector();

        System.out.println("Eigenvectors: ");
        for (var eigenVector : eigenVectors) {
            System.out.println(eigenVector);
        }
    }
}