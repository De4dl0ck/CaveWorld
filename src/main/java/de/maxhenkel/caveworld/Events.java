package de.maxhenkel.caveworld;

import java.util.Random;

import de.maxhenkel.caveworld.armor.ItemRadiationSuit;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Events {
	
	@SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event){
		World world = (World)event.world;
        if (world.isRemote || !(world.provider.getDimensionId()==0) || world.getTotalWorldTime()!=0){
        	return;
        }
        
		for(int x=-3; x<4; x++){
			for(int z=-3; z<4; z++){
				for(int y=0; y<8; y++){
					world.setBlockState(new BlockPos(x, 50+y, z), Blocks.air.getDefaultState());
				}
				world.setBlockState(new BlockPos(x, 49, z), Blocks.dirt.getDefaultState());
			}
		}
		
		world.setBlockState(new BlockPos(1, 50, 1), Blocks.torch.getDefaultState());
		world.setBlockState(new BlockPos(-1, 50, -1), Blocks.torch.getDefaultState());
		
		
		
		world.setBlockState(new BlockPos(0, 55, 0), Blocks.leaves.getDefaultState());
		for(int x=-1; x<2; x++){
			for(int z=-1; z<2; z++){
				world.setBlockState(new BlockPos(x, 54, z), Blocks.leaves.getDefaultState());
			}
		}
		
		for(int x=-2; x<3; x++){
			for(int z=-2; z<3; z++){
				world.setBlockState(new BlockPos(x, 53, z), Blocks.leaves.getDefaultState());
				
				world.setBlockState(new BlockPos(x, 52, z), Blocks.leaves.getDefaultState());
			}
		}
		
		world.setBlockState(new BlockPos(0, 50, 0), Blocks.log.getDefaultState());
		world.setBlockState(new BlockPos(0, 51, 0), Blocks.log.getDefaultState());
		world.setBlockState(new BlockPos(0, 52, 0), Blocks.log.getDefaultState());
		world.setBlockState(new BlockPos(0, 53, 0), Blocks.log.getDefaultState());
		world.setBlockState(new BlockPos(0, 54, 0), Blocks.log.getDefaultState());
		
		//WorldGenTrees tree=new WorldGenTrees(true, 5, 0, 0, false);
        //tree.generate(world, new Random(), new BlockPos(0, 50, 0));
    }
	

	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event){
		
		if (!(event.entityLiving instanceof EntityPlayer)){
			return;
		}
		
		EntityPlayer player = (EntityPlayer) event.entityLiving;
		World world=player.worldObj;
		
		if(player.getPosition().getY()>126 || world.canBlockSeeSky(player.getPosition())){
			if(player.dimension==0){
				if((player.inventory.armorInventory[0]==null || player.inventory.armorInventory[1]==null || player.inventory.armorInventory[2]==null || player.inventory.armorInventory[3]==null) || !(player.inventory.armorInventory[0].getItem() instanceof ItemRadiationSuit && player.inventory.armorInventory[1].getItem() instanceof ItemRadiationSuit && player.inventory.armorInventory[2].getItem() instanceof ItemRadiationSuit && player.inventory.armorInventory[3].getItem() instanceof ItemRadiationSuit)){
					player.addPotionEffect(new PotionEffect(CaveWorld.radiation.id, 210, 0));
				}
			}
		}
		
		if (player.isPotionActive(CaveWorld.radiation) && world.rand.nextInt(20)==0){
			player.attackEntityFrom(CaveWorld.radiationDamageSource, 1.0F);
		}
		
		
	}
	
	/*@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onEntityUpdateSP(LivingUpdateEvent event){
		if (!(event.entityLiving instanceof EntityPlayerSP)){
			return;
		}
		
		EntityPlayerSP player = (EntityPlayerSP) event.entityLiving;
		
		if (player.isPotionActive(CaveWorld.radiation)){
			player.timeInPortal += 0.006666667F;

            if (player.timeInPortal > 1.0F){
            	player.timeInPortal = 1.0F;
            }
			
            GlStateManager.rotate(0.5F, 0.0F, 1.0F, 1.0F);
            GlStateManager.scale(2.0F, 1.0F, 1.0F);
            GlStateManager.rotate(-0.5F, 0.0F, 1.0F, 1.0F);
        
			
			
			
			
		}
	}*/
	
}
