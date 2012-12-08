package com.stirante.PrettyScaryLib;

import java.util.ArrayList;

import net.minecraft.server.v1_4_5.NBTTagCompound;

public class FireworkExplosion {
	private boolean				trail;
	private FireworkType		type;
	private ArrayList<Integer>	colors;
	private boolean				flicker;
	private ArrayList<Integer>	fadeColors;
	
	public FireworkExplosion(boolean trail, FireworkType type,
			ArrayList<Integer> colors, boolean flicker,
			ArrayList<Integer> fadeColors) {
		setTrail(trail);
		setType(type);
		setColors(colors);
		setFadeColors(fadeColors);
		setFlicker(flicker);
	}
	
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
	
	public boolean isTrail() {
		return trail;
	}
	
	public void setTrail(boolean trail) {
		this.trail = trail;
	}
	
	public FireworkType getType() {
		return type;
	}
	
	public void setType(FireworkType type) {
		this.type = type;
	}
	
	public int[] getColors() {
		int[] array = new int[colors.size()];
		for (int i = 0; i < colors.size(); i++)
			array[i] = colors.get(i);
		return array;
	}
	
	public void setColors(ArrayList<Integer> colors) {
		this.colors = colors;
	}
	
	public void addColor(int color) {
		colors.add(color);
	}
	
	public boolean isFlicker() {
		return flicker;
	}
	
	public void setFlicker(boolean flicker) {
		this.flicker = flicker;
	}
	
	public int[] getFadeColors() {
		int[] array = new int[fadeColors.size()];
		for (int i = 0; i < fadeColors.size(); i++)
			array[i] = fadeColors.get(i);
		return array;
	}
	
	public void setFadeColors(ArrayList<Integer> fadeColors) {
		this.fadeColors = fadeColors;
	}
	
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
