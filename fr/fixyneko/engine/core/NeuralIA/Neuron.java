package fr.fixyneko.engine.core.NeuralIA;

import java.util.Random;

public class Neuron {

	private double[] ratio;
	private double trigger;

	public Neuron(int inputs) {

		ratio = new double[inputs];
		for (int i = 0; i < inputs; i++) {
			ratio[i] = new Random().nextDouble();
		}
		trigger = new Random().nextDouble();
	}

	public int compute(int[] inputs) {
		double sum = 0;
		for (int i = 0; i < inputs.length; i++) {
			sum = sum + inputs[i] * ratio[i];
		}
		if (sum >= trigger)
			return 1;
		else
			return 0;

	}

}
