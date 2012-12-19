package com.stirante.PrettyScaryLib;

import java.lang.reflect.Field;

import net.minecraft.server.v1_4_5.TileEntitySkull;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_4_5.CraftWorld;

/**
 * Class, that allows setting and getting skin fo skull.
 */
public class Skull {
	/**
	 * Sets skin.
	 * 
	 * @param block
	 *            block
	 * @param nick
	 *            nick
	 */
	public static void setSkin(Block block, String nick) {
		if (!isApplicable(block)) return;
		TileEntitySkull skull = (TileEntitySkull) ((CraftWorld) block
				.getWorld()).getHandle().getTileEntity(block.getX(),
				block.getY(), block.getZ());
		skull.setSkullType(skull.getSkullType(), nick);
	}
	
	/**
	 * Gets rotation.
	 * 
	 * @param block
	 *            block
	 * @param rotation
	 *            rotation
	 * @return rotation
	 */
	public static int getRotation(Block block, int rotation) {
		if (!isApplicable(block)) return -1;
		TileEntitySkull skull = (TileEntitySkull) ((CraftWorld) block
				.getWorld()).getHandle().getTileEntity(block.getX(),
				block.getY(), block.getZ());
		return skull.p & 7;
	}
	
	/**
	 * Sets rotation.
	 * 
	 * @param block
	 *            block
	 * @param rotation
	 *            rotation
	 */
	public static void setRotation(Block block, int rotation) {
		if (!isApplicable(block)) return;
		TileEntitySkull skull = (TileEntitySkull) ((CraftWorld) block
				.getWorld()).getHandle().getTileEntity(block.getX(),
				block.getY(), block.getZ());
		skull.setRotation(rotation);
		
	}
	
	/**
	 * Gets skin.
	 * 
	 * @param block
	 *            block
	 * @param nick
	 *            nick
	 * @return nick
	 */
	public static String getSkin(Block block) {
		if (!isApplicable(block)) return null;
		TileEntitySkull skull = (TileEntitySkull) ((CraftWorld) block
				.getWorld()).getHandle().getTileEntity(block.getX(),
				block.getY(), block.getZ());
		try {
			Field field = TileEntitySkull.class.getDeclaredField("c");
			field.setAccessible(true);
			return (String) field.get(skull);
		}
		catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		catch (SecurityException e) {
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Checks if is applicable.
	 * 
	 * @param item
	 *            item
	 * @return true, if is applicable
	 */
	public static boolean isApplicable(Block block) {
		switch (block.getType()) {
			case SKULL:
				return true;
			default:
				return false;
		}
	}
}
