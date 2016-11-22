package fr.fixyneko.neuralIA;

import java.util.Arrays;
import java.util.Random;
import fr.gagoi.pwal.app.AppElement;

public class Generation implements AppElement {

	private Brain[] brains;
	private boolean isRunning = true;

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

	public int[][] testAll(int[][] inputs) {
		int[][] outs = new int[brains.length][brains[0].outputNum()];
		for (int i = 0; i < brains.length; i++) {
			outs[i] = brains[i].compute(inputs[i]);
		}
		return outs;
	}

	public void evolve(double mutation) {
		Arrays.sort(brains);
		Brain best1 = brains[0], best2 = brains[1];
		for (int i = 2; i < brains.length/2; i++) {
			brains[i] = mix(best1, best2, mutation);
		}
	}
	
	private Brain mix(Brain brain1, Brain brain2, double mutation){
		Brain brain = brain1;
		for(int j=0;j<brain1.getLayer(0).getNeuronNum();j++){
			double rand = new Random().nextDouble();
			if(rand > 1-mutation)
				brain.getLayer(0).setNeuron(j, new Neuron(1));
			else if(rand > (1-mutation)/2)
				brain.getLayer(0).setNeuron(j, brain2.getLayer(0).getNeuron(j));
		}
		for(int i=1;i<brain1.getLayersNum();i++){
			for(int j=0;j<brain1.getLayer(i).getNeuronNum();j++){
				double rand = new Random().nextDouble();
				if(rand > 1-mutation)
					brain.getLayer(i).setNeuron(j, new Neuron(brain1.getLayer(i-1).getNeuronNum()));
				else if(rand > (1-mutation)/2)
					brain.getLayer(i).setNeuron(j, brain2.getLayer(0).getNeuron(j));
			}
		}
		return brain;
	}

	@Override
	public void update() {
	}

	@Override
	public boolean isRunning() {
		return isRunning;
	}
}
