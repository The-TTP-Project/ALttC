package org.ttp.alttc.common.entity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class EntityHeart extends EntityItem {

	private ItemStack itemstack;
	
	public EntityHeart(World par1World, double par2, double par4, double par6,
			ItemStack stack) {
		super(par1World, par2, par4, par6, stack);
		this.delayBeforeCanPickup = 40;
		itemstack = stack;
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
		else
		{		
			player.heal(2.0F);
			if (itemstack.stackSize > 1) 
				itemstack.stackSize--; 
			else this.setDead();
			delayBeforeCanPickup = 5;
			return;
		}			
	}

}
