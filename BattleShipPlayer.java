package com.harry.battleship;

import java.util.ArrayList;
import java.util.List;

public class BattleShipPlayer {

	BattleArea ba;
	List<BattleShip> battleships;

	BattleShipPlayer(BattleArea playerBattleArea) {
		this.ba = playerBattleArea;
	}

	void prepareBattleShips() {
		for (BattleShip bs : battleships) {
			int[] idimensions = getShipDimensions(bs.getBattleShipDimensions());
			int[] pos = getShipLocation(bs.getBattleShipLocation());
			ba.prepareBattleShip(idimensions[0], idimensions[1], pos[0], pos[1], bs.getBattleShipType());
		}

	}

	public boolean hitBattleShip(String coord) {
		int[] icoord = getHitLocation(coord);
		return ba.hitBattleShip(icoord[1], icoord[0]);

	}

	private int[] getShipDimensions(String dimensions) {
		String[] str = dimensions.split(" ");
		int[] i = new int[2];
		i[0] = Integer.parseInt(str[0]);
		i[1] = Integer.parseInt(str[1]);
		return i;
	}

	private int[] getShipLocation(String battleShipLocation) {
		char[] c1 = battleShipLocation.toCharArray();
		int height1 = Character.toUpperCase(c1[1]);
		int[] i = new int[2];
		i[0] = height1;
		i[1] = Character.getNumericValue(c1[0]);
		return i;
	}

	private int[] getHitLocation(String coord) {
		char[] c1 = coord.toCharArray();
		int height1 = Character.toUpperCase(c1[0]);
		int[] i = new int[2];
		i[0] = height1;
		i[1] = Character.getNumericValue(c1[1]);
		return i;
	}

	public List<BattleShip> getBattleShips() {
		if (null != battleships && !battleships.isEmpty()) {
			return battleships;
		}

		return battleships = new ArrayList<BattleShip>();

	}

}
