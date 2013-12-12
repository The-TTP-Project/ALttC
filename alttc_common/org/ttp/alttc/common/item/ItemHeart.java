	package org.ttp.alttc.common.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import org.ttp.alttc.common.entity.EntityHeart;

public class ItemHeart extends ItemTTP {
	public ItemHeart(int id, String name) {
		super(id, name, false);
	}

	@Override
	public Entity createEntity(World world, Entity location, ItemStack itemstack) {
		
		return new EntityHeart(world, location.posX, location.posY, location.posZ, itemstack);
	}
	
	@Override
	public boolean hasCustomEntity(ItemStack stack) {
		return true;
	}
}
