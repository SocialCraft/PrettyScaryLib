package com.stirante.PrettyScaryLib;

import net.minecraft.server.EntityLiving;

import org.bukkit.craftbukkit.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

/**
 * Class, that allows setting and getting equipment of mob.
 */
public class EntityEquipment {
	
	/**
	 * Sets equipment.
	 * 
	 * @param mob
	 *            mob
	 * @param item
	 *            item
	 * @param slot
	 *            slot
	 */
	public static void setEquipment(LivingEntity mob, ItemStack item, int slot) {
		if (!isApplicable(mob)) return;
		if (item instanceof CraftItemStack) {
		}
		else if (item instanceof ItemStack) item = new CraftItemStack(item);
		EntityLiving ent = ((CraftLivingEntity) mob).getHandle();
		net.minecraft.server.ItemStack itemStack = ((CraftItemStack) item)
				.getHandle();
		ent.setEquipment(slot, itemStack);
	}
	
	/**
	 * Gets equipment.
	 * 
	 * @param mob
	 *            mob
	 * @param slot
	 *            slot
	 * @return equiped item
	 */
	public static ItemStack getEquipment(LivingEntity mob, int slot) {
		if (!isApplicable(mob)) return null;
		EntityLiving ent = ((CraftLivingEntity) mob).getHandle();
		return new CraftItemStack(ent.getEquipment(slot));
	}
	
	/**
	 * Sets weapon.
	 * 
	 * @param mob
	 *            mob
	 * @param item
	 *            item
	 */
	public static void setWeapon(LivingEntity mob, ItemStack item) {
		setEquipment(mob, item, 0);
	}
	
	/**
	 * Gets weapon.
	 * 
	 * @param mob
	 *            mob
	 * @return weapon
	 */
	public static ItemStack getWeapon(LivingEntity mob) {
		return getEquipment(mob, 0);
	}
	
	/**
	 * Sets helmet.
	 * 
	 * @param mob
	 *            mob
	 * @param item
	 *            item
	 */
	public static void setHelmet(LivingEntity mob, ItemStack item) {
		setEquipment(mob, item, 1);
	}
	
	/**
	 * Gets helmet.
	 * 
	 * @param mob
	 *            mob
	 * @return helmet
	 */
	public static ItemStack getHelmet(LivingEntity mob) {
		return getEquipment(mob, 1);
	}
	
	/**
	 * Sets chestplate.
	 * 
	 * @param mob
	 *            mob
	 * @param item
	 *            item
	 */
	public static void setChestplate(LivingEntity mob, ItemStack item) {
		setEquipment(mob, item, 2);
	}
	
	/**
	 * Gets chestplate.
	 * 
	 * @param mob
	 *            mob
	 * @return chestplate
	 */
	public static ItemStack getChestplate(LivingEntity mob) {
		return getEquipment(mob, 2);
	}
	
	/**
	 * Sets pants.
	 * 
	 * @param mob
	 *            mob
	 * @param item
	 *            item
	 */
	public static void setPants(LivingEntity mob, ItemStack item) {
		setEquipment(mob, item, 3);
	}
	
	/**
	 * Gets pants.
	 * 
	 * @param mob
	 *            mob
	 * @return pants
	 */
	public static ItemStack getPants(LivingEntity mob) {
		return getEquipment(mob, 3);
	}
	
	/**
	 * Sets boots.
	 * 
	 * @param mob
	 *            mob
	 * @param item
	 *            item
	 */
	public static void setBoots(LivingEntity mob, ItemStack item) {
		setEquipment(mob, item, 4);
	}
	
	/**
	 * Gets boots.
	 * 
	 * @param mob
	 *            mob
	 * @return boots
	 */
	public static ItemStack getBoots(LivingEntity mob) {
		return getEquipment(mob, 4);
	}
	
	/**
	 * Checks if is applicable.
	 * 
	 * @param entity
	 *            entity
	 * @return true, if is applicable
	 */
	public static boolean isApplicable(LivingEntity entity) {
		switch (entity.getType()) {
			case ZOMBIE:
			case SKELETON:
			case PIG_ZOMBIE:
				return true;
			default:
				return false;
		}
	}
}
