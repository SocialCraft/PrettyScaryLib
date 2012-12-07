package com.stirante.PrettyScaryLib;

/**
 * SkeletonType.
 */
public enum SkeletonType {
	
	/** The wither skeleton. */
	WITHER(1),
	
	/** The normal skeleton. */
	NORMAL(0);
	
	private int	i;
	
	private SkeletonType(int i) {
		this.i = i;
	}
	
	/**
	 * Gets the type.
	 * 
	 * @return type
	 */
	public int getType() {
		return i;
	}
	
	/**
	 * Gets the type by id.
	 * 
	 * @param skeletonType
	 *            skeleton type
	 * @return type
	 */
	public static SkeletonType getById(int skeletonType) {
		if (skeletonType == 1)
			return WITHER;
		else
			return NORMAL;
	}
}
