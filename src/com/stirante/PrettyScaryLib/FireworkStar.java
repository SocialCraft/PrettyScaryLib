package com.stirante.PrettyScaryLib;

import net.minecraft.server.v1_4_6.NBTTagCompound;

import org.bukkit.craftbukkit.v1_4_6.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

/**
 * Class, that allows changing explosion of firework star.
 */
public class FireworkStar {
	
	/**
	 * Sets firework explosion.
	 * 
	 * @param item
	 *            item
	 * @param explosion
	 *            explosion
	 * @return item
	 */
	public static ItemStack setExplosion(ItemStack item,
			FireworkExplosion explosion) {
		if (!isApplicable(item)) return null;
		net.minecraft.server.v1_4_6.ItemStack itemStack = CraftItemStack.asNMSCopy(item);
		if (itemStack == null) return null;
		NBTTagCompound tag = itemStack.tag;
		if (tag == null) {
			tag = new NBTTagCompound();
			itemStack.tag = tag;
		}
		
		tag.setCompound("Explosion", explosion.getTag());
		return CraftItemStack.asCraftMirror(itemStack);
	}
	
	/**
	 * Gets firework explosion.
	 * 
	 * @param item
	 *            item
	 * @return firework explosion
	 */
	public static FireworkExplosion getExplosion(ItemStack item) {
		if (!isApplicable(item)) return null;
		net.minecraft.server.v1_4_6.ItemStack itemStack = CraftItemStack.asNMSCopy(item);
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
	 * @param item
	 *            the item to check
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
