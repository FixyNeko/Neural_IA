package fr.fixyneko.engine.core.neuralIA;

public interface Layer {
	public int getOutNum();
	public int[] compute(int[] parentOut);
	public Neuron getNeuron(int neuron);
}
