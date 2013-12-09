package org.ttp.alttc.common.handlers;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

import org.ttp.alttc.common.ModItems;
import org.ttp.alttc.common.entity.EntityHeart;
import org.ttp.alttc.common.lib.ItemIds;

public class HarvestHandler {
	
	@ForgeSubscribe
	public void onHarvestDrop(HarvestDropsEvent event)
	{
		if (event.block.blockID == Block.tallGrass.blockID && !event.world.isRemote)
		{
			Random rand = new Random();
			if (rand.nextInt(100) >= 90)
				event.world.spawnEntityInWorld(new EntityHeart(event.world, event.x, event.y, event.z, new ItemStack(ModItems.itemHeart)));
		}
	}
}
