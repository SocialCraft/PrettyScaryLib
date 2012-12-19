package com.stirante.PrettyScaryLib;

import java.util.HashMap;

import net.minecraft.server.v1_4_5.CraftingManager;
import net.minecraft.server.v1_4_5.IRecipe;
import net.minecraft.server.v1_4_5.InventoryCrafting;
import net.minecraft.server.v1_4_5.ItemStack;
import net.minecraft.server.v1_4_5.NBTTagCompound;
import net.minecraft.server.v1_4_5.ShapedRecipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_4_5.inventory.CraftItemStack;

/**
 * Class, that allows adding custom shaped recipe which returns item with NBT
 * tags
 */
public class CustomShapedRecipe extends ShapedRecipes implements IRecipe {
	
	private ItemStack	result;
	private String		name;
	
	/**
	 * Instantiates a new custom shaped recipe. Use only when you know what are
	 * you doing. If not, use CustomShapedRecipe.addRecipe() method.
	 * 
	 * @param i
	 *            width
	 * @param j
	 *            height
	 * @param items
	 *            the items
	 * @param item
	 *            the item
	 * @param name
	 *            the name
	 */
	public CustomShapedRecipe(int i, int j, ItemStack[] items, ItemStack item,
			String name) {
		super(i, j, items, item);
		result = item;
		this.name = name;
	}
	
	@Override
	public ItemStack a(InventoryCrafting inv) {
		ItemStack item = result.cloneItemStack();
		org.bukkit.inventory.ItemStack[] inventory = new org.bukkit.craftbukkit.v1_4_5.inventory.CraftItemStack[inv
				.getSize()];
		for (int i = 0; i < inv.getContents().length; i++)
			inventory[i] = CraftItemStack.asBukkitCopy(inv.getContents()[i]);
		if (result.getTag() != null)
			item.setTag((NBTTagCompound) result.getTag().clone());
		PrepareRecipeEvent event = new PrepareRecipeEvent(inventory,
				CraftItemStack.asBukkitCopy(item), name);
		Bukkit.getPluginManager().callEvent(event);
		item = CraftItemStack.asNMSCopy(event.getResult());
		return item;
	}
	
	/**
	 * Adds the recipe.
	 * 
	 * Example:
	 * 
	 * CustomShapedRecipe.addRecipe("Diamond dagger", item, new Object[]{"X",
	 * "Y", 'X', Material.DIAMOND, 'Y', Material.STICK});
	 * 
	 * @param name
	 *            name of recipe. Usefull in event.
	 * @param item1
	 *            returned in recipe item.
	 * @param args
	 *            Arguments
	 * @return the custom shaped recipe. Note that recipe is automagicly added
	 *         to CraftingManager.
	 */
	@SuppressWarnings("unchecked")
	public static CustomShapedRecipe addRecipe(String name,
			org.bukkit.inventory.ItemStack item1, Object... args) {
		ItemStack item = null;
			item = CraftItemStack.asNMSCopy(item1);
		String var3 = "";
		int var4 = 0;
		int var5 = 0;
		int var6 = 0;
		int var9;
		
		if (args[var4] instanceof String[]) {
			String[] var7 = (String[]) args[var4++];
			String[] var8 = var7;
			var9 = var7.length;
			
			for (int var10 = 0; var10 < var9; ++var10) {
				String var11 = var8[var10];
				++var6;
				var5 = var11.length();
				var3 = var3 + var11;
			}
		}
		else
			while (args[var4] instanceof String) {
				String var13 = (String) args[var4++];
				++var6;
				var5 = var13.length();
				var3 = var3 + var13;
			}
		
		HashMap<Character, ItemStack> var14;
		
		for (var14 = new HashMap<Character, ItemStack>(); var4 < args.length; var4 += 2) {
			Character var16 = (Character) args[var4];
			ItemStack var17 = null;
			
			if (args[var4 + 1] instanceof org.bukkit.inventory.ItemStack) {
					var17 = CraftItemStack.asNMSCopy((org.bukkit.inventory.ItemStack) args[var4 + 1]).cloneItemStack();
			}
			else if (args[var4 + 1] instanceof org.bukkit.Material)
				var17 = CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack((Material)args[var4 + 1]));
			
			var14.put(var16, var17);
		}
		
		ItemStack[] var15 = new ItemStack[var5 * var6];
		
		for (var9 = 0; var9 < var5 * var6; ++var9) {
			char var18 = var3.charAt(var9);
			
			if (var14.containsKey(Character.valueOf(var18)))
				var15[var9] = var14.get(Character.valueOf(var18))
						.cloneItemStack();
			else
				var15[var9] = null;
		}
		CustomShapedRecipe result = new CustomShapedRecipe(var5, var6, var15,
				item, name);
		CraftingManager.getInstance().recipes.add(result);
		CraftingManager.getInstance().sort();
		return result;
	}
	
	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
}
