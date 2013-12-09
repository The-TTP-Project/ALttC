package org.ttp.alttc.client;

import org.ttp.alttc.CommonProxy;
import org.ttp.alttc.client.render.RenderKeese;
import org.ttp.alttc.common.entity.EntityKeese;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {

	@Override
	public void runClientSide(){
		initRender();
	}

	private static void initRender()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityKeese.class, new RenderKeese());
	}
}
