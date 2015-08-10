package de.maxhenkel.caveworld.potions;

import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class PotionRadiation extends Potion{

	public PotionRadiation(int potionID, ResourceLocation location, boolean badEffect, int potionColor) {
		super(potionID, location, badEffect, potionColor);
	}

	@Override
	public Potion setIconIndex(int x, int y) {
		super.setIconIndex(x, y);
		return this;
	}
	
	@Override
	public String getName() {
		return StatCollector.translateToLocal("potion.radiation.name");
	}
	
	
}
