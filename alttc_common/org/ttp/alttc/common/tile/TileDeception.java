package org.ttp.alttc.common.tile;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;

import org.ttp.alttc.common.blocks.BlockDeception;

public class TileDeception extends TileEntity {
	
	private Icon icon;
	private int side;
	
	public TileDeception(int side)
	{
		this.side = side;
	}
	
	@Override
	public void updateEntity() {
		if (icon == null)
		{
			int x = xCoord, y = yCoord, z = zCoord;
			Block block;
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
			findIcon(x, y, z);
		}
	}
	
	private void findIcon(int x, int y, int z)
	{
		Block block;
		block = Block.blocksList[worldObj.getBlockId(x, y, z)];
		if (block instanceof BlockDeception)
			icon = ((TileDeception)worldObj.getBlockTileEntity(x, y, z)).getIcon();
		else if (block == null)
			icon = Block.stone.getIcon(0, 0);
		else
			icon = block.getIcon(0, 0);
	}
	
	public Icon getIcon()
	{
		return icon;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		
		compound.setByte("side", ((byte)side));
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		
		this.side = compound.getByte("side");
	}
}
