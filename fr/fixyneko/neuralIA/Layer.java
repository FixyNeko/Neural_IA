package fr.fixyneko.neuralIA;

public interface Layer {
	public int getNeuronNum();

	public double[] compute(double[] parentOut);

	public Neuron getNeuron(int neuron);

	public void setNeuron(int num, Neuron neuron);
}
