package fr.fixyneko.neuralIA;

import java.util.Arrays;
import java.util.Random;

public class Generation {

	private Brain[] brains;

	public Generation(int brains, int inputs, int[] neurons) {

		this.brains = new Brain[brains];
		for (int i = 0; i < brains; i++) {
			this.brains[i] = new Brain(inputs, neurons);
		}
	}

	public Brain getBrain(int i) {
		return brains[i];
	}

	public double[][] compute(double[][] inputs) {
		double[][] outputs = new double[this.brains.length][this.brains[0].outputNum()];
		for (int i = 0; i < inputs.length; i++) {
			outputs[i] = brains[i].compute(inputs[i]);
			System.out.print("Brain number "+i+": inputs: ");
			for( double val:inputs[i])
				System.out.print(val + " ");
			System.out.println();
		}
		return outputs;
	}

	public void evolve(double mutation) {

		Arrays.sort(brains);

		Brain best1 = brains[0], best2 = brains[1];
		for (int i = 2; i < brains.length / 2; i++) {
			brains[i] = mix(best1, best2, mutation);
		}
	}

	private Brain mix(Brain brain1, Brain brain2, double mutation) {
		Brain brain = brain1;
		for (int j = 0; j < brain1.getLayer(0).getNeuronNum(); j++) {
			double rand = new Random().nextDouble();
			if (rand > 1 - mutation)
				brain.getLayer(0).setNeuron(j, new Neuron(1));
			else if (rand > (1 - mutation) / 2)
				brain.getLayer(0).setNeuron(j, brain2.getLayer(0).getNeuron(j));
		}
		for (int i = 1; i < brain1.getLayersNum(); i++) {
			for (int j = 0; j < brain1.getLayer(i).getNeuronNum(); j++) {
				double rand = new Random().nextDouble();
				if (rand > 1 - mutation)
					brain.getLayer(i).setNeuron(j, new Neuron(brain1.getLayer(i - 1).getNeuronNum()));
				else if (rand > (1 - mutation) / 2)
					brain.getLayer(i).setNeuron(j, brain2.getLayer(0).getNeuron(j));
			}
		}
		return brain;
	}
}
