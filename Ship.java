package com.harry.battleship.v2;

public interface Ship {

	String getType();

	int getShipStrength();

	public void printship();

	boolean hitShip(String hitpos);
}
