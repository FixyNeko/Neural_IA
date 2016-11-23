package fr.fixyneko.neuralIA;

import java.util.Random;

public class Neuron {

	private double[] ratio;
	private double totalRatio = 0;
	private double trigger;

	public Neuron(int inputs) {

		this.ratio = new double[inputs];
		for (int i = 0; i < inputs; i++) {
			this.ratio[i] = new Random().nextDouble();
		}
		for (double val : ratio)
			this.totalRatio = this.totalRatio + val;
		this.trigger = new Random().nextDouble();
	}

	public double compute(double[] inputs) {
		double sum = 0;
		for (int i = 0; i < inputs.length; i++) {
			sum = sum + inputs[i] * this.ratio[i];
		}
		// System.out.println("Neural sum: " + sum);
		if (sum < 0)
			sum = 0;
		// System.out.println("totalRatio: " + totalRatio);
		return (sum / this.totalRatio);

	}

}
