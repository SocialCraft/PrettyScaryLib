package com.stirante.PrettyScaryLib;

import net.minecraft.server.EntitySkeleton;

import org.bukkit.Material;
import org.bukkit.craftbukkit.entity.CraftSkeleton;
import org.bukkit.entity.Skeleton;
import org.bukkit.inventory.ItemStack;

/**
 * Class, that allows setting and getting type of skeleton
 */
public class SkeletonHelper {
	
	/**
	 * Checks if skeleton is wither skeleton.
	 * 
	 * @param skeleton
	 *            the skeleton
	 * @return true, if is wither
	 */
	public static boolean isWither(Skeleton skeleton) {
		EntitySkeleton ent = ((CraftSkeleton) skeleton).getHandle();
		return ent.getSkeletonType() == 1;
	}
	
	/**
	 * Gets the type of skeleton.
	 * 
	 * @param skeleton
	 *            skeleton
	 * @return type
	 */
	public static SkeletonType getType(Skeleton skeleton) {
		EntitySkeleton ent = ((CraftSkeleton) skeleton).getHandle();
		return SkeletonType.getById(ent.getSkeletonType());
	}
	
	/**
	 * Sets the type of skeleton.
	 * 
	 * @param skeleton
	 *            skeleton
	 * @param type
	 *            type
	 */
	public static void setWither(Skeleton skeleton, SkeletonType type) {
		EntitySkeleton ent = ((CraftSkeleton) skeleton).getHandle();
		if (isWither(skeleton))
			EntityEquipment.setWeapon(skeleton, new ItemStack(
					Material.STONE_SWORD));
		else
			EntityEquipment.setWeapon(skeleton, new ItemStack(Material.BOW));
		ent.setSkeletonType(type.getType());
	}
}
