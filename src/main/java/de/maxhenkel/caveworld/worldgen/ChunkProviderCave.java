package de.maxhenkel.caveworld.worldgen;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType;
import net.minecraftforge.event.terraingen.TerrainGen;

public class ChunkProviderCave extends ChunkProviderGenerate {

	private World worldIn;
	
	public ChunkProviderCave(World worldIn, long p_i45636_2_, boolean p_i45636_4_, String p_i45636_5_) {
		super(worldIn, p_i45636_2_, p_i45636_4_, p_i45636_5_);
		this.worldIn=worldIn;
	}

	@Override
	public void setBlocksInChunk(int chunkX, int chunkZ, ChunkPrimer primer) {
		for (int x = 0; x < 16; x++) {
		      for (int z = 0; z < 16; z++) {
		        for (int y = 0; (y < 128); y++){
		          
		        	primer.setBlockState(x, y, z, Blocks.stone.getDefaultState());
		        	
		        }
		        	/*primer.setBlockState(x, 137, z, Blocks.dirt.getDefaultState());
		        	primer.setBlockState(x, 136, z, Blocks.dirt.getDefaultState());
		        	primer.setBlockState(x, 135, z, Blocks.dirt.getDefaultState());
		        	primer.setBlockState(x, 134, z, Blocks.dirt.getDefaultState());
		        	primer.setBlockState(x, 133, z, Blocks.dirt.getDefaultState());
		        	primer.setBlockState(x, 132, z, Blocks.dirt.getDefaultState());
		        	*/
		        	//primer.setBlockState(x, 128, z, Blocks.bedrock.getDefaultState());
		        	//primer.setBlockState(x, 128, z, Blocks.dirt.getDefaultState());
		      }
		    }
		
		
		
	}
	
	/*@Override
	public void func_180517_a(int chunkX, int chunkZ, ChunkPrimer primer, BiomeGenBase[] p_180517_4_) {
		//super.func_180517_a(chunkX, chunkZ, primer, p_180517_4_);
		for (int x = 0; x < 16; x++) {
		      for (int z = 0; z < 16; z++) {
		        for (int y = 0; (y < 128); y++){
		          
		        	primer.setBlockState(x, y, z, Blocks.stone.getDefaultState());
		        	
		        }
		        	primer.setBlockState(x, 128, z, Blocks.bedrock.getDefaultState());
		        	primer.setBlockState(x, 129, z, Blocks.bedrock.getDefaultState());
		      }
		    }
	}*/
	
	@Override
	public void populate(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {
		super.populate(p_73153_1_, p_73153_2_, p_73153_3_);
		Random rand=new Random();
		
		int k = p_73153_2_ * 16;
        int l = p_73153_3_ * 16;
        BlockPos blockpos = new BlockPos(k, 0, l);
		
		int k1 = rand.nextInt(16) + 8;
		int l1 = rand.nextInt(rand.nextInt(248) + 8);
		int i2 = rand.nextInt(16) + 8;
		
		boolean doGen = TerrainGen.populate(p_73153_1_, worldIn, rand, p_73153_2_, p_73153_3_, false, EventType.DUNGEON);
        for (k1 = 0; doGen && k1 < 100/*chance*/; ++k1)
        {
            l1 = rand.nextInt(16) + 8;
            i2 = rand.nextInt(256);
            int j2 = rand.nextInt(16) + 8;
            (new WorldGenDungeons()).generate(this.worldIn, rand, blockpos.add(l1, i2, j2));
        }
	}

}
