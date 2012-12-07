package com.stirante.PrettyScaryLib;

import net.minecraft.server.NBTBase;
import net.minecraft.server.NBTTagCompound;

import org.bukkit.enchantments.Enchantment;

public class StoredEnchantment {
	private Enchantment	ench;
	private short		lvl;
	
	public StoredEnchantment(Enchantment ench, int lvl) {
		this.setEnchantment(ench);
		setLevel((short) lvl);
	}
	
	public StoredEnchantment(NBTTagCompound tag) {
		setEnchantment(tag.getShort("id"));
		setLevel(tag.getShort("lvl"));
	}
	
	public Enchantment getEnchantment() {
		return ench;
	}
	
	public void setEnchantment(Enchantment ench) {
		this.ench = ench;
	}
	
	public void setEnchantment(int ench) {
		this.ench = Enchantment.getById(ench);
	}
	
	public short getLevel() {
		return lvl;
	}
	
	public void setLevel(short lvl) {
		this.lvl = lvl;
	}
	
	public NBTBase getTag() {
		NBTTagCompound tag = new NBTTagCompound();
		tag.setShort("id", (short) getEnchantment().getId());
		tag.setShort("lvl", getLevel());
		return tag;
	}
}
