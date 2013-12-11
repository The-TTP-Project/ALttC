package org.ttp.alttc.common.handlers;

import java.util.List;
import java.util.UUID;

import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.WatchableObject;
import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import org.ttp.alttc.common.ModItems;

public class HandlerBoots {
	public static UUID pegasusUUID = UUID.fromString("F0E1A360-6228-11E3-949A-0800200C9A66");
			
	@ForgeSubscribe
	public void Handler_LivingUpdate(LivingUpdateEvent fEvent)
	{
		if(!(fEvent.entity instanceof EntityPlayer))
			return;
		
		// We know this is an EntityLivingBase at least already
		EntityLivingBase entity = (EntityLivingBase)fEvent.entity;
		ItemStack boots = entity.getCurrentItemOrArmor(0);
		//ItemStack boots = entity.getCurrentItemOrArmor(1);
		
		if(boots == null)
			return;
		
		DataWatcher entityData = entity.getDataWatcher();
		
		/* Safety Checking */
		// Make sure we're safely affecting the hover ticks value of this entity.
		boolean bitsafe = false;
		@SuppressWarnings("unchecked")
		List<WatchableObject> watched = entityData.getAllWatched();
		for(WatchableObject obj : watched)
		{
			if(obj.getDataValueId() == 24)
			{
				bitsafe = true;
				break;
			}
		}
		// Our necessary value isn't there, add it.
		if(!bitsafe)
			entityData.addObject(24, Integer.valueOf(0));
		/* Safety Checking */
		
		// Hover boots
		if(boots.getItem() == Item.blazeRod)
		//if(boots.getItem() == ModItems.bootsHover)
		{
			// Check if they're in the air.
			((EntityPlayer)entity).addChatMessage("Hover Ticks: " + entityData.getWatchableObjectInt(24));
			if(!entity.onGround)
			{
				// Check for jumps because the event seems to be derpy.
				if(entity.motionY > 0)
					entityData.updateObject(24, 0);
				
				if(entityData.getWatchableObjectInt(24) > 0)
				{
					// Bump them up a little if this their first falling tick only.
					if(entityData.getWatchableObjectInt(24) == 30)
						entity.posY = entity.posY + 0.5D;
					
					// They have some ticks.  We need to decrease their ticks by 1 and cancel the fall.
					entityData.updateObject(24, entityData.getWatchableObjectInt(24)-1);
					entity.motionY = 0;
				}
			}
			else
			{
				entityData.updateObject(24, 30);
			}
		}
		
		if(boots.getItem() == Item.blazePowder)
		//if(boots.getItem() == ModItems.bootsPegasus)
			AddPegasus(entity);
		else
			RemovePegasus(entity);
	}
	
	private void AddPegasus(EntityLivingBase fEntity)
	{
		AttributeInstance speedAttr = fEntity.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed);
		
		if(speedAttr.getModifier(pegasusUUID) != null)
			return;
		
		AttributeModifier modSpeed = new AttributeModifier(pegasusUUID, "PegasusBoots", 0.2D, 1); 
		
		// Creatures and Players use 2 different values here
		speedAttr.removeModifier(modSpeed);
		speedAttr.applyModifier(modSpeed);
	}
	
	private void RemovePegasus(EntityLivingBase fEntity)
	{
		AttributeInstance speedAttr = fEntity.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed);
				
		if(speedAttr.getModifier(pegasusUUID) == null)
			return;
		
		AttributeModifier modSpeed = new AttributeModifier(pegasusUUID, "PegasusBoots", 0.2D, 1);
		speedAttr.removeModifier(modSpeed);
	}
}
