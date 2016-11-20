package fr.fixyneko.engine.core.neuralIA;

public class Brain {

	private Layer[] layers;
	private int score;

	public Brain(int inputs, int[] neurons) {
		layers = new Layer[neurons.length];
		layers[0] = new LayerInput(inputs);
		for (int i = 1; i < neurons.length; i++) {
			layers[i] = new LayerMiddle(neurons[i], layers[i - 1]);
		}
	}

	public int[] compute(int[] inputs) {
		int[] outputs = layers[0].compute(inputs);
		for (int i = 1; i < layers.length; i++) {
			outputs = layers[i].compute(outputs);
		}
		return outputs;
	}

	public void setScore(Brain brain, int score) {
		this.score = score;
	}

	public int getScore(Brain brain) {
		return (this.score);
	}

	public Layer getLayer(int layer) {
		return layers[layer];
	}

	public int outputNum() {
		return layers[layers.length - 1].getOutNum();
	}
}