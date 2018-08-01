package lab13roshambo;

import java.util.Random;

public class PlayerRandom extends Player {


	@Override
	public Roshambo generateRoshambo() {
		Random rand = new Random();
		int number = rand.nextInt(3);
		if(number == 0) {
			return Roshambo.ROCK;
		}else if (number == 1) {
			return Roshambo.PAPER;
		}else if (number == 2) {
			return Roshambo.SCISSORS;
		}
		return null;
	}
	

}
