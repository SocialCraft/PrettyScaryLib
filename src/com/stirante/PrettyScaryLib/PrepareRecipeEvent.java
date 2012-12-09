package com.stirante.PrettyScaryLib;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class PrepareRecipeEvent extends Event{
	
	private ItemStack	result;
	private ItemStack[]	inv;
	private String	name;
	private static HandlerList	handlers = new HandlerList();

	public PrepareRecipeEvent(ItemStack[] inventory, ItemStack result, String name){
		super();
		inv = inventory;
		this.setResult(result);
		this.name = name;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers ;
	}
	
	public static HandlerList getHandlerList() {
		return handlers ;
	}

	public ItemStack getResult() {
		return result;
	}

	public void setResult(ItemStack result) {
		this.result = result;
	}

	public ItemStack[] getInventory() {
		return inv;
	}

	public String getName() {
		return name;
	}
	
}
