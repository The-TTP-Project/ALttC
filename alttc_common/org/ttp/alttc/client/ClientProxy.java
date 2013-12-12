package org.ttp.alttc.client;

import org.ttp.alttc.ALttC;
import org.ttp.alttc.CommonProxy;
import org.ttp.alttc.client.renderer.DeceptionRenderer;
import org.ttp.alttc.client.renderer.RenderKeese;
import org.ttp.alttc.common.core.handlers.ConfigHandler;
import org.ttp.alttc.common.entity.EntityKeese;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {

	@Override
	public void runClientSide(){
		initRender();
		initItemRenderer();
	}
	public void initItemRenderer() {
		if (ConfigHandler.renderMasterSword) {
//			MinecraftForgeClient.registerItemRenderer(ModItems.masterSword.itemID, new ItemMasterSwordRenderer());
		}
	}

	private static void initRender()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityKeese.class, new RenderKeese());
		RenderingRegistry.registerBlockHandler(ALttC.deceptionRenderer, new DeceptionRenderer());
	}
}
