package com.stirante.PrettyScaryLib;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

/**
 * Event fired, when custom recipe is preparing result of recipe.
 */
public class PrepareRecipeEvent extends Event {
	
	private ItemStack			result;
	private ItemStack[]			inv;
	private String				name;
	private static HandlerList	handlers	= new HandlerList();
	
	/**
	 * Instantiates a new prepare recipe event.
	 * 
	 * @param inventory
	 *            the inventory
	 * @param result
	 *            the result
	 * @param name
	 *            the name
	 */
	public PrepareRecipeEvent(ItemStack[] inventory, ItemStack result,
			String name) {
		super();
		inv = inventory;
		setResult(result);
		this.name = name;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	/**
	 * Gets the handler list.
	 * 
	 * @return the handler list
	 */
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	/**
	 * Gets the result.
	 * 
	 * @return the result
	 */
	public ItemStack getResult() {
		return result;
	}
	
	/**
	 * Sets the result.
	 * 
	 * @param result
	 *            the new result
	 */
	public void setResult(ItemStack result) {
		this.result = result;
	}
	
	/**
	 * Gets the inventory.
	 * 
	 * @return the inventory
	 */
	public ItemStack[] getInventory() {
		return inv;
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
