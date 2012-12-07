package com.stirante.PrettyScaryLib;

import net.minecraft.server.EntityZombie;

import org.bukkit.craftbukkit.entity.CraftZombie;
import org.bukkit.entity.Zombie;

/**
 * Class, that allows setting and getting type of zombie
 */
public class ZombieHelper {
	
	/**
	 * Checks if is baby.
	 * 
	 * @param zombie
	 *            the zombie
	 * @return true, if is baby
	 */
	public static boolean isBaby(Zombie zombie) {
		EntityZombie ent = ((CraftZombie) zombie).getHandle();
		return ent.isBaby();
	}
	
	/**
	 * Sets the baby.
	 * 
	 * @param zombie
	 *            the zombie
	 * @param value
	 *            the value
	 */
	public static void setBaby(Zombie zombie, boolean value) {
		EntityZombie ent = ((CraftZombie) zombie).getHandle();
		ent.setBaby(value);
	}
	
	/**
	 * Checks if is villager.
	 * 
	 * @param zombie
	 *            the zombie
	 * @return true, if is villager
	 */
	public static boolean isVillager(Zombie zombie) {
		EntityZombie ent = ((CraftZombie) zombie).getHandle();
		return ent.isVillager();
	}
	
	/**
	 * Sets the villager.
	 * 
	 * @param zombie
	 *            the zombie
	 * @param value
	 *            the value
	 */
	public static void setVillager(Zombie zombie, boolean value) {
		EntityZombie ent = ((CraftZombie) zombie).getHandle();
		ent.setVillager(value);
	}
}
