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

	public double[] compute(double[] input) {
		double[] output = new double[this.neurons.length];
		for (int i = 0; i < input.length; i++) {
			output[i] = this.neurons[i].compute(new double[] { input[i] });
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
