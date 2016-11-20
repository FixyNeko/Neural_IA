package fr.fixyneko.neuralIA;

public interface Layer {
	public int getNeuronNum();

	public int[] compute(int[] parentOut);

	public Neuron getNeuron(int neuron);

	public void setNeuron(int num, Neuron neuron);
}
