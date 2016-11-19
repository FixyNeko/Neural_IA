package fr.fixyneko.engine.core.NeuralIA;

public class Brain {

	Layer[] layers;

	public Brain(int inputs, int[] neurons) {
		layers = new Layer[neurons.length];
		layers[0] = new LayerInput(inputs);
		for (int i = 1; i < neurons.length; i++) {
			layers[i] = new LayerMiddle(neurons[i], layers[i - 1]);
		}
	}

	public Layer getLayer(int layer) {
		return layers[layer];
	}

	public int[] compute(int[] inputs) {
		int[] outputs = layers[0].compute(inputs);
		for (int i = 1; i < layers.length; i++) {
			outputs = layers[i].compute(outputs);
		}
		return outputs;
	}
}