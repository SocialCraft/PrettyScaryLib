package com.stirante.PrettyScaryLib;

import java.util.ArrayList;

import net.minecraft.server.v1_4_5.NBTTagCompound;

/**
 * Class, that stores informations about firework's and firework's star
 * explosions.
 */
public class FireworkExplosion {
	private boolean				trail;
	private FireworkType		type;
	private ArrayList<Integer>	colors;
	private boolean				flicker;
	private ArrayList<Integer>	fadeColors;
	
	/**
	 * Instantiates a new firework explosion.
	 * 
	 * @param trail
	 *            trail
	 * @param type
	 *            type
	 * @param colors
	 *            colors
	 * @param flicker
	 *            flicker
	 * @param fadeColors
	 *            fade colors
	 */
	public FireworkExplosion(boolean trail, FireworkType type,
			ArrayList<Integer> colors, boolean flicker,
			ArrayList<Integer> fadeColors) {
		setTrail(trail);
		setType(type);
		setColors(colors);
		setFadeColors(fadeColors);
		setFlicker(flicker);
	}
	
	/**
	 * Instantiates a new firework explosion.
	 * 
	 * @param tag
	 *            Compound
	 */
	public FireworkExplosion(NBTTagCompound tag) {
		if (tag.getByte("Trail") == 1)
			setTrail(true);
		else
			setTrail(false);
		if (tag.getByte("Flicker") == 1)
			setFlicker(true);
		else
			setFlicker(false);
		setType(FireworkType.getById(tag.getByte("Type")));
		setColors(tag.getIntArray("Colors"));
		setFadeColors(tag.getIntArray("FadeColors"));
	}
	
	private void setFadeColors(int[] intArray) {
		fadeColors = new ArrayList<Integer>();
		for (int element : intArray)
			fadeColors.add(element);
	}
	
	private void setColors(int[] intArray) {
		colors = new ArrayList<Integer>();
		for (int element : intArray)
			colors.add(element);
	}
	
	/**
	 * Gets trail.
	 * 
	 * @return trail
	 */
	public boolean isTrail() {
		return trail;
	}
	
	/**
	 * Sets the trail.
	 * 
	 * @param trail
	 *            trail
	 */
	public void setTrail(boolean trail) {
		this.trail = trail;
	}
	
	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public FireworkType getType() {
		return type;
	}
	
	/**
	 * Sets the type.
	 * 
	 * @param type
	 *            the new type
	 */
	public void setType(FireworkType type) {
		this.type = type;
	}
	
	/**
	 * Gets the colors.
	 * 
	 * @return the colors
	 */
	public int[] getColors() {
		int[] array = new int[colors.size()];
		for (int i = 0; i < colors.size(); i++)
			array[i] = colors.get(i);
		return array;
	}
	
	/**
	 * Sets the colors.
	 * 
	 * @param colors
	 *            the new colors
	 */
	public void setColors(ArrayList<Integer> colors) {
		this.colors = colors;
	}
	
	/**
	 * Adds the color.
	 * 
	 * @param color
	 *            the color
	 */
	public void addColor(int color) {
		colors.add(color);
	}
	
	/**
	 * Checks if is flickering.
	 * 
	 * @return true, if is flickering
	 */
	public boolean isFlicker() {
		return flicker;
	}
	
	/**
	 * Sets the flickering.
	 * 
	 * @param flicker
	 *            flickering
	 */
	public void setFlicker(boolean flicker) {
		this.flicker = flicker;
	}
	
	/**
	 * Gets the fade colors.
	 * 
	 * @return the fade colors
	 */
	public int[] getFadeColors() {
		int[] array = new int[fadeColors.size()];
		for (int i = 0; i < fadeColors.size(); i++)
			array[i] = fadeColors.get(i);
		return array;
	}
	
	/**
	 * Sets the fade colors.
	 * 
	 * @param fadeColors
	 *            the new fade colors
	 */
	public void setFadeColors(ArrayList<Integer> fadeColors) {
		this.fadeColors = fadeColors;
	}
	
	/**
	 * Gets the explosion tag.
	 * 
	 * @return the tag
	 */
	public NBTTagCompound getTag() {
		NBTTagCompound tag = new NBTTagCompound();
		tag.setByte("Trail", getTrail());
		tag.setByte("Type", getType().getId());
		tag.setIntArray("Colors", getColors());
		tag.setByte("Flicker", getFlicker());
		tag.setIntArray("FadeColors", getFadeColors());
		return tag;
	}
	
	private byte getFlicker() {
		if (isFlicker()) return 1;
		return 0;
	}
	
	private byte getTrail() {
		if (isTrail()) return 1;
		return 0;
	}
}
