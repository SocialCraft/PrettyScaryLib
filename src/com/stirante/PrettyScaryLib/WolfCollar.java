package com.stirante.PrettyScaryLib;

import java.awt.Color;

import net.minecraft.server.EntityWolf;

import org.bukkit.DyeColor;
import org.bukkit.craftbukkit.entity.CraftLivingEntity;
import org.bukkit.entity.Wolf;

/**
 * Class, that allows setting and getting color of wolf's collar.
 */
public class WolfCollar {
	
	/**
	 * Sets color.
	 *
	 * @param wolf wolf
	 * @param color color
	 * @return wolf
	 */
	public static Wolf setColor(Wolf wolf, int color){
		EntityWolf ent = (EntityWolf) ((CraftLivingEntity)wolf).getHandle();
		ent.setCollarColor(color);
		return wolf;
	}
	
	/**
	 * Sets color.
	 *
	 * @param wolf wolf
	 * @param color color
	 * @return wolf
	 */
	public static Wolf setColor(Wolf wolf, Color color){
		EntityWolf ent = (EntityWolf) ((CraftLivingEntity)wolf).getHandle();
		ent.setCollarColor(color.getRGB());
		return wolf;
	}
	
	/**
	 * Sets color.
	 *
	 * @param wolf wolf
	 * @param color color
	 * @return wolf
	 */
	public static Wolf setColor(Wolf wolf, DyeColor color){
		EntityWolf ent = (EntityWolf) ((CraftLivingEntity)wolf).getHandle();
		ent.setCollarColor(color.getData());
		return wolf;
	}
	
	/**
	 * Sets color.
	 *
	 * @param wolf wolf
	 * @param colorStr color str
	 * @return wolf
	 */
	public static Wolf setColor(Wolf wolf, String colorStr){
		int color = Integer.decode(colorStr);
		EntityWolf ent = (EntityWolf) ((CraftLivingEntity)wolf).getHandle();
		ent.setCollarColor(color);
		return wolf;
	}
	
	/**
	 * Sets color.
	 *
	 * @param wolf wolf
	 * @param colorR amount of red
	 * @param colorG amount of green
	 * @param colorB amount of blue
	 * @return wolf
	 */
	public static Wolf setColor(Wolf wolf, int colorR, int colorG, int colorB){
		int color = Integer.decode(ColorConverter.toHex(colorR, colorG, colorB));
		EntityWolf ent = (EntityWolf) ((CraftLivingEntity)wolf).getHandle();
		ent.setCollarColor(color);
		return wolf;
	}
	
	/**
	 * Gets color.
	 *
	 * @param wolf wolf
	 * @return color
	 */
	public static int getColor(Wolf wolf){
		EntityWolf ent = (EntityWolf) ((CraftLivingEntity)wolf).getHandle();
		return ent.getCollarColor();
	}
	
	/**
	 * Gets dye color.
	 *
	 * @param wolf wolf
	 * @return dye color
	 */
	public static DyeColor getDyeColor(Wolf wolf){
		EntityWolf ent = (EntityWolf) ((CraftLivingEntity)wolf).getHandle();
		return DyeColor.getByData((byte) ent.getCollarColor());
	}
}
