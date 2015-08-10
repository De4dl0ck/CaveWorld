package de.maxhenkel.caveworld.worldgen;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderCaveWorld extends WorldProvider{

	private BlockPos spawnPoint;
	
	public WorldProviderCaveWorld() {
		super();
		this.spawnPoint=new BlockPos(0, 50, 0);
	}
	
	@Override
	protected void registerWorldChunkManager() {
		super.registerWorldChunkManager();
		this.worldChunkMgr=new WorldChunkManagerHell(Biomes.CAVEBIOME, 0.0F);
		
		this.hasNoSky=true;
		worldObj.setSpawnPoint(spawnPoint);
	}
	
	@Override
	public String getDimensionName() {
		return "Caveworld";
	}
	
	@Override
	public boolean isSurfaceWorld() {
		return false;
	}

	@Override
	public String getInternalNameSuffix() {
		return "";
	}
	
	@Override
	public boolean getHasNoSky() {
		return true;
	}
	
	@Override
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderCave(this.worldObj, getSeed(), true, "");
	}
	
	@Override
	public BiomeGenBase getBiomeGenForCoords(BlockPos pos) {
		return Biomes.CAVEBIOME;
	}
	
	@Override
	public double getMovementFactor() {
		return 1.0D;
	}
	
	@Override
	public boolean canDoLightning(Chunk chunk) {
		return false;
	}
	
	@Override
	public BlockPos getRandomizedSpawnPoint() {
		
		return this.spawnPoint.add(1, 0, 1);
	}
	
	@Override
	public BlockPos getSpawnPoint() {
		return this.spawnPoint;
	}

}
