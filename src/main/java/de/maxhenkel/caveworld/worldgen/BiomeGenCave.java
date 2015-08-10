package de.maxhenkel.caveworld.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenHell;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class BiomeGenCave extends BiomeGenBase{

	public BiomeGenCave(int par1) {
		super(par1);
		this.setBiomeName("CaveBiome");
		this.setDisableRain();
		topBlock=Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.PODZOL);
		theBiomeDecorator.deadBushPerChunk=100;
		theBiomeDecorator.grassPerChunk=1;
		theBiomeDecorator.flowersPerChunk=1;
		
		this.setHeight(new Height(128, 133));
		
	}
	
	@Override
	public void decorate(World world, Random rand, BlockPos pos) {
		super.decorate(world, rand, pos);
	}
	
	@Override
	public int getSkyColorByTemp(float par1) {
		return  0xB24747;
	}
	
	@Override
	public int getFoliageColorAtPos(BlockPos pos) {
		return 0x3D2914;
	}
	
	@Override
	public int getWaterColorMultiplier() {
		return 0x003D00;
	}
	
}
