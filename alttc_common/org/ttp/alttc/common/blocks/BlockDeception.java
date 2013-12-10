package org.ttp.alttc.common.blocks;

import org.ttp.alttc.ALttC;
import org.ttp.alttc.common.tile.TileDeception;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockDeception extends BlockTTP{
	
	private int side;
	
	public BlockDeception(int id, Material material, String name) {
		super(id, material, name);
	}

	@Override
	public boolean onBlockEventReceived(World world, int x, int y,
			int z, int par5, int par6) {
		System.out.println("event received");
		this.side = ((TileDeception)world.getBlockTileEntity(x, y, z)).getSide();
		world.scheduleBlockUpdateWithPriority(x, y, z, 1, 1, 1);
		return false;
	}
	@Override
	public int getRenderType() {
		return ALttC.deceptionRenderer;
	}
	
	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}
	
	@Override
	public boolean isBlockSolidOnSide(World world, int x, int y, int z,
			ForgeDirection side) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube() {	
		return false;		
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public boolean isBlockSolid(IBlockAccess par1iBlockAccess, int par2,
			int par3, int par4, int par5) {
		return false;
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
		
		return te instanceof TileDeception ? ((TileDeception)te).getIcon(par5) : null;
	}
}
