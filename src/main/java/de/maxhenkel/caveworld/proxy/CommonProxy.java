package de.maxhenkel.caveworld.proxy;

import de.maxhenkel.caveworld.CaveWorld;
import de.maxhenkel.caveworld.Events;
import de.maxhenkel.caveworld.potions.PotionRadiation;
import de.maxhenkel.caveworld.worldgen.WorldProviderCaveWorld;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy{
  
  public void preinit(FMLPreInitializationEvent event){
		
  }
  
  public void init(FMLInitializationEvent event){
  	
	  CaveWorld.radiation =new PotionRadiation(24, new ResourceLocation("radiation"), true, 0x00B800).setIconIndex(7, 1); 
	  
	  DimensionManager.unregisterProviderType(0);
	  DimensionManager.registerProviderType(0, WorldProviderCaveWorld.class, true);
	  MinecraftForge.EVENT_BUS.register(new Events());
	  
	  ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(Blocks.sapling, 1, 0), 2, 7, 3));
	  ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(Blocks.sapling, 1, 1), 2, 7, 3));
	  ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(Blocks.sapling, 1, 2), 2, 7, 3));
	  ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(Blocks.sapling, 1, 3), 2, 7, 3));
	  ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(Blocks.sapling, 1, 4), 2, 7, 3));
	  ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(Blocks.sapling, 1, 5), 2, 7, 3));
	  
	  ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Blocks.sapling, 1, 0), 2, 7, 3));
	  ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Blocks.sapling, 1, 1), 2, 7, 3));
	  ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Blocks.sapling, 1, 2), 2, 7, 3));
	  ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Blocks.sapling, 1, 3), 2, 7, 3));
	  ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Blocks.sapling, 1, 4), 2, 7, 3));
	  ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Blocks.sapling, 1, 5), 2, 7, 3));
	  
	  ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Blocks.cocoa), 4, 7, 3));
	  ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Blocks.cactus), 2, 8, 5));
	  ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Items.melon_seeds), 4, 7, 3));
	  ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(Items.pumpkin_seeds), 4, 7, 3));
	  
	  registerItem(CaveWorld.radiationSuitHelmet);
	  registerItem(CaveWorld.radiationSuitChestplate);
	  registerItem(CaveWorld.radiationSuitLeggins);
	  registerItem(CaveWorld.radiationSuitBoots);

	  //Recipes
	  GameRegistry.addRecipe(new ItemStack(Blocks.grass, 1), new Object[]{
				"G",
				"D",
				Character.valueOf('G'),
				Blocks.tallgrass,
				Character.valueOf('D'),
				Blocks.dirt
	  });
	  
	  GameRegistry.addRecipe(new ItemStack(CaveWorld.radiationSuitHelmet), new Object[]{
				"RRR",
				"RHR",
				"LGL",
				Character.valueOf('R'),
				Items.redstone,
				Character.valueOf('H'),
				Items.iron_helmet,
				Character.valueOf('L'),
				Items.glowstone_dust,
				Character.valueOf('G'),
				Blocks.glass
	  });
	  
	  GameRegistry.addRecipe(new ItemStack(CaveWorld.radiationSuitChestplate), new Object[]{
				"RGR",
				"RHR",
				"GGG",
				Character.valueOf('R'),
				Items.redstone,
				Character.valueOf('H'),
				Items.iron_chestplate,
				Character.valueOf('G'),
				Items.glowstone_dust
	  });
	  
	  GameRegistry.addRecipe(new ItemStack(CaveWorld.radiationSuitLeggins), new Object[]{
				"RGR",
				"RHR",
				"GRG",
				Character.valueOf('R'),
				Items.redstone,
				Character.valueOf('H'),
				Items.iron_leggings,
				Character.valueOf('G'),
				Items.glowstone_dust
	  });
	  
	  GameRegistry.addRecipe(new ItemStack(CaveWorld.radiationSuitBoots), new Object[]{
				"GRG",
				"RHR",
				"RRR",
				Character.valueOf('R'),
				Items.redstone,
				Character.valueOf('H'),
				Items.iron_boots,
				Character.valueOf('G'),
				Items.glowstone_dust
	  });
  	
  }
  
  public void postinit(FMLPostInitializationEvent event){
		
  }
  
  private void registerItem(Item i){
	  GameRegistry.registerItem(i, i.getUnlocalizedName().replace("item.", ""));
  }
  
  private void registerBlock(Block b){
	  GameRegistry.registerBlock(b, b.getUnlocalizedName().replace("tile.", ""));
  }
  
}

