package fr.fixyneko.neuralIA;

public class Brain implements Comparable<Brain> {

	private Layer[] layers;
	private int score;

	public Brain(int inputs, int[] neurons) {
		layers = new Layer[neurons.length];
		layers[0] = new LayerInput(inputs);
		for (int i = 1; i < neurons.length; i++) {
			layers[i] = new LayerMiddle(neurons[i], layers[i - 1]);
		}
	}

	public double[] compute(double[] inputs) {
		double[] outputs = layers[0].compute(inputs);
		for (int i = 1; i < layers.length; i++) {
			outputs = layers[i].compute(outputs);
		}
		return outputs;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return (this.score);
	}

	public int getLayersNum() {
		return layers.length;
	}

	public Layer getLayer(int layer) {
		return layers[layer];
	}

	public int outputNum() {
		return layers[layers.length - 1].getNeuronNum();
	}

	@Override
	public int compareTo(Brain brain) {
		return brain.getScore() - this.score;
	}
}