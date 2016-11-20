package fr.fixyneko.neuralIA;

import java.util.Random;

public class Neuron {

	private double[] ratio;
	private double trigger;

	public Neuron(int inputs) {

		this.ratio = new double[inputs];
		for (int i = 0; i < inputs; i++) {
			this.ratio[i] = new Random().nextDouble();
		}
		this.trigger = new Random().nextDouble();
	}

	public int compute(int[] inputs) {
		double sum = 0;
		for (int i = 0; i < inputs.length; i++) {
			sum = sum + (inputs[i] * this.ratio[i] - this.trigger);
		}
		if (sum >= 0)
			return 1;
		else
			return -1;

	}

}
