package com.ynz.data.matrix;

import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealVector;

/**
 * Calculate the eigenvalue of a matrix.
 * <p>
 * what is an eigenvalue?
 * <p>
 * An eigenvalue of a matrix is a scalar that, when multiplied by the corresponding eigenvector, gives the same result as
 * multiplying the eigenvector by the matrix(A).
 * <p>
 * A*v = λ*v
 * <p>
 * in a two dimension matrix, the eigenvalue is the solution of the following equation:
 * <p>
 * |a - λ, b|
 * |c, d - λ| = 0
 */
public class EigenHelper {
    private final EigenDecomposition eigenDecomposition;

    private EigenHelper(double[][] matrix) {
        // using apache commons math library, to create a matrix.
        var realMatrix = MatrixUtils.createRealMatrix(matrix);

        // create an EigenDecomposition object
        eigenDecomposition = new EigenDecomposition(realMatrix);
    }

    /**
     * Create an instance of CalculateEigenvalue
     *
     * @param matrix a 2D array of double
     * @return an instance of CalculateEigenvalue
     */
    public static EigenHelper of(double[][] matrix) {
        return new EigenHelper(matrix);
    }

    /**
     * Calculate the eigenvalues of the matrix
     *
     * @return an array of double
     */
    public double[] calculateEigenvalue() {
        // calculate the eigenvalues of the matrix
        return eigenDecomposition.getRealEigenvalues();
    }

    /**
     * Calculate the eigenvectors of the matrix
     *
     * @return an array of RealVector
     */
    public RealVector[] calculateEigenVector() {
        double[] eigenvalues = this.calculateEigenvalue();

        var realVectors = new RealVector[eigenvalues.length];

        for (int i = 0; i < eigenvalues.length; i++) {
            realVectors[i] = eigenDecomposition.getEigenvector(i);
        }

        return realVectors;
    }
}
