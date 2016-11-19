package fr.fixyneko.engine.core.neuralIA;

public class LayerMiddle implements Layer {

	private Neuron[] neurons;

	public LayerMiddle(int neuronsNum, Layer parent) {
		neurons = new Neuron[neuronsNum];
		for (int i = 0; i < neurons.length; i++) {
			neurons[i] = new Neuron(parent.getOutNum());
		}
	}

	public int getOutNum() {
		return neurons.length;
	}

	public int[] compute(int[] parentOut) {
		int[] output = new int[neurons.length];
		for (int i = 0; i < neurons.length; i++) {
			output[i] = neurons[i].compute(parentOut);
		}
		return output;
	}

	public Neuron getNeuron(int neuron) {
		return neurons[neuron];
	}
}
