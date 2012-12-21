package com.stirante.PrettyScaryLib;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import net.minecraft.server.v1_4_6.EntityLiving;
import net.minecraft.server.v1_4_6.EntitySkeleton;
import net.minecraft.server.v1_4_6.Item;
import net.minecraft.server.v1_4_6.PathfinderGoal;
import net.minecraft.server.v1_4_6.PathfinderGoalSelector;

import org.bukkit.craftbukkit.v1_4_6.entity.CraftSkeleton;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;

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
		return SkeletonType.getType(ent.getSkeletonType());
	}
	
	/**
	 * Sets the type of skeleton.
	 * 
	 * @param skeleton
	 *            skeleton
	 * @param type
	 *            type
	 */
	public static void setType(Skeleton skeleton, SkeletonType type) {
		if (type == SkeletonType.NORMAL)
			changeIntoNormal(skeleton, true);
		else
			changeIntoWither(skeleton);
	}
	
	private static void changeIntoNormal(Skeleton skeleton, boolean giveRandomEnchantments){
		EntitySkeleton ent = ((CraftSkeleton)skeleton).getHandle();
		try {
			ent.setSkeletonType(0);
			Method be = EntitySkeleton.class.getDeclaredMethod("bE");
			be.setAccessible(true);
			be.invoke(ent);
			if (giveRandomEnchantments){
				Method bf = EntityLiving.class.getDeclaredMethod("bF");
				bf.setAccessible(true);
				bf.invoke(ent);
			}
			Field selector = EntitySkeleton.class.getDeclaredField("goalSelector");
			selector.setAccessible(true);
			Field d = EntitySkeleton.class.getDeclaredField("d");
			d.setAccessible(true);
			PathfinderGoalSelector goals = (PathfinderGoalSelector) selector.get(ent);
			goals.a(4, (PathfinderGoal) d.get(ent));
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
	}
	private static void changeIntoWither(Skeleton skeleton){
		EntitySkeleton ent = ((CraftSkeleton)skeleton).getHandle();
		try {
			ent.setSkeletonType(1);
			Field selector = EntitySkeleton.class.getDeclaredField("goalSelector");
			selector.setAccessible(true);
			Field e = EntitySkeleton.class.getDeclaredField("e");
			e.setAccessible(true);
			PathfinderGoalSelector goals = (PathfinderGoalSelector) selector.get(ent);
			goals.a(4, (PathfinderGoal) e.get(ent));
			ent.setEquipment(0, new net.minecraft.server.v1_4_6.ItemStack(Item.STONE_SWORD));
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
