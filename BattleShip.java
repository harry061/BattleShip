package com.harry.battleship.v2;

public class BattleShip implements Ship {

	private String type;
	private ShipDimensions shipdimensions;

	BattleShip(ShipDimensions sd) {
		this.shipdimensions = sd;
	}

	@Override
	public String getType() {

		return this.type;
	}

	@Override
	public int getShipStrength() {

		int strength = 0;
		int[][] ship = this.shipdimensions.getShipPos();
		for (int i = 0; i < ship.length; i++) {
			for (int j = 0; j < ship[0].length; j++) {
				strength += ship[i][j];
			}
		}
		return strength;
	}

	@Override
	public void printship() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hitShip(String hitpos) {
		int[] strikepos = shipStrikePosition(hitpos);
		int xpos = strikepos[1];
		int ypos = strikepos[0];
		if (this.shipdimensions.getShipPos()[ypos][xpos] > 0) {
			--this.shipdimensions.getShipPos()[ypos][xpos];
			return true;
		}
		return false;
	}

	static int[] shipStrikePosition(String shipPos) {
		int[] i = new int[2];
		char[] c = shipPos.toCharArray();
		i[0] = (Character.toUpperCase(c[0]) - 65);
		i[1] = Character.getNumericValue(c[1]) - 1;
		return i;
	}

}
