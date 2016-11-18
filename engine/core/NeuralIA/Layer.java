package engine.core.NeuralIA;

public interface Layer {
	public int getOutNum();
	public int[] compute(int[] parentOut);
	public Neuron getNeuron(int neuron);
}
