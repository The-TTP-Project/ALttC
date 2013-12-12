package org.ttp.alttc.common.blocks;

import org.ttp.alttc.ALttC;
import org.ttp.alttc.common.lib.Reference;
import org.ttp.alttc.common.tile.TileDeception;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockDeception extends BlockTTP{
	
	private int side, meta;
	private Icon icon;
	
	public BlockDeception(int id, Material material, String name) {
		super(id, material, name);
	}
	
	@Override
	public void registerIcons(IconRegister register) {
		this.blockIcon = register.registerIcon(Reference.MOD_ID + ":deceptionBlock");
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
		this.meta = world.getBlockMetadata(x, y, z);
		return super.onBlockPlaced(world, x, y, z, side, par6, par7, par8,
				par9);
	}
	
	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		return new TileDeception(side, meta);
	}
	
	@Override
	public Icon getBlockTexture(IBlockAccess par1iBlockAccess, int par2,
			int par3, int par4, int par5) {
		TileEntity te = par1iBlockAccess.getBlockTileEntity(par2, par3, par4);
		
		icon =  te instanceof TileDeception ? ((TileDeception)te).getIcon(par5) : this.blockIcon;
		return icon;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World,
			int par2, int par3, int par4) {
		return null;
	}
}
