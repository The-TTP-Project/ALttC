package org.ttp.alttc.common.entity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class EntityHeart extends EntityItem {

	public EntityHeart(World par1World, double par2, double par4, double par6,
			ItemStack par8ItemStack) {
		super(par1World, par2, par4, par6, par8ItemStack);
		
		this.delayBeforeCanPickup = 40;
	}
	
	@Override
	public void onUpdate() {
		delayBeforeCanPickup--;
		
		super.onUpdate();
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer player) {
		
		if (this.delayBeforeCanPickup > 0)
			return;
		
		for (ItemStack stack : player.inventory.mainInventory)
		{
			if (stack == null)
				break;
			
			player.heal(2.0F);
			
			this.setDead();
			return;
		}
		
		super.onCollideWithPlayer(player);
			
	}

}
