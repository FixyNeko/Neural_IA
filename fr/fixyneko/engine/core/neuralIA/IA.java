package fr.fixyneko.engine.core.neuralIA;

import fr.fixyneko.engine.core.entities.Bomb;
import fr.fixyneko.engine.core.entities.Bullet;
import fr.fixyneko.engine.core.entities.Healer;
import fr.fixyneko.engine.core.entities.Player;

public class IA {

	
	public Generations selection(){
		return new Generations(5, 10);
	}
	
}
