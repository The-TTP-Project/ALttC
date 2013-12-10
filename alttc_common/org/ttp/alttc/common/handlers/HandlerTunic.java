package org.ttp.alttc.common.handlers;

import java.util.UUID;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import org.ttp.alttc.common.item.ItemTunicBlue;
import org.ttp.alttc.common.item.ItemTunicRed;

public class HandlerTunic {
	public static UUID zoraTunicUUID = UUID.fromString("8F639D59-4E7D-4FE8-96FC-099C8203CF63");
	
	@ForgeSubscribe
	public void Handler_LivingUpdate(LivingUpdateEvent fEvent)
	{
		if(!(fEvent.entity instanceof EntityPlayer))
			return;
		
		// We know this is an EntityLivingBase at least already
		EntityLivingBase entity = (EntityLivingBase)fEvent.entity;
		ItemStack tunic = entity.getCurrentItemOrArmor(1);
			
		if(tunic == null)
			return;
		
		// Zora Tunic gives waterbreathing
		if(tunic.getItem() instanceof ItemTunicBlue && entity.isInWater())
			entity.setAir(300);

		// Goron Tunic prevents Fire
		if(tunic.getItem() instanceof ItemTunicRed)
			entity.extinguish();
	}
	
	@ForgeSubscribe
	public void Handler_LivingHurt(LivingHurtEvent fEvent)
	{
		if(!(fEvent.entity instanceof EntityPlayer))
			return;

		EntityLivingBase entity = (EntityLivingBase)fEvent.entity;
		ItemStack tunic = entity.getCurrentItemOrArmor(1);
		
		if(tunic == null)
			return;
		
		// Check if they're wearing the goron tunic.
		if(tunic.getItem() instanceof ItemTunicRed)
			fEvent.setCanceled(true);
	}
}
