package de.maxhenkel.caveworld.armor;

import de.maxhenkel.caveworld.CaveWorld;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemRadiationSuit extends ItemArmor{

	public ItemRadiationSuit(ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
		
		switch(armorType){
		case 0:
			this.setUnlocalizedName("itemArmorRadiationSuitHelmet");
			break;
		case 1:
			this.setUnlocalizedName("itemArmorRadiationSuitChestplate");
			break;
		case 2:
			this.setUnlocalizedName("itemArmorRadiationSuitLeggings");
			break;
		case 3:
			this.setUnlocalizedName("itemArmorRadiationSuitBoots");
			break;
		}
		
		this.setCreativeTab(CreativeTabs.tabCombat);
		
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if(slot==0||slot==1||slot==3){
			return CaveWorld.MODID +":textures/models/armor/radiation_suit_1.png";
		}else{
			return CaveWorld.MODID +":textures/models/armor/radiation_suit_2.png";
		}
	}
	
}
