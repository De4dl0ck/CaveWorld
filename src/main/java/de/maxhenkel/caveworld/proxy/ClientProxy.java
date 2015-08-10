package de.maxhenkel.caveworld.proxy;

import de.maxhenkel.caveworld.CaveWorld;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ClientProxy extends CommonProxy{
 
	public void preinit(FMLPreInitializationEvent event) {
		super.preinit(event);
	}
	
	public void init(net.minecraftforge.fml.common.event.FMLInitializationEvent event) {
		super.init(event);
		addRenderItem(CaveWorld.radiationSuitHelmet);
		addRenderItem(CaveWorld.radiationSuitChestplate);
		addRenderItem(CaveWorld.radiationSuitLeggins);
		addRenderItem(CaveWorld.radiationSuitBoots);
	}
	
	public void postinit(FMLPostInitializationEvent event) {
		super.postinit(event);
	}
	
	private void addRenderItem(Item i){
		String name=i.getUnlocalizedName().replace("item.", "");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(i, 0, new ModelResourceLocation(CaveWorld.MODID +":" +name, "inventory"));
	}
	
	private void addRenderBlock(Block b){
		String name=b.getUnlocalizedName().replace("tile.", "");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(b), 0, new ModelResourceLocation(CaveWorld.MODID +":" +name, "inventory"));
	}

}
