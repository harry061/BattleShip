package com.harry.battleship.v2;

public class BattlePlayer implements Player {

	private Ship[] playerShips;

	@Override
	public Ship[] getBattleShips() {

		return playerShips;
	}

	@Override
	public void setBattleShips(Ship[] ships) {
		this.playerShips = ships;

	}

	@Override
	public boolean strikeShip(String stikePos) {
		boolean hit = false;
		for (Ship ship : playerShips) {
			if (ship.hitShip(stikePos)) {
				hit = true;
				break;
			}
		}
		return hit;
	}

	@Override
	public int getPlayerStrength() {
		int playerStrength = 0;
		for (Ship ship : playerShips) {
			playerStrength += ship.getShipStrength();
		}
		return playerStrength;
	}

}
