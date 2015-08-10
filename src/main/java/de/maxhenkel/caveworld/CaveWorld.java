package de.maxhenkel.caveworld;

import de.maxhenkel.caveworld.armor.ItemRadiationSuit;
import de.maxhenkel.caveworld.proxy.CommonProxy;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = CaveWorld.MODID, version = CaveWorld.VERSION)
public class CaveWorld {

	public static final String MODID = "caveworld";
    public static final String VERSION = "1.0";
    
    public static Potion radiation;
    public static ArmorMaterial radiationSuitMaterial=EnumHelper.addArmorMaterial("radiationSuitMaterial", "", 16, new int[]{3, 5, 4, 3}, 3);
    
    public static DamageSource radiationDamageSource=new DamageSourceRadiation();
    
    public static ItemArmor radiationSuitHelmet=new ItemRadiationSuit(radiationSuitMaterial, 0, 0);
    public static ItemArmor radiationSuitChestplate=new ItemRadiationSuit(radiationSuitMaterial, 0, 1);
    public static ItemArmor radiationSuitLeggins=new ItemRadiationSuit(radiationSuitMaterial, 0, 2);
    public static ItemArmor radiationSuitBoots=new ItemRadiationSuit(radiationSuitMaterial, 0, 3);
    
    @Instance
    public static CaveWorld instance;
	
    @SidedProxy(clientSide="de.maxhenkel.caveworld.proxy.ClientProxy", serverSide="de.maxhenkel.caveworld.proxy.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event){
		instance=this;
		proxy.preinit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
    	 proxy.init(event);
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event){
		proxy.postinit(event);
    }
    
    
}
