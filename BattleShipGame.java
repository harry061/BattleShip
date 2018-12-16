package com.harry.battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BattleShipGame {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter Area Boundaries (Width*Height) eg: 5 E");
		char[] c = in.nextLine().toCharArray();
		int height = Character.toUpperCase(c[1]);

		BattleArea bfA = new BattleArea(height, Character.getNumericValue(c[0]));
		BattleShipPlayer bsA = new BattleShipPlayer(bfA);
		BattleArea bfB = new BattleArea(height, Character.getNumericValue(c[0]));
		BattleShipPlayer bsB = new BattleShipPlayer(bfB);
		System.out.println("Enter Type of BattleShip One EG: P or Q");
		int battleshipOne = getBattleshipValue(in.nextLine());
		BattleShip battleshipOnePlayerA = new BattleShip();
		BattleShip battleshipOnePlayerB = new BattleShip();
		battleshipOnePlayerA.setBattleShipType(battleshipOne);
		battleshipOnePlayerB.setBattleShipType(battleshipOne);

		System.out.println("Dimensions of BattleShip One");
		String dimensionsBattleshipOne = in.nextLine();
		battleshipOnePlayerA.setBattleShipDimensions(dimensionsBattleshipOne);
		battleshipOnePlayerB.setBattleShipDimensions(dimensionsBattleshipOne);

		System.out.println("Location of BattleShip for Player A eg 4A");
		battleshipOnePlayerA.setBattleShipLocation(in.nextLine());
		System.out.println("Location of BattleShip for Player B eg 4A");
		battleshipOnePlayerB.setBattleShipLocation(in.nextLine());

		System.out.println("Enter Type of BattleShip Two EG: P or Q");
		int battleshipTwo = getBattleshipValue(in.nextLine());
		BattleShip battleshipTwoPlayerA = new BattleShip();
		BattleShip battleshipTwoPlayerB = new BattleShip();
		battleshipTwoPlayerA.setBattleShipType(battleshipTwo);
		battleshipTwoPlayerB.setBattleShipType(battleshipTwo);

		System.out.println("Dimensions of BattleShip Two");
		String dimensionsBattleshipTwo = in.nextLine();
		battleshipTwoPlayerA.setBattleShipDimensions(dimensionsBattleshipTwo);
		battleshipTwoPlayerB.setBattleShipDimensions(dimensionsBattleshipTwo);
		System.out.println("Location of BattleShip for Player A eg 4A");
		battleshipTwoPlayerA.setBattleShipLocation(in.nextLine());
		System.out.println("Location of BattleShip for Player B eg 4A");
		battleshipTwoPlayerB.setBattleShipLocation(in.nextLine());

		bsA.getBattleShips().add(battleshipOnePlayerA);
		bsA.getBattleShips().add(battleshipTwoPlayerA);
		bsB.getBattleShips().add(battleshipOnePlayerB);
		bsB.getBattleShips().add(battleshipTwoPlayerB);

		bsA.prepareBattleShips();
		bsB.prepareBattleShips();

		bsA.ba.printBattleField();
		bsB.ba.printBattleField();

		System.out.println("Enter Player A Missile Targets: eg A1");
		String targetsB = in.nextLine();
		System.out.println("Enter Player B Missile Targets: eg B2");
		String targetsA = in.nextLine();
		String[] AtargetsB = targetsB.split(" ");
		String[] BtargetsA = targetsA.split(" ");

		List<String> targetListA = new ArrayList<String>(Arrays.asList(AtargetsB));
		List<String> targetListB = new ArrayList<String>(Arrays.asList(BtargetsA));
		boolean playerATurn = true;
		boolean PlayerWon = false;
		while (!targetListA.isEmpty() || !targetListB.isEmpty()) {
			if (playerATurn && !targetListA.isEmpty()) {
				playerATurn = bsB.hitBattleShip(targetListA.get(0));
				System.out.println("Player A fires a missle @ "+targetListA.get(0)+" and its a "+(playerATurn?" Hit":" Miss"));
				targetListA.remove(0);
				if (bsB.ba.battleStrength < 1) {
					System.out.println("Player A wins ");
					PlayerWon = true;
					break;
				}

			} else if (!targetListB.isEmpty()) {
				playerATurn = bsA.hitBattleShip(targetListB.get(0));
				System.out.println("Player B fires a missle @ "+targetListB.get(0)+" and its a "+(playerATurn?" Hit":" Miss"));
				playerATurn = !playerATurn;
				targetListB.remove(0);
				if (bsA.ba.battleStrength < 1) {
					System.out.println("Player B wins ");
					PlayerWon = true;
					break;
				}

			}

		}

		if (!PlayerWon) {
			System.out.println("Peace bruh");
		}
	}

	static int getBattleshipValue(String ship) {
		switch (ship) {
		case "P":
		case "p":
			return 1;
		case "Q":
		case "q":
			return 2;

		}
		return 1;
	}

}
