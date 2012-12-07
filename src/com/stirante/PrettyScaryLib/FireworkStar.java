package com.stirante.PrettyScaryLib;

import net.minecraft.server.NBTTagCompound;

import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class FireworkStar {

	/**
	 * Sets firework explosion.
	 *
	 * @param item item
	 * @param explosion explosion
	 * @return item
	 */
	public static ItemStack setExplosion(ItemStack item, FireworkExplosion explosion) {
		if (!isApplicable(item))
			return null;
		CraftItemStack craftStack = null;
		net.minecraft.server.ItemStack itemStack = null;
		if (item instanceof CraftItemStack) {
			craftStack = (CraftItemStack) item;
			itemStack = craftStack.getHandle();
		}
		else if (item instanceof ItemStack) {
			craftStack = new CraftItemStack(item);
			itemStack = craftStack.getHandle();
		}
		if (itemStack == null)
			return null;
		NBTTagCompound tag = itemStack.tag;
		if (tag == null) {
			tag = new NBTTagCompound();
			itemStack.tag = tag;
		}
		
		tag.setCompound("Explosion", explosion.getTag());
		return craftStack;
	}
	/**
	 * Gets firework explosion.
	 *
	 * @param item item
	 * @return firework explosion
	 */
	public static FireworkExplosion getExplosion(ItemStack item) {
		if (!isApplicable(item))
			return null;
		CraftItemStack craftStack = null;
		net.minecraft.server.ItemStack itemStack = null;
		if (item instanceof CraftItemStack) {
			craftStack = (CraftItemStack) item;
			itemStack = craftStack.getHandle();
		}
		else if (item instanceof ItemStack) {
			craftStack = new CraftItemStack(item);
			itemStack = craftStack.getHandle();
		}
		NBTTagCompound tag = itemStack.tag;
		if (tag == null) {
			tag = new NBTTagCompound();
			itemStack.tag = tag;
			return null;
		}
		
		return new FireworkExplosion(tag.getCompound("Explosion"));
	}
	
	/**
	 * Checks if item is applicable.
	 *
	 * @param item the item to check
	 * @return true, if is applicable
	 */
	public static boolean isApplicable(ItemStack item) {
		switch (item.getTypeId()) {
			case 402:
				return true;
			default:
				return false;
		}
	}
}
