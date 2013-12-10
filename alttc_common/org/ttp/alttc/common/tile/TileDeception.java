package org.ttp.alttc.common.tile;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;

import org.ttp.alttc.common.blocks.BlockDeception;

import cpw.mods.fml.common.FMLCommonHandler;

public class TileDeception extends TileEntity {
	
	private Icon[] icon;
	private int side, renderID;
	public Block block;
	private boolean hasRead;
	
	// The counter to ASSURE the texture updates on world load
	private int counter = 100;
	
	public TileDeception() {}
	
	public TileDeception(int side)
	{
		this.side = side;
	}
	
	@Override
	public void updateEntity() {
		System.out.println(side);
		if(FMLCommonHandler.instance().getEffectiveSide().isServer() && (icon == null || (counter > 0 && this.icon[0] == Block.stone.getIcon(0, 0)))){
			icon = new Icon[6];
			int x = xCoord, y = yCoord, z = zCoord;
			switch(side)
			{
			case 0:
				y++;
				break;
			case 1: 
				y--;
				break;
			case 2: 
				z++;
				break;
			case 3:
				z--;
				break;
			case 4: 
				x++;
				break;
			case 5:
				x--;
				break;
			}
			counter--;
			findIconsAndRender(x, y, z);
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			
		}
	}
	
	private Icon[] findIconsAndRender(int x, int y, int z)
	{
		block = Block.blocksList[worldObj.getBlockId(x, y, z)];
		if (block instanceof BlockDeception)
		{
			TileDeception te = (TileDeception) worldObj.getBlockTileEntity(x, y, z);
			icon = te.getIconArray();
			renderID = te.getRenderID();
			block = te.block;
		}
		else if (block == null)
		{
			for (int i = 0; i < 6; i++)
				icon[i] = Block.stone.getIcon(0, 0);
			
			renderID = 0;
		}
		else
		{
			for (int i = 0; i < 6; i++)
				icon[i] = block.getBlockTexture(worldObj, x, y, z, i);
			
			renderID = block.getRenderType();
		}
		
		return icon;
	}
	
	public Icon getIcon(int side)
	{
		return icon == null ? Block.stone.getIcon(0, 0) : icon[side];
	}
	
	private Icon[] getIconArray()
	{
		return icon;
	}
	
	public int getRenderID()
	{
		return renderID;
	}
	
	public int getSide()
	{
		return side;
	}
	
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		compound.setByte("side", ((byte)side));
		super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.side = compound.getByte("side");
	}
}
