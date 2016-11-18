package engine.core.NeuralIA;

import engine.core.entities.Bomb;
import engine.core.entities.Bullet;
import engine.core.entities.Healer;
import engine.core.entities.Player;

public class IA {

	
	public Generations selection(){
		return new Generations(5, 10);
	}
	
}
