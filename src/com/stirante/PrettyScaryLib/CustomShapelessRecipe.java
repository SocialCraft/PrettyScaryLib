package com.stirante.PrettyScaryLib;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_4_5.inventory.CraftItemStack;

import net.minecraft.server.v1_4_5.CraftingManager;
import net.minecraft.server.v1_4_5.IRecipe;
import net.minecraft.server.v1_4_5.InventoryCrafting;
import net.minecraft.server.v1_4_5.ItemStack;
import net.minecraft.server.v1_4_5.NBTTagCompound;
import net.minecraft.server.v1_4_5.ShapelessRecipes;

public class CustomShapelessRecipe extends ShapelessRecipes implements IRecipe {

	private ItemStack	result;
	private String	name;
	
	public CustomShapelessRecipe(String name, ItemStack itemstack, List<ItemStack> list) {
		super(itemstack, list);
		result = itemstack;
		this.name = name;
	}

	@Override
	public ItemStack a(InventoryCrafting arg0) {
		ItemStack item = result.cloneItemStack();
		org.bukkit.inventory.ItemStack[] inventory = new org.bukkit.craftbukkit.v1_4_5.inventory.CraftItemStack[arg0.getSize()];
		for (int i = 0; i < arg0.getContents().length; i++) {
			inventory[i] = new org.bukkit.craftbukkit.v1_4_5.inventory.CraftItemStack(arg0.getContents()[i]);
		}
		if (result.getTag() != null)
			item.setTag((NBTTagCompound) result.getTag().clone());
		PrepareRecipeEvent event = new PrepareRecipeEvent(inventory, new CraftItemStack(item), name);
		Bukkit.getPluginManager().callEvent(event);
		item = ((CraftItemStack)event.getResult()).getHandle();
		return item;
	}
	
	
	@SuppressWarnings("unchecked")
	public static CustomShapelessRecipe addRecipe(String name, org.bukkit.inventory.ItemStack item1, Object ... args){
		ItemStack item = null;
		if (item1 instanceof CraftItemStack)
			item = ((CraftItemStack)item1).getHandle();
		else
			item = new CraftItemStack(item1).getHandle();
        ArrayList<ItemStack> var3 = new ArrayList<ItemStack>();
        Object[] var4 = args;
        int var5 = args.length;

        for (int var6 = 0; var6 < var5; ++var6)
        {
            Object var7 = var4[var6];

            if (var7 instanceof org.bukkit.inventory.ItemStack)
            {
            	if (var7 instanceof CraftItemStack)
            		var3.add(((CraftItemStack)var7).getHandle().cloneItemStack());
            	else
            		var3.add(new CraftItemStack((org.bukkit.inventory.ItemStack) var7).getHandle());
                //var3.add(((CraftItemStack)var7).getHandle().cloneItemStack());
            }
            else if (var7 instanceof Material)
            {
                var3.add((new CraftItemStack((Material)var7)).getHandle().cloneItemStack());
            }
            else
            {
            	throw new RuntimeException("Invalid shapeless recipy!");
            }
        }
        CustomShapelessRecipe result = new CustomShapelessRecipe(name, item, var3);
        CraftingManager.getInstance().recipes.add(result);
        CraftingManager.getInstance().sort();
		return result;
	}
	
	public String getName(){
		return name;
	}
}
