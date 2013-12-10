package org.ttp.alttc.common.blocks;

import org.ttp.alttc.ALttC;
import org.ttp.alttc.common.tile.TileDeception;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDeception extends BlockTTP{
	
	private int side;
	
	public BlockDeception(int id, Material material, String name) {
		super(id, material, name);
	}
	
	@Override
	public int getRenderType() {
		return 0;//ALttC.deceptionRenderer;
	}
	
	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}
	
	@Override
	public int onBlockPlaced(World world, int x, int y, int z,
			int side, float par6, float par7, float par8, int par9) {
		this.side = side;
		return super.onBlockPlaced(world, x, y, z, side, par6, par7, par8,
				par9);
	}
	
	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		return new TileDeception(side);
	}
	
	@Override
	public Icon getBlockTexture(IBlockAccess par1iBlockAccess, int par2,
			int par3, int par4, int par5) {
		TileEntity te = par1iBlockAccess.getBlockTileEntity(par2, par3, par4);
		
		return te instanceof TileDeception ? ((TileDeception)te).getIcon() : null;
	}
}
