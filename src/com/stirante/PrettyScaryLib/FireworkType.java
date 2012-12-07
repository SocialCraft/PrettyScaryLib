package com.stirante.PrettyScaryLib;

public enum FireworkType {
	SMALL_BALL(0), LARGE_BALL(1), STAR(2), CREEPER(3), BURST(4);
	
	private byte	id;
	
	private FireworkType(int id) {
		this.id = (byte) id;
	}
	
	public byte getId() {
		return id;
	}
	
	public static FireworkType getById(byte byte1) {
		for (int i = 0; i < values().length; i++)
			if (values()[i].getId() == byte1) return values()[i];
		return null;
	}
}
