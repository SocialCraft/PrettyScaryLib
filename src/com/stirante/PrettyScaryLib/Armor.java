package com.stirante.PrettyScaryLib;

import net.minecraft.server.NBTTagCompound;
import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import java.awt.*;

/**
 * Class, that allows setting and getting color of the leather armor.
 */
public class Armor {

	/**
	 * Sets the color.
	 * If item is not colorable it will return an unchanged object of that item.
	 *
	 * @param item  item to color
	 * @param color color
	 * @return colored item
	 */
	public static ItemStack setColor(ItemStack item, int color) {

		if (!isApplicable(item))
			return item;

		CraftItemStack craftStack = null;
		net.minecraft.server.ItemStack itemStack = null;

		if (item instanceof CraftItemStack) {
			craftStack = (CraftItemStack) item;
			itemStack = craftStack.getHandle();
		} else {
			craftStack = new CraftItemStack(item);
			itemStack = craftStack.getHandle();
		}

		NBTTagCompound tag = itemStack.tag;
		if (tag == null) {
			tag = new NBTTagCompound();
			tag.setCompound("display", new NBTTagCompound());
			itemStack.tag = tag;
		}

		tag = itemStack.tag.getCompound("display");
		tag.setInt("color", color);
		itemStack.tag.setCompound("display", tag);
		return craftStack;
	}

	/**
	 * Check if item is applicable (colorable).
	 *
	 * @param item
	 * @return boolean
	 */
	public static boolean isApplicable(ItemStack item) {
		switch (item.getType()) {
			case LEATHER_BOOTS:
			case LEATHER_CHESTPLATE:
			case LEATHER_HELMET:
			case LEATHER_LEGGINGS:
				return true;
		}
		return false;
	}

	/**
	 * Sets the color.
	 * If item is not colorable it will return an unchanged object of that item.
	 *
	 * @param item  item to color
	 * @param color color
	 * @return colored item
	 */
	public static ItemStack setColor(ItemStack item, Color color) {
		return setColor(item, color.getRGB());
	}

	/**
	 * Sets the color.
	 * If item is not colorable it will return an unchanged object of that item.
	 *
	 * @param item  item to color
	 * @param color color
	 * @return colored item
	 */
	public static ItemStack setColor(ItemStack item, ArmorColor color) {
		return setColor(item, color.getColor());
	}

	/**
	 * Sets the color.
	 * If item is not colorable it will return an unchanged object of that item.
	 *
	 * @param item     item to color
	 * @param colorStr color
	 * @return colored item
	 */
	public static ItemStack setColor(ItemStack item, String colorStr) {
		return setColor(item, Integer.decode(colorStr));
	}

	/**
	 * Sets the color.
	 * If item is not colorable it will return an unchanged object of that item.
	 *
	 * @param item   item to color
	 * @param colorR amount of red
	 * @param colorG amount of green
	 * @param colorB amount of blue
	 * @return colored item
	 */
	public static ItemStack setColor(ItemStack item, int colorR, int colorG, int colorB) {
		return setColor(item, Integer.decode(ColorConverter.toHex(colorR, colorG, colorB)));
	}

	/**
	 * Gets the color.
	 *
	 * @param item colored item
	 * @return color or NULL if no color was found for given item
	 */
	public static Integer getColor(ItemStack item) {

		if (!isApplicable(item))
			return null;

		CraftItemStack craftStack;

		if (item instanceof CraftItemStack){
			craftStack = (CraftItemStack) item;
		}else{
			craftStack = new CraftItemStack(item);
		}

		net.minecraft.server.ItemStack itemStack = craftStack.getHandle();
		NBTTagCompound tag = itemStack.tag;
		if (tag == null) return null; // has no color

		tag = itemStack.tag.getCompound("display");
		return tag.getInt("color");
	}
}
