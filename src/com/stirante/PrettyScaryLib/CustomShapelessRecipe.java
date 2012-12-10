package com.stirante.PrettyScaryLib;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.server.v1_4_5.CraftingManager;
import net.minecraft.server.v1_4_5.IRecipe;
import net.minecraft.server.v1_4_5.InventoryCrafting;
import net.minecraft.server.v1_4_5.ItemStack;
import net.minecraft.server.v1_4_5.NBTTagCompound;
import net.minecraft.server.v1_4_5.ShapelessRecipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_4_5.inventory.CraftItemStack;

/**
 * Class, that allows adding custom shaped recipe which returns item with NBT
 * tags.
 */
public class CustomShapelessRecipe extends ShapelessRecipes implements IRecipe {
	
	private ItemStack	result;
	private String		name;
	
	/**
	 * Instantiates a new custom shapeless recipe. Better use
	 * CustomShapelessRecipe.addRecipe() method.
	 * 
	 * @param name
	 *            the name
	 * @param itemstack
	 *            the itemstack
	 * @param list
	 *            the list
	 */
	public CustomShapelessRecipe(String name, ItemStack itemstack,
			List<ItemStack> list) {
		super(itemstack, list);
		result = itemstack;
		this.name = name;
	}
	
	@Override
	public ItemStack a(InventoryCrafting arg0) {
		ItemStack item = result.cloneItemStack();
		org.bukkit.inventory.ItemStack[] inventory = new org.bukkit.craftbukkit.v1_4_5.inventory.CraftItemStack[arg0
				.getSize()];
		for (int i = 0; i < arg0.getContents().length; i++)
			inventory[i] = new org.bukkit.craftbukkit.v1_4_5.inventory.CraftItemStack(
					arg0.getContents()[i]);
		if (result.getTag() != null)
			item.setTag((NBTTagCompound) result.getTag().clone());
		PrepareRecipeEvent event = new PrepareRecipeEvent(inventory,
				new CraftItemStack(item), name);
		Bukkit.getPluginManager().callEvent(event);
		item = ((CraftItemStack) event.getResult()).getHandle();
		return item;
	}
	
	/**
	 * Adds the recipe.
	 * 
	 * Example:
	 * 
	 * CustomShapelessRecipe.addRecipe("Recipe name", item, new
	 * Object[]{Material.DIAMOND, Material.STICK});
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
	public static CustomShapelessRecipe addRecipe(String name,
			org.bukkit.inventory.ItemStack item1, Object... args) {
		ItemStack item = null;
		if (item1 instanceof CraftItemStack)
			item = ((CraftItemStack) item1).getHandle();
		else
			item = new CraftItemStack(item1).getHandle();
		ArrayList<ItemStack> var3 = new ArrayList<ItemStack>();
		Object[] var4 = args;
		int var5 = args.length;
		
		for (int var6 = 0; var6 < var5; ++var6) {
			Object var7 = var4[var6];
			
			if (var7 instanceof org.bukkit.inventory.ItemStack) {
				if (var7 instanceof CraftItemStack)
					var3.add(((CraftItemStack) var7).getHandle()
							.cloneItemStack());
				else
					var3.add(new CraftItemStack(
							(org.bukkit.inventory.ItemStack) var7).getHandle());
				// var3.add(((CraftItemStack)var7).getHandle().cloneItemStack());
			}
			else if (var7 instanceof Material)
				var3.add(new CraftItemStack((Material) var7).getHandle()
						.cloneItemStack());
			else
				throw new RuntimeException("Invalid shapeless recipy!");
		}
		CustomShapelessRecipe result = new CustomShapelessRecipe(name, item,
				var3);
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
