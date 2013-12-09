package org.ttp.alttc.common;

import org.ttp.alttc.ALttC;
import org.ttp.alttc.common.entity.EntityKeese;

import cpw.mods.fml.common.registry.EntityRegistry;

public class ModEntities
{
	public static void init()
	{
		regEntity();
		regSpawn();
	}
	
	private static void regEntity()
	{
		//EntityRegistry.registerModEntity(EntityKeese.class, "keese", 0, ALttC.instance, 16, 1, true);
	}

	private static void regSpawn()
	{
		EntityRegistry.registerGlobalEntityID(EntityKeese.class, "keese", EntityRegistry.findGlobalUniqueEntityId(), 0, 1);
	}
}
