package org.ttp.alttc.common.entity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class EntityHeart extends EntityItem {

	public EntityHeart(World par1World, double par2, double par4, double par6,
			ItemStack par8ItemStack) {
		super(par1World, par2, par4, par6, par8ItemStack);
	}
	
	@Override
	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer) {
		
		par1EntityPlayer.heal(1.0F);
	}

}
