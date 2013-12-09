package org.ttp.alttc.common.item;

import org.ttp.alttc.common.entity.EntityHeart;
import org.ttp.alttc.common.lib.ItemIds;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHeart extends ItemTTP {

	public ItemHeart(int id, String name) {
		super(id, name);
	}

	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World,
			Entity entity, int par4, boolean par5) {

		if (entity instanceof EntityPlayer) {
			System.out.println(ItemIds.ITEM_HEART);
			((EntityPlayer) entity).inventory
					.consumeInventoryItem(ItemIds.ITEM_HEART + 256);
			
			((EntityPlayer) entity).heal(2.0F);
		}
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
