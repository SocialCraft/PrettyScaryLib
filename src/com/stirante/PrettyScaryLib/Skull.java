package com.stirante.PrettyScaryLib;

import java.lang.reflect.Field;

import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.TileEntitySkull;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

/**
 * Class, that allows setting and getting skin fo skull.
 */
public class Skull {
	
	/**
	 * Sets skin.
	 * 
	 * @param item
	 *            item
	 * @param nick
	 *            nick
	 * @return item stack
	 */
	public static ItemStack setSkin(ItemStack item, String nick) {
		if (!isApplicable(item)) return null;
		CraftItemStack craftStack = null;
		net.minecraft.server.ItemStack itemStack = null;
		if (item instanceof CraftItemStack) {
			craftStack = (CraftItemStack) item;
			itemStack = craftStack.getHandle();
		}
		else if (item instanceof ItemStack) {
			craftStack = new CraftItemStack(item);
			itemStack = craftStack.getHandle();
		}
		NBTTagCompound tag = itemStack.tag;
		if (tag == null) tag = new NBTTagCompound();
		tag.setString("SkullOwner", nick);
		itemStack.tag = tag;
		return craftStack;
	}
	
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
		skull.a(skull.a(), nick);
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
		skull.p = rotation;
		
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
	 * Gets skin.
	 * 
	 * @param item
	 *            item
	 * @return skin
	 */
	public static String getSkin(ItemStack item) {
		if (!isApplicable(item)) return null;
		CraftItemStack craftStack = null;
		net.minecraft.server.ItemStack itemStack = null;
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
			return null;
		}
		return tag.getString("SkullOwner");
	}
	
	/**
	 * Checks if is applicable.
	 * 
	 * @param item
	 *            item
	 * @return true, if is applicable
	 */
	public static boolean isApplicable(Object obj) {
		if (obj instanceof ItemStack)
			switch (((ItemStack) obj).getType()) {
				case SKULL_ITEM:
					return true;
				default:
					return false;
			}
		else if (obj instanceof Block) switch (((Block) obj).getType()) {
			case SKULL:
				return true;
			default:
				return false;
		}
		return false;
	}
}
