package fr.fixyneko.engine.core.neuralIA;

public class Generations {

	private Generation generation;

	public Generations(int[] neurons) {
		this.generation = new Generation(neurons);
		for (int i = 0; i < neurons; i++) {
			generations[i] = new Generation();
		}
	}
}
