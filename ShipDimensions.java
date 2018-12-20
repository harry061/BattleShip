package com.harry.battleship.v2;

public class ShipDimensions {

	private int[][] battleArea;
	private String type;

	public ShipDimensions(String oceanSize, String shipPos, String type, int shipwidth, int shipheight) {
		this.battleArea = this.createOcean(oceanSize);
		prepareBattlePositions(shipPos, type, shipwidth, shipheight);
		//printBattleShip();
	}

	public int[][] getShipPos() {
		return this.battleArea;
	}

	private void prepareBattlePositions(String shipPos, String type, int shipwidth, int shipheight) {

		int[] xypos = shipStartPosition(shipPos);
		int cellStrength = getBattleshipValue(type);
		shipheight += xypos[0];
		shipwidth += xypos[1];
		for (int i = xypos[0]; i < shipheight; i++) {
			for (int j = xypos[1]; j < shipwidth; j++) {

				battleArea[i][j] = cellStrength;
			}
		}
	}

	private int[][] createOcean(String oceanSize) {

		char[] c = oceanSize.toCharArray();
		int oceanwidth = Character.getNumericValue(c[0]);
		int oceanHeight = Character.toUpperCase(c[1]);
		return new int[(oceanHeight - 65) + 1][oceanwidth];
	}

	private int[] shipStartPosition(String shipPos) {
		int[] i = new int[2];
		char[] c = shipPos.toCharArray();
		i[0] = (Character.toUpperCase(c[0]) - 65);
		i[1] = Character.getNumericValue(c[1]) - 1;
		return i;
	}

	private int getBattleshipValue(String ship) {
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

	void printBattleShip() {
		for (int i = 0; i < battleArea.length; i++) {
			for (int j = 0; j < battleArea[0].length; j++) {
				System.out.print(battleArea[i][j] + " ");
			}
			System.out.println();
		}
	}
}
