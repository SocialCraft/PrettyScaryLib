package com.stirante.PrettyScaryLib;

import java.lang.reflect.Field;

import net.minecraft.server.v1_4_5.EntityCreeper;

import org.bukkit.craftbukkit.v1_4_5.entity.CraftCreeper;
import org.bukkit.entity.Creeper;

/**
 * Class, that allows setting and getting fuse and explosion radius of given
 * creeper.
 */
public class CustomCreeper {
	
	/**
	 * Sets the fuse.
	 * 
	 * @param creeper
	 *            creeper
	 * @param fuse
	 *            max fuse ticks
	 */
	public static void setFuse(Creeper creeper, int fuse) {
		EntityCreeper entCreeper = ((CraftCreeper) creeper).getHandle();
		Field fuseF = null;
		try {
			fuseF = EntityCreeper.class.getDeclaredField("maxFuseTicks");
		}
		catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		catch (SecurityException e) {
			e.printStackTrace();
		}
		fuseF.setAccessible(true);
		try {
			fuseF.setInt(entCreeper, fuse);
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the fuse.
	 * 
	 * @param creeper
	 *            creeper
	 * @return the max fuse ticks
	 */
	public static int getFuse(Creeper creeper) {
		EntityCreeper entCreeper = ((CraftCreeper) creeper).getHandle();
		Field fuseF = null;
		try {
			fuseF = EntityCreeper.class.getDeclaredField("maxFuseTicks");
		}
		catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		catch (SecurityException e) {
			e.printStackTrace();
		}
		fuseF.setAccessible(true);
		int fuse = 0;
		try {
			fuse = fuseF.getInt(entCreeper);
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return fuse;
	}
	
	/**
	 * Sets the explosion radius.
	 * 
	 * @param creeper
	 *            creeper
	 * @param radius
	 *            explosion radius
	 */
	public static void setRadius(Creeper creeper, int radius) {
		EntityCreeper entCreeper = ((CraftCreeper) creeper).getHandle();
		Field radiusF = null;
		try {
			radiusF = EntityCreeper.class.getDeclaredField("explosionRadius");
		}
		catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		catch (SecurityException e) {
			e.printStackTrace();
		}
		radiusF.setAccessible(true);
		try {
			radiusF.setInt(entCreeper, radius);
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the radius.
	 * 
	 * @param creeper
	 *            creeper
	 * @return explosion radius
	 */
	public static int getRadius(Creeper creeper) {
		EntityCreeper entCreeper = ((CraftCreeper) creeper).getHandle();
		Field radiusF = null;
		try {
			radiusF = EntityCreeper.class.getDeclaredField("explosionRadius");
		}
		catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		catch (SecurityException e) {
			e.printStackTrace();
		}
		radiusF.setAccessible(true);
		int radius = 0;
		try {
			radius = radiusF.getInt(entCreeper);
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return radius;
	}
}
