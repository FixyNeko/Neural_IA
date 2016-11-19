package fr.fixyneko.engine.core.NeuralIA;

public class Generation {

	private int score;
	private Brain[] brains;

	public Generation(int[] brains, int inputs, int[] neurons) {

		for (int i = 0; i < brains.length; i++) {
			this.brains[i] = new Brain(inputs, neurons);
		}
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return (this.score);
	}
}
