package com.stirante.PrettyScaryLib;

import java.lang.reflect.Field;

import net.minecraft.server.v1_4_6.TileEntityBeacon;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_4_6.CraftWorld;
import org.bukkit.craftbukkit.v1_4_6.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

/**
 * Class, that allows modifying beacon block.
 */
public class BeaconHelper {
	
	/**
	 * Sets the level.
	 * 
	 * @param block
	 *            beacon
	 * @param level
	 *            level
	 */
	public static void setLevel(Block block, int level) {
		if (!isApplicable(block)) return;
		TileEntityBeacon beacon = (TileEntityBeacon) ((CraftWorld) block
				.getWorld()).getHandle().getTileEntity(block.getX(),
				block.getY(), block.getZ());
		Field lvl = null;
		try {
			lvl = TileEntityBeacon.class.getDeclaredField("e");
			lvl.setAccessible(true);
			lvl.set(beacon, level);
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
	}
	
	/**
	 * Activates and deactivates the beacon.
	 * 
	 * @param block
	 *            beacon
	 * @param state
	 *            state
	 */
	public static void setActive(Block block, boolean state) {
		if (!isApplicable(block)) return;
		TileEntityBeacon beacon = (TileEntityBeacon) ((CraftWorld) block
				.getWorld()).getHandle().getTileEntity(block.getX(),
				block.getY(), block.getZ());
		Field active = null;
		try {
			active = TileEntityBeacon.class.getDeclaredField("d");
			active.setAccessible(true);
			active.set(beacon, state);
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
	}
	
	/**
	 * Checks if beacon is active.
	 * 
	 * @param block
	 *            beacon
	 * @return true if active
	 */
	public static boolean isActive(Block block) {
		if (!isApplicable(block)) return false;
		TileEntityBeacon beacon = (TileEntityBeacon) ((CraftWorld) block
				.getWorld()).getHandle().getTileEntity(block.getX(),
				block.getY(), block.getZ());
		Field active = null;
		try {
			active = TileEntityBeacon.class.getDeclaredField("e");
			active.setAccessible(true);
			return (Boolean) active.get(beacon);
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
		return false;
	}
	
	/**
	 * Sets the item in beacon.
	 * 
	 * @param block
	 *            beacon
	 * @param item
	 *            item
	 */
	public static void setItemStack(Block block, ItemStack item) {
		if (!isApplicable(block)) return;
		TileEntityBeacon beacon = (TileEntityBeacon) ((CraftWorld) block
				.getWorld()).getHandle().getTileEntity(block.getX(),
				block.getY(), block.getZ());
		if (!(item instanceof CraftItemStack))
			item = CraftItemStack.asCraftCopy(new ItemStack(item.getType()));
		beacon.setItem(0, CraftItemStack.asNMSCopy(item));
	}
	
	/**
	 * Gets the item.
	 * 
	 * @param block
	 *            beacon
	 * @return item
	 */
	public static ItemStack getItemStack(Block block) {
		if (!isApplicable(block)) return null;
		TileEntityBeacon beacon = (TileEntityBeacon) ((CraftWorld) block
				.getWorld()).getHandle().getTileEntity(block.getX(),
				block.getY(), block.getZ());
		return CraftItemStack.asBukkitCopy(beacon.getItem(0));
	}
	
	/**
	 * Gets the level.
	 * 
	 * @param block
	 *            beacon
	 * @return level
	 */
	public static int getLevel(Block block) {
		if (!isApplicable(block)) return -1;
		TileEntityBeacon beacon = (TileEntityBeacon) ((CraftWorld) block
				.getWorld()).getHandle().getTileEntity(block.getX(),
				block.getY(), block.getZ());
		return beacon.k();
	}
	
	/**
	 * Sets the primary effect.
	 * 
	 * @param block
	 *            beacon
	 * @param effect
	 *            PotionEffectType to apply
	 */
	public static void setPrimaryEffect(Block block, PotionEffectType effect) {
		if (!isApplicable(block)) return;
		TileEntityBeacon beacon = (TileEntityBeacon) ((CraftWorld) block
				.getWorld()).getHandle().getTileEntity(block.getX(),
				block.getY(), block.getZ());
		beacon.d(effect.getId());
	}
	
	/**
	 * Gets the primary effect.
	 * 
	 * @param block
	 *            beacon
	 * @return effect
	 */
	public static PotionEffectType getPrimaryEffect(Block block) {
		if (!isApplicable(block)) return null;
		TileEntityBeacon beacon = (TileEntityBeacon) ((CraftWorld) block
				.getWorld()).getHandle().getTileEntity(block.getX(),
				block.getY(), block.getZ());
		return PotionEffectType.getById(beacon.k());
	}
	
	/**
	 * Sets the secondary effect.
	 * 
	 * @param block
	 *            beacon
	 * @param effect
	 *            PotionEffectType to apply
	 */
	public static void setSecondaryEffect(Block block, PotionEffectType effect) {
		if (!isApplicable(block)) return;
		TileEntityBeacon beacon = (TileEntityBeacon) ((CraftWorld) block
				.getWorld()).getHandle().getTileEntity(block.getX(),
				block.getY(), block.getZ());
		beacon.e(effect.getId());
	}
	
	/**
	 * Gets the secondary effect.
	 * 
	 * @param block
	 *            beacon
	 * @return effect
	 */
	public static PotionEffectType getSecondaryEffect(Block block) {
		if (!isApplicable(block)) return null;
		TileEntityBeacon beacon = (TileEntityBeacon) ((CraftWorld) block
				.getWorld()).getHandle().getTileEntity(block.getX(),
				block.getY(), block.getZ());
		return PotionEffectType.getById(beacon.j());
	}
	
	/**
	 * Checks if is applicable.
	 * 
	 * @param block
	 *            the block
	 * @return true, if is applicable
	 */
	public static boolean isApplicable(Block block) {
		switch (block.getType()) {
			case BEACON:
				return true;
			default:
				return false;
		}
	}
}
