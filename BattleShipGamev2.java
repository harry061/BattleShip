package com.harry.battleship.v2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BattleShipGamev2 {

	public static void main(String[] args) throws IOException {

		List<String> input = Files.readAllLines(Paths.get("G:\\sampleinput.txt"), StandardCharsets.UTF_8);
		String oceanSize = input.get(0);

		String battleshipOne = input.get(1);
		String battleshiponeDimension = input.get(2);
		String PlayerAbattleshipLocationOne = input.get(3);
		String PlayerBbattleshipLocationOne = input.get(4);

		String battleshipTwo = input.get(5);
		String battleshipTwoDimension = input.get(6);
		String PlayerAbattleshipLocationTwo = input.get(7);
		String PlayerBbattleshipLocationTwo = input.get(8);

		String PlayerAMissiles = input.get(9);
		String PlayerBMissiles = input.get(10);
		int[] shipOneDim = getShipDimensions(battleshiponeDimension);
		int[] shiptwoDim = getShipDimensions(battleshipTwoDimension);

		// Player One
		Player p1 = new BattlePlayer();
		Ship[] p1Ships = new Ship[2];
		p1Ships[0] = ShipFactory.getShip(oceanSize, PlayerAbattleshipLocationOne, battleshipOne, shipOneDim[0],
				shipOneDim[1]);
		p1Ships[1] = ShipFactory.getShip(oceanSize, PlayerAbattleshipLocationTwo, battleshipTwo, shiptwoDim[0],
				shiptwoDim[1]);
		p1.setBattleShips(p1Ships);

		// Player two
		Player p2 = new BattlePlayer();
		Ship[] p2Ships = new Ship[2];
		p2Ships[0] = ShipFactory.getShip(oceanSize, PlayerBbattleshipLocationOne, battleshipOne, shipOneDim[0],
				shipOneDim[1]);
		p2Ships[1] = ShipFactory.getShip(oceanSize, PlayerBbattleshipLocationTwo, battleshipTwo, shiptwoDim[0],
				shiptwoDim[1]);
		p2.setBattleShips(p2Ships);

		String[] AtargetsB = PlayerAMissiles.split(" ");
		String[] BtargetsA = PlayerBMissiles.split(" ");

		List<String> targetListA = new ArrayList<String>(Arrays.asList(AtargetsB));
		List<String> targetListB = new ArrayList<String>(Arrays.asList(BtargetsA));
		boolean playerATurn = true;
		boolean PlayerWon = false;
		while (!targetListA.isEmpty() || !targetListB.isEmpty()) {
			if (playerATurn && !targetListA.isEmpty()) {
				playerATurn = p2.strikeShip(targetListA.get(0));
				System.out.println("Player A fires a missle @ " + targetListA.get(0) + " and its a "
						+ (playerATurn ? " Hit" : " Miss"));
				targetListA.remove(0);
				if (p2.getPlayerStrength() < 1) {
					System.out.println("Player A wins ");
					PlayerWon = true;
					break;
				}

			} else if (!targetListB.isEmpty()) {
				playerATurn = p1.strikeShip(targetListB.get(0));
				System.out.println("Player B fires a missle @ " + targetListB.get(0) + " and its a "
						+ (playerATurn ? " Hit" : " Miss"));
				playerATurn = !playerATurn;
				targetListB.remove(0);
				if (p1.getPlayerStrength() < 1) {
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

	static int[] getShipDimensions(String dimensions) {
		String[] str = dimensions.split(" ");
		int[] i = new int[2];
		i[0] = Integer.parseInt(str[0]);
		i[1] = Integer.parseInt(str[1]);
		return i;
	}

}
