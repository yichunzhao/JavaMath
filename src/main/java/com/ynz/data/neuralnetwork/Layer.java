package com.ynz.data.neuralnetwork;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * A layer of neurons in a neural network.
 */
public class Layer {
    private final Neuron[] neurons;

    /**
     * Create a layer of neurons.
     *
     * @param neurons The neurons in the layer.
     */
    Layer(Neuron[] neurons) {
        this.neurons = neurons;
    }

    /**
     * Create a layer of neurons.
     *
     * @param neurons The neurons in the layer.
     * @return The layer.
     */
    public static Layer of(Neuron[] neurons) {
        return new Layer(neurons);
    }

    /**
     * Calculate the output of each neuron in the layer.
     *
     * @param inputs The inputs to the layer.
     * @return The outputs of the neurons in the layer.
     */
    public double[] calculateOutputs(double[] inputs, Function<Double, Double> activationFunction) {

        return Stream.of(neurons)
                .mapToDouble(neuron -> neuron.calculateOutput(inputs, activationFunction))
                .toArray();
    }
}
