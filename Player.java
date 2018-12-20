package com.harry.battleship.v2;

import java.util.ArrayList;
import java.util.List;

public interface Player {

	Ship[] getBattleShips();

	void setBattleShips(Ship[] ships);

	boolean strikeShip(String stikePos);

	int getPlayerStrength();
}
