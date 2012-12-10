package com.stirante.PrettyScaryLib;

import net.minecraft.server.v1_4_5.NBTTagCompound;
import net.minecraft.server.v1_4_5.NBTTagList;

import org.bukkit.craftbukkit.v1_4_5.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

/**
 * Class, that allows setting data for Fireworks. Note that this class will work
 * in version 1.4.6 or newer.
 */
public class Firework {
	
	/**
	 * Checks if item is applicable.
	 * 
	 * @param item
	 *            the item to check
	 * @return true, if is applicable
	 */
	public static boolean isApplicable(ItemStack item) {
		switch (item.getTypeId()) {
			case 401:
				return true;
			default:
				return false;
		}
	}
	
	/**
	 * Sets explosion data.
	 * 
	 * @param item
	 *            item
	 * @param exps
	 *            explosions
	 * @return item stack
	 */
	public ItemStack setExplosions(ItemStack item, FireworkExplosion... exps) {
		if (!isApplicable(item)) return null;
		CraftItemStack craftStack = null;
		net.minecraft.server.v1_4_5.ItemStack itemStack = null;
		if (item instanceof CraftItemStack) {
			craftStack = (CraftItemStack) item;
			itemStack = craftStack.getHandle();
		}
		else if (item instanceof ItemStack) {
			craftStack = new CraftItemStack(item);
			itemStack = craftStack.getHandle();
		}
		if (itemStack == null) return null;
		NBTTagCompound tag = itemStack.tag;
		if (tag == null) {
			tag = new NBTTagCompound();
			tag.setCompound("Fireworks", new NBTTagCompound());
			itemStack.tag = tag;
		}
		tag = itemStack.tag.getCompound("Fireworks");
		NBTTagList list = new NBTTagList();
		for (FireworkExplosion l : exps)
			list.add(l.getTag());
		tag.set("Explosions", list);
		itemStack.tag.setCompound("Fireworks", tag);
		return craftStack;
	}
	
	/**
	 * Adds explosion data.
	 * 
	 * @param item
	 *            item
	 * @param explosion
	 *            explosion
	 * @return item stack
	 */
	public static ItemStack addExplosion(ItemStack item,
			FireworkExplosion explosion) {
		if (!isApplicable(item)) return null;
		CraftItemStack craftStack = null;
		net.minecraft.server.v1_4_5.ItemStack itemStack = null;
		if (item instanceof CraftItemStack) {
			craftStack = (CraftItemStack) item;
			itemStack = craftStack.getHandle();
		}
		else if (item instanceof ItemStack) {
			craftStack = new CraftItemStack(item);
			itemStack = craftStack.getHandle();
		}
		if (itemStack == null) return null;
		NBTTagCompound tag = itemStack.tag;
		if (tag == null) {
			tag = new NBTTagCompound();
			tag.setCompound("Fireworks", new NBTTagCompound());
			tag.getCompound("Fireworks").set("Explosions", new NBTTagList());
			itemStack.tag = tag;
		}
		
		tag = itemStack.tag.getCompound("Fireworks");
		NBTTagList list = tag.getList("Explosions");
		list.add(explosion.getTag());
		tag.set("Explosions", list);
		itemStack.tag.setCompound("Fireworks", tag);
		return craftStack;
	}
	
	/**
	 * Gets explosions data.
	 * 
	 * @param item
	 *            item
	 * @return explosions
	 */
	public static FireworkExplosion[] getExplosions(ItemStack item) {
		if (!isApplicable(item)) return null;
		CraftItemStack craftStack = null;
		net.minecraft.server.v1_4_5.ItemStack itemStack = null;
		if (item instanceof CraftItemStack) {
			craftStack = (CraftItemStack) item;
			itemStack = craftStack.getHandle();
		}
		else if (item instanceof ItemStack) {
			craftStack = new CraftItemStack(item);
			itemStack = craftStack.getHandle();
		}
		if (itemStack == null) return null;
		NBTTagCompound tag = itemStack.tag;
		if (tag == null) {
			tag = new NBTTagCompound();
			tag.setCompound("Fireworks", new NBTTagCompound());
			tag.getCompound("Fireworks").set("Explosions", new NBTTagList());
			itemStack.tag = tag;
		}
		tag = itemStack.tag;
		NBTTagList list = tag.getCompound("Fireworks").getList("Explosions");
		FireworkExplosion[] exps = new FireworkExplosion[list.size()];
		for (int i = 0; i < list.size(); i++)
			exps[i] = new FireworkExplosion((NBTTagCompound) list.get(i));
		return exps;
	}
	
	/**
	 * Sets height of flight.
	 * 
	 * @param item
	 *            item
	 * @param flight
	 *            flight
	 * @return item
	 */
	public static ItemStack setFlight(ItemStack item, int flight) {
		if (!isApplicable(item)) return null;
		CraftItemStack craftStack = null;
		net.minecraft.server.v1_4_5.ItemStack itemStack = null;
		if (item instanceof CraftItemStack) {
			craftStack = (CraftItemStack) item;
			itemStack = craftStack.getHandle();
		}
		else if (item instanceof ItemStack) {
			craftStack = new CraftItemStack(item);
			itemStack = craftStack.getHandle();
		}
		if (itemStack == null) return null;
		NBTTagCompound tag = itemStack.tag;
		if (tag == null) {
			tag = new NBTTagCompound();
			tag.setCompound("Fireworks", new NBTTagCompound());
			itemStack.tag = tag;
		}
		
		tag = itemStack.tag.getCompound("Fireworks");
		tag.setByte("Flight", (byte) flight);
		itemStack.tag.setCompound("Fireworks", tag);
		return craftStack;
	}
	
	/**
	 * Gets height of the flight.
	 * 
	 * @param item
	 *            item
	 * @return height
	 */
	public static int getFlight(ItemStack item) {
		if (!isApplicable(item)) return -1;
		CraftItemStack craftStack = null;
		net.minecraft.server.v1_4_5.ItemStack itemStack = null;
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
			tag.setCompound("Fireworks", new NBTTagCompound());
			itemStack.tag = tag;
			return -1;
		}
		
		tag = itemStack.tag.getCompound("Fireworks");
		return tag.getByte("Flight");
	}
}
