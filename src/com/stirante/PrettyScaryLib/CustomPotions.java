package com.stirante.PrettyScaryLib;

import java.util.ArrayList;

import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;

import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

/**
 * Class, that allows adding to potions custom multiple effects.
 */
public class CustomPotions {
	
	/** The craft stack. */
	private static CraftItemStack					craftStack;
	
	/** The item stack. */
	private static net.minecraft.server.ItemStack	itemStack;
	
	/**
	 * Adds the custom effect.
	 *
	 * @param item item
	 * @param type type of effect
	 * @param amplifier amplifier
	 * @param duration the duration
	 * @return potion with given effect
	 */
	public static ItemStack addCustomEffect(ItemStack item, PotionEffectType type, int amplifier, int duration) {
		if (!isApplicable(item))
			return null;
		if (item instanceof CraftItemStack) {
			craftStack = (CraftItemStack) item;
			CustomPotions.itemStack = craftStack.getHandle();
		}
		else if (item instanceof ItemStack) {
			craftStack = new CraftItemStack(item);
			CustomPotions.itemStack = craftStack.getHandle();
		}
		NBTTagCompound tag = itemStack.tag;
		if (tag == null) {
			tag = new NBTTagCompound();
			tag.set("CustomPotionEffects", new NBTTagList());
			itemStack.tag = tag;
		}
		tag = new NBTTagCompound();
		tag.setByte("Id", (byte) type.getId());
		tag.setByte("Amplifier", (byte) amplifier);
		tag.setInt("Duration", duration);
		((NBTTagList)itemStack.tag.get("CustomPotionEffects")).add(tag);
		return craftStack;
	}
	
	/**
	 * Adds the custom effect.
	 *
	 * @param item item
	 * @param effect effect
	 * @return potion with given effect
	 */
	public static ItemStack addCustomEffect(ItemStack item, CustomEffect effect) {
		if (!isApplicable(item))
			return null;
		if (item instanceof CraftItemStack) {
			craftStack = (CraftItemStack) item;
			CustomPotions.itemStack = craftStack.getHandle();
		}
		else if (item instanceof ItemStack) {
			craftStack = new CraftItemStack(item);
			CustomPotions.itemStack = craftStack.getHandle();
		}
		NBTTagCompound tag = itemStack.tag;
		if (tag == null) {
			tag = new NBTTagCompound();
			tag.set("CustomPotionEffects", new NBTTagList());
			itemStack.tag = tag;
		}
		tag = new NBTTagCompound();
		tag.setByte("Id", (byte) effect.getType().getId());
		tag.setByte("Amplifier", (byte) effect.getAmplifier());
		tag.setInt("Duration", effect.getDuration());
		((NBTTagList)itemStack.tag.get("CustomPotionEffects")).add(tag);
		return craftStack;
	}
	
	/**
	 * Gets the custom effects.
	 *
	 * @param item item
	 * @return custom effects in item
	 */
	public static CustomEffect[] getCustomEffects(ItemStack item) {
		if (!isApplicable(item))
			return null;
		if (item instanceof CraftItemStack) {
			craftStack = (CraftItemStack) item;
			CustomPotions.itemStack = craftStack.getHandle();
		}
		else if (item instanceof ItemStack) {
			craftStack = new CraftItemStack(item);
			CustomPotions.itemStack = craftStack.getHandle();
		}
		NBTTagCompound tag = itemStack.tag;
		if (tag == null) {
			return null;
		}
		NBTTagList list = (NBTTagList) itemStack.tag.get("CustomPotionEffects");
		ArrayList<CustomEffect> effects = new ArrayList<CustomEffect>();
		for (int i = 0; i < list.size(); i++) {
			effects.add(new CustomEffect(PotionEffectType.getById(((NBTTagCompound)list.get(i)).getByte("Id")), ((NBTTagCompound)list.get(i)).getByte("Amplifier"), ((NBTTagCompound)list.get(i)).getInt("Duration")));
		}
		CustomEffect[] array = new CustomEffect[]{};
		effects.toArray(array);
		return array;
	}
	
	/**
	 * Checks if is applicable.
	 *
	 * @param item the item
	 * @return true, if is applicable
	 */
	private static boolean isApplicable(ItemStack item) {
		switch (item.getType()) {
			case POTION:
				return true;
			default:
				return false;
		}
	}
}
