package com.ynz.data.matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MatrixHelperTest {
    private MatrixHelper matrixHelper;

    @BeforeEach
    void setUp() {
        // Define a 2x2 matrix, Matrix A
        var matrix = new double[][]{
                {2, 1},
                {1, 2}
        };

        matrixHelper = MatrixHelper.of(matrix);
    }

    @Test
    void calculateEigenvalue() {
        var eigenvalues = matrixHelper.calculateEigenvalue();

        System.out.println("Eigenvalues: ");
        for (double eigenvalue : eigenvalues) {
            System.out.println(eigenvalue);
        }
    }

    @Test
    void calculateEigenVector() {
        var eigenVectors = matrixHelper.calculateEigenVector();

        System.out.println("Eigenvectors: ");
        for (var eigenVector : eigenVectors) {
            System.out.println(eigenVector);
        }
    }

    @Test
    void testFindDeterminantOfMatrix_WhichIsLinearDependent() {
        // Define a 2x2 matrix, Matrix A
        var m = new double[][]{
                {1, 2},
                {2, 4}
        };

        var determinant = MatrixHelper.of(m).getDeterminant();
        assertThat(determinant).isEqualTo(0);
    }

    @Test
    void testFindDeterminantOfMatrix_WhichIsLinearIndependent() {
        // Define a 2x2 matrix, Matrix A
        var m = new double[][]{
                {2, 0},
                {0, 2}
        };

        var determinant = MatrixHelper.of(m).getDeterminant();
        assertThat(determinant).isEqualTo(4);
    }
}