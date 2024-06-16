package com.ynz.data.neuralnetwork;

import org.apache.commons.math3.linear.ArrayRealVector;

public class Neuron {

    private double[] weights;

    private double bias;

    private Neuron(double[] weights, double bias) {
        this.weights = weights;
        this.bias = bias;
    }

    public static Neuron of(double[] weights, double bias) {
        return new Neuron(weights, bias);
    }

    public double calculateOutput(double[] inputs) {
        if (inputs.length != weights.length) {
            throw new IllegalArgumentException("Number of inputs must match number of weights");
        }

        var vectorWeight = new ArrayRealVector(weights);
        var vectorInput = new ArrayRealVector(inputs);

        return vectorWeight.dotProduct(vectorInput) + bias;
    }

    public double activationFunction(double[] inputs) {
        var x = calculateOutput(inputs);
        return Utils.sigmoid(x);
    }
}
