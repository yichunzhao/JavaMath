package com.ynz.data.matrix;

import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class FindInverseMatrix {

    public static void main(String[] args) {
        //create a matrix
        double[][] matrix = {
                {4, 7},
                {2, 6}
        };

        //using apache commons math library, to create a matrix
        var realMatrix = MatrixUtils.createRealMatrix(matrix);

        // calculate the determinant of the matrix
        double determinant = new LUDecomposition(realMatrix).getDeterminant();
        System.out.println("determinant: " + determinant);

        //find the inverse of the matrix
        if (determinant != 0) {
            RealMatrix inverseMatrix = new LUDecomposition(realMatrix).getSolver().getInverse();
            System.out.println("Inverse Matrix: ");
            System.out.println(inverseMatrix);
        } else {
            System.out.println("The matrix is singular, and its inverse does not exist.");
        }
    }
}
