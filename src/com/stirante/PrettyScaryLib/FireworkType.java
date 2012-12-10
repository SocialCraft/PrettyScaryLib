package com.stirante.PrettyScaryLib;

/**
 * The Enum FireworkType.
 */
public enum FireworkType {
	
	/** The small ball. */
	SMALL_BALL(0),
	/** The large ball. */
	LARGE_BALL(1),
	/** The star. */
	STAR(2),
	/** The creeper. */
	CREEPER(3),
	/** The burst. */
	BURST(4);
	
	private byte	id;
	
	private FireworkType(int id) {
		this.id = (byte) id;
	}
	
	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public byte getId() {
		return id;
	}
	
	/**
	 * Gets the type by id.
	 * 
	 * @param byte1
	 *            the byte1
	 * @return the by id
	 */
	public static FireworkType getById(byte byte1) {
		for (int i = 0; i < values().length; i++)
			if (values()[i].getId() == byte1) return values()[i];
		return null;
	}
}
