package org.ttp.alttc.common.handlers;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import org.ttp.alttc.common.items.ItemHeart;
import org.ttp.alttc.common.lib.ItemIds;

public class PickupHandler {
	
	@ForgeSubscribe
	public void HandleItemPickup(EntityItemPickupEvent event)
	{
		if (event.item.getEntityItem().getItem() instanceof ItemHeart)
			event.entityPlayer.inventory.clearInventory(ItemIds.ITEM_HEART, 0);
	}

}
