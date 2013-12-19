package org.ttp.alttc.common.handlers;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import org.ttp.alttc.common.ModItems;

public class HandlerTunic {
	@ForgeSubscribe
	public void Handler_LivingUpdate(LivingUpdateEvent fEvent)
	{
		if(!(fEvent.entity instanceof EntityPlayer))
			return;
		
		// We know this is an EntityLivingBase at least already
		EntityLivingBase entity = (EntityLivingBase)fEvent.entity;
		ItemStack tunic = entity.getCurrentItemOrArmor(3);
			
		if(tunic == null)
			return;
		
		// Zora Tunic gives waterbreathing
		if(tunic.getItem() == ModItems.tunicZora && entity.isInWater())
			entity.setAir(300);

		// Goron Tunic prevents Fire
		if(tunic.getItem() == ModItems.tunicGoron)
			entity.extinguish();
	}
	
	@ForgeSubscribe
	public void Handler_LivingHurt(LivingHurtEvent fEvent)
	{
		if(!(fEvent.entity instanceof EntityPlayer))
			return;

		EntityLivingBase entity = (EntityLivingBase)fEvent.entity;
		ItemStack tunic = entity.getCurrentItemOrArmor(3);
		
		if(tunic == null)
			return;
		
		// Check if they're wearing the goron tunic.
		if(tunic.getItem() == ModItems.tunicGoron)
			fEvent.setCanceled(true);
		
	}
}
