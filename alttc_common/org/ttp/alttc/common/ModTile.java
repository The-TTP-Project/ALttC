package org.ttp.alttc.common;

import org.ttp.alttc.common.tile.TileDeception;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModTile {
	
	public static void init()
	{
		GameRegistry.registerTileEntity(TileDeception.class, "deceptionBlock");
	}

}
