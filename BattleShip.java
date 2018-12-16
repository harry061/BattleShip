package com.harry.battleship;

public class BattleShip {
	
	String battleShipLocation;
	public String getBattleShipLocation() {
		return battleShipLocation;
	}
	public void setBattleShipLocation(String battleShipLocation) {
		this.battleShipLocation = battleShipLocation;
	}
	public int getBattleShipType() {
		return battleShipType;
	}
	public void setBattleShipType(int battleShipType) {
		this.battleShipType = battleShipType;
	}
	public String getBattleShipDimensions() {
		return battleShipDimensions;
	}
	public void setBattleShipDimensions(String battleShipDimensions) {
		this.battleShipDimensions = battleShipDimensions;
	}
	int battleShipType;
	String battleShipDimensions;


}
