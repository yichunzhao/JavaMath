package com.ynz.data.neuralnetwork;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NeuronTest {

    @Test
    void whenCalculateOutput_thenOutputIsCorrect() {
        double[] weights = {0.5, 0.5};
        double bias = -0.5;
        var neuron = Neuron.of(weights, bias);

        double[] inputs = {1, 1};
        double output = neuron.calculateOutput(inputs);

        assertEquals(0.5, output);
    }

    @Test
    void whenActivationFunction_thenOutputIsCorrect() {
        double[] weights = {0.6, 0.5};
        double bias = -0.5;
        var neuron = Neuron.of(weights, bias);

        double[] inputs = {1, 1};
        double output = neuron.activationFunction(inputs);

        assertTrue(output > 0.5);
    }
}