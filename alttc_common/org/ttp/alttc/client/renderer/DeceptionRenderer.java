package org.ttp.alttc.client.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

import org.ttp.alttc.ALttC;
import org.ttp.alttc.common.blocks.BlockDeception;
import org.ttp.alttc.common.core.handlers.ConfigHandler;
import org.ttp.alttc.common.tile.TileDeception;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class DeceptionRenderer implements ISimpleBlockRenderingHandler{
		
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {

		world.getBlockTileEntity(x, y, z).worldObj.addBlockEvent(x, y, z, ConfigHandler.deceptionBlock, 0, 0);
		Block TEblock = ((TileDeception)world.getBlockTileEntity(x, y, z)).block;
		
		// Condensed if-else to avoid NPE in RenderBlocks
		if (!(TEblock instanceof BlockDeception))
			renderer.renderBlockByRenderType(TEblock == null ? Block.stone : TEblock, x, y, z);
		else
			renderer.renderStandardBlock(TEblock, x, y, z);
		
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		// TODO Auto-generated method stub
		return ALttC.deceptionRenderer;
	}

}
