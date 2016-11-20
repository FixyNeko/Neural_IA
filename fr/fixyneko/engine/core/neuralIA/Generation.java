package fr.fixyneko.engine.core.neuralIA;

public class Generation {

	private Brain[] brains;

	public Generation(int brains, int inputs, int[] neurons) {

		for (int i = 0; i < brains; i++) {
			this.brains[i] = new Brain(inputs, neurons);
		}
	}

	public Brain getBrain(int i) {
		return brains[i];
	}

	public int[][] compute(int[] inputs) {
		int[][] outputs = new int[brains.length][brains[0].outputNum()];
		for (int i = 0; i < brains.length; i++) {
			outputs[i] = brains[i].compute(inputs);
		}
		return outputs;
	}
}
