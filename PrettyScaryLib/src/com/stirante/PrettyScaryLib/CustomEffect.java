package com.stirante.PrettyScaryLib;

import org.bukkit.potion.PotionEffectType;

/**
 * Class, that store informations about custom effect of potion.
 */
public class CustomEffect {
	
	/** Type of effect. */
	private PotionEffectType	type;
	
	/** Amplifier. */
	private int	amplifier;
	
	/** Duration. */
	private int	duration;

	/**
	 * Instantiates a new custom effect.
	 *
	 * @param type type of effect
	 * @param amplifier amplifier
	 * @param duration duration in ticks
	 */
	public CustomEffect(PotionEffectType type, int amplifier, int duration){
		this.setType(type);
		this.setAmplifier(amplifier);
		this.setDuration(duration);
	}

	/**
	 * Gets the type of effect.
	 *
	 * @return type of effect
	 */
	public PotionEffectType getType() {
		return type;
	}

	/**
	 * Sets the type of effect.
	 *
	 * @param type new type of effect
	 */
	public void setType(PotionEffectType type) {
		this.type = type;
	}

	/**
	 * Gets amplifier.
	 *
	 * @return amplifier
	 */
	public int getAmplifier() {
		return amplifier;
	}

	/**
	 * Sets the amplifier.
	 *
	 * @param amplifier new amplifier
	 */
	public void setAmplifier(int amplifier) {
		this.amplifier = amplifier;
	}

	/**
	 * Gets the duration.
	 *
	 * @return duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Sets the duration.
	 *
	 * @param duration new duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
