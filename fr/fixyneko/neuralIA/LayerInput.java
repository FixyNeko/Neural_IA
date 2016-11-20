package fr.fixyneko.neuralIA;

public class LayerInput implements Layer {

	private Neuron[] neurons;

	public LayerInput(int neuronsNum) {
		this.neurons = new Neuron[neuronsNum];
		for (int i = 0; i < this.neurons.length; i++) {
			this.neurons[i] = new Neuron(1);
		}
	}

	public int getNeuronNum() {
		return this.neurons.length;
	}

	public int[] compute(int[] input) {
		int[] output = new int[this.neurons.length];
		for (int i = 0; i < this.neurons.length; i++) {
			output[i] = this.neurons[i].compute(new int[] { input[i] });
		}
		return output;
	}

	public Neuron getNeuron(int neuron) {
		return this.neurons[neuron];
	}

	@Override
	public void setNeuron(int num, Neuron neuron) {
		this.neurons[num] = neuron;
	}
}
