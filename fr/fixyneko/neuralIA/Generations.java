package fr.fixyneko.neuralIA;

public class Generations {

	private Generation generation;

	public Generations(int brains, int inputs, int[] neurons) {
		this.generation = new Generation(brains, inputs, neurons);
	}
}