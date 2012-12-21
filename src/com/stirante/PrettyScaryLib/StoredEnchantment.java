package com.stirante.PrettyScaryLib;

import net.minecraft.server.v1_4_6.NBTBase;
import net.minecraft.server.v1_4_6.NBTTagCompound;

import org.bukkit.enchantments.Enchantment;

/**
 * Class, that stores informations about enchanted books.
 */
public class StoredEnchantment {
	private Enchantment	ench;
	private short		lvl;
	
	/**
	 * Instantiates a new stored enchantment.
	 * 
	 * @param ench
	 *            the ench
	 * @param lvl
	 *            the lvl
	 */
	public StoredEnchantment(Enchantment ench, int lvl) {
		this.setEnchantment(ench);
		setLevel((short) lvl);
	}
	
	/**
	 * Instantiates a new stored enchantment.
	 * 
	 * @param tag
	 *            the tag
	 */
	public StoredEnchantment(NBTTagCompound tag) {
		setEnchantment(tag.getShort("id"));
		setLevel(tag.getShort("lvl"));
	}
	
	/**
	 * Gets the enchantment.
	 * 
	 * @return the enchantment
	 */
	public Enchantment getEnchantment() {
		return ench;
	}
	
	/**
	 * Sets the enchantment.
	 * 
	 * @param ench
	 *            the new enchantment
	 */
	public void setEnchantment(Enchantment ench) {
		this.ench = ench;
	}
	
	/**
	 * Sets the enchantment.
	 * 
	 * @param ench
	 *            the new enchantment
	 */
	public void setEnchantment(int ench) {
		this.ench = Enchantment.getById(ench);
	}
	
	/**
	 * Gets the level.
	 * 
	 * @return the level
	 */
	public short getLevel() {
		return lvl;
	}
	
	/**
	 * Sets the level.
	 * 
	 * @param lvl
	 *            the new level
	 */
	public void setLevel(short lvl) {
		this.lvl = lvl;
	}
	
	/**
	 * Gets the tag.
	 * 
	 * @return the tag
	 */
	public NBTBase getTag() {
		NBTTagCompound tag = new NBTTagCompound();
		tag.setShort("id", (short) getEnchantment().getId());
		tag.setShort("lvl", getLevel());
		return tag;
	}
}
