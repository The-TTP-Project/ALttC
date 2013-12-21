package org.ttp.alttc.client.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;
import org.ttp.alttc.ALttC;
import org.ttp.alttc.common.ModBlocks;
import org.ttp.alttc.common.blocks.BlockDeception;
import org.ttp.alttc.common.core.handlers.ConfigHandler;
import org.ttp.alttc.common.tile.TileDeception;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class DeceptionRenderer implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		Icon icon = ModBlocks.deceptionBlock.getIcon(0, 0);
		Tessellator tessellator = Tessellator.instance;
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F); // Set angled view
		tessellator.startDrawingQuads();

		// Y-
		tessellator.setNormal(0.0F, -1.0F, 0.0F);
		renderer.renderFaceYNeg(block, 0, 0, 0, icon);

		// Y+
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		renderer.renderFaceYPos(block, 0, 0, 0, icon);

		// X+
		tessellator.setNormal(0.0F, 0.0F, -1.0F);
		renderer.renderFaceXPos(block, 0, 0, 0, icon);

		// X-
		tessellator.setNormal(0.0F, 0.0F, 1.0F);
		renderer.renderFaceXNeg(block, 0, 0, 0, icon);

		// Z-
		tessellator.setNormal(-1.0F, 0.0F, 0.0F);
		renderer.renderFaceZNeg(block, 0, 0, 0, icon);

		// Z+
		tessellator.setNormal(1.0F, 0.0F, 0.0F);
		renderer.renderFaceZPos(block, 0, 0, 0, icon);

		GL11.glTranslatef(0.5F, 0.5F, 0.5F); // Reset angled view
		tessellator.draw();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {

		world.getBlockTileEntity(x, y, z).worldObj.addBlockEvent(x, y, z,
				ConfigHandler.deceptionBlock, 0, 0);
		TileDeception te = (TileDeception) world.getBlockTileEntity(x,y,z);
		Block TEblock = te.block;

		if (TEblock instanceof BlockDeception)
			renderer.renderStandardBlock(TEblock, x, y, z);
		else if (TEblock == null)
		{
			renderer.setOverrideBlockTexture(ModBlocks.deceptionBlock.getIcon(0, 0));
			renderer.renderStandardBlock(Block.stone, x, y, z);
			renderer.clearOverrideBlockTexture();
		}
		else			
			// Condensed if-else to avoid NPE in RenderBlocks
			renderer.renderBlockByRenderType(TEblock == null ? Block.stone
					: TEblock, x, y, z);

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
