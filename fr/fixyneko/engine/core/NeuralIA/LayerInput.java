package fr.fixyneko.engine.core.NeuralIA;

public class LayerInput implements Layer {

	private Neuron[] neurons;

	public LayerInput(int neuronsNum) {
		neurons = new Neuron[neuronsNum];
		for (int i = 0; i < neurons.length; i++) {
			neurons[i] = new Neuron(1);
		}
	}

	public int getOutNum() {
		return neurons.length;
	}

	public int[] compute(int[] input) {
		int[] output = new int[neurons.length];
		for (int i = 0; i < neurons.length; i++) {
			output[i] = neurons[i].compute(new int[] {input[i]});
		}
		return output;
	}
	
	public Neuron getNeuron(int neuron){
		return neurons[neuron];
	}
}
