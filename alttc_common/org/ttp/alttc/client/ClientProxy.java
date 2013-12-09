package org.ttp.alttc.client;

import net.minecraftforge.client.MinecraftForgeClient;

import org.ttp.alttc.client.renderer.ItemMasterSwordRenderer;
import org.ttp.alttc.common.ModItems;
import org.ttp.alttc.common.lib.Reference;
import org.ttp.alttc.CommonProxy;
import org.ttp.alttc.client.renderer.RenderKeese;
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
		if (Reference.USE_MASTER_SWORD_MODEL) {
//			MinecraftForgeClient.registerItemRenderer(ModItems.masterSword.itemID, new ItemMasterSwordRenderer());
		}
	}

	private static void initRender()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityKeese.class, new RenderKeese());
	}
}
