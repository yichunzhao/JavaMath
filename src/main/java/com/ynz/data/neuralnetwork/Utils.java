package com.ynz.data.neuralnetwork;

public class Utils {
    public static double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }
}
