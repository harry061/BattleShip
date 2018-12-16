package com.harry.battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BattleArea {

	Map<Integer, List<Integer>> battleArea = new HashMap<Integer, List<Integer>>();

	int battleStrength;

	public BattleArea(int height, int width) {

		for (int i = 65; i <= height; i++) {
			battleArea.put(i, new ArrayList<Integer>(Arrays.asList(new Integer[width])));
		}
	}

	void prepareBattleShip(int width, int height, int posY, int posX, int ShipType) {

		this.battleStrength += (width * height * ShipType);

		for (int i = 0; i < height; i++) {
			List<Integer> l = battleArea.get(posY + i);
			for (int j = 0; j < width; j++) {
				l.set((posX + j) - 1, new Integer(ShipType));
			}
		}
	}

	boolean hitBattleShip(int attackX, int attackY) {
		List<Integer> attackList = this.battleArea.get(attackY);
		Integer strength = attackList.get(attackX - 1);
		if (null != strength && strength > 0) {
			attackList.set(attackX - 1, --strength);
			--battleStrength;
			return true;
		}
		return false;
	}

	void printBattleField() {
		Set<Integer> s = battleArea.keySet();
		Iterator<Integer> setiterator = s.iterator();
		while (setiterator.hasNext()) {
			int ch = setiterator.next();
			char ch1 = (char) ch;
			System.out.println(ch1);
			List<Integer> listss = battleArea.get(ch);
			for (Integer i : listss) {
				System.out.print(" " + i);
			}
			System.out.println();
		}
	}

}
