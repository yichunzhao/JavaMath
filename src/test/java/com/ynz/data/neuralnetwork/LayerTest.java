package com.ynz.data.neuralnetwork;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LayerTest {

    @Test
    void whenCalculateOutputs_thenOutputsAreCorrect() {
        Neuron[] neurons = {
                Neuron.of(new double[]{0.5, 0.5}, -0.5),
                Neuron.of(new double[]{0.1, 0.1}, -0.5)
        };

        var layer = Layer.of(neurons);

        double[] inputs = {1, 1};
        double[] outputs = layer.calculateOutputs(inputs, Utils::sigmoid);

        assertTrue(outputs[0] > 0.5);
        assertTrue(outputs[1] < 0.5);
    }
}