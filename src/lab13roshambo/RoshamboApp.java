package lab13roshambo;

import java.util.ArrayList;
import java.util.Scanner;

public class RoshamboApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		String userName;
		int userOpp;
		int[] winLoss = new int[2];
		PlayerRock pRock = new PlayerRock();
		pRock.setName("Jason");
		PlayerRandom pRand = new PlayerRandom();
		pRand.setName("Patrick");
		PlayerUser pUser = new PlayerUser();
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(pRock);
		players.add(pRand);
		String cont;
		
		userName = Validator.getString(scan,"What is your name? ");
		pUser.setName(userName);
		System.out.println();
		
		
		printMenu(players);
		userOpp = Validator.getInt(scan, "Who would you like to play against? ", 1, 3);
		System.out.println();
		System.out.println(players.get(userOpp - 1).getName() + " is ready to play \"Rock, Paper, Scissors\".");
		
		do {
		System.out.println();
		System.out.println("Ready, set, go! ");
		System.out.println();
		System.out.println("1. Rock");
		System.out.println("2. Paper");
		System.out.println("3. Scissors");
		System.out.println();
		pUser.setR(pUser.generateRoshambo());
		System.out.println();
		
		if (userOpp == 1) {
			pRock.setR(pRock.generateRoshambo());
			//print userChoice vs pRock choice
			System.out.println(pUser.getR() + " v. " + pRock.getR());
			System.out.println();
			//call gameResult
			gameResult(pUser.getR().ordinal(), pRock.getR().ordinal(), pUser.getName(), pRock.getName(), winLoss);
		}else if (userOpp == 2) {
			pRand.setR(pRand.generateRoshambo());
			//print userChoice vs pRand choice
			System.out.println(pUser.getR() + " v. " + pRand.getR());
			System.out.println();
			//call gameResult
			gameResult(pUser.getR().ordinal(), pRand.getR().ordinal(), pUser.getName(), pRand.getName(), winLoss);
		}
		
		System.out.println("Play again? (y/n) ");
		cont = scan.nextLine();
		
		} while(cont.equalsIgnoreCase("y"));
		
		System.out.println();
		System.out.println("Your win-loss ratio was " + winLoss[0] + ":" + winLoss[1] + ". ");
		System.out.println();
		System.out.println("Thanks for playing! Goodbye " + pUser.getName() + ". ");
		scan.close();
	}
	
	public static void printMenu(ArrayList<Player> menu) {
		for (int i = 0; i < menu.size(); i++) {
			System.out.println((i + 1) + ". " + menu.get(i).getName());
		}
	}
	
	public static void gameResult(int p1, int p2, String player1, String player2, int[] winLoss ) {
		// all tie conditions----if user -rock rock; paper paper ; sc sc 
		if ((p1 == 0 && p2 == 0) || (p1 == 1 && p2 == 1) || (p1 == 2 && p2 == 2)) {
			System.out.println("It's a tie! ");
		}
		// all lose conditions----if user -rock paper ; paper sc ; sc rock
		else if ((p1 == 0 && p2 == 1) || (p1 == 1 && p2 == 2) || (p1 == 2 && p2 == 0)) {
			System.out.println(player2 + " won! Better luck next time " + player1 + ". ");
			winLoss[1]++;
		}
		// all win conditions----if user -rock scissors ; paper rock ; sc paper
		else if ((p1 == 0 && p2 == 2) || (p1 == 1 && p2 == 0) || (p1 == 2 && p2 == 1)) {
			System.out.println(player1 + " won! Better luck next time " + player2 + ". ");
			winLoss[0]++;
		}
		
	}
	

}
