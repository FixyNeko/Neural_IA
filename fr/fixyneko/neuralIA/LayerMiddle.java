package fr.fixyneko.neuralIA;

public class LayerMiddle implements Layer {

	private Neuron[] neurons;

	public LayerMiddle(int neuronsNum, Layer parent) {
		this.neurons = new Neuron[neuronsNum];
		for (int i = 0; i < this.neurons.length; i++) {
			this.neurons[i] = new Neuron(parent.getOutNum());
		}
	}

	public int getOutNum() {
		return this.neurons.length;
	}

	public int[] compute(int[] parentOut) {
		int[] output = new int[this.neurons.length];
		for (int i = 0; i < this.neurons.length; i++) {
			output[i] = this.neurons[i].compute(parentOut);
		}
		return output;
	}

	public Neuron getNeuron(int neuron) {
		return this.neurons[neuron];
	}
}
