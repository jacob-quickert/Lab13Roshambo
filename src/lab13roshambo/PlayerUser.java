package lab13roshambo;

import java.util.Scanner;

public class PlayerUser extends Player {



	@Override
	public Roshambo generateRoshambo() {
		Scanner scan = new Scanner(System.in);
		int userChoice = Validator.getInt(scan, "Which will you choose? (Enter a #) ", 1, 4);
		if (userChoice == 1) {
			return Roshambo.ROCK;
		}else if (userChoice == 2) {
			return Roshambo.PAPER;
		}else if (userChoice == 3) {
			return Roshambo.SCISSORS;
		}
		return null;
	}

}
