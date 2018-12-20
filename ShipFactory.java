package com.harry.battleship.v2;

public class ShipFactory {

	public static Ship getShip(String oceanSize, String shipPos, String type, int shipwidth, int shipheight) {

		ShipDimensions sd = new ShipDimensions(oceanSize, shipPos, type, shipwidth, shipheight);
		BattleShip bs = new BattleShip(sd);
		return bs;
	}

}
