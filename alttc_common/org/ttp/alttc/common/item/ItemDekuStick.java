package org.ttp.alttc.common.item;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDekuStick extends ItemWeaponBase{

	private float weaponDamage;
	private final EnumToolMaterial toolMaterial;
	
	public ItemDekuStick(int id, String name) {
		super(id, name);
		toolMaterial = EnumToolMaterial.WOOD;
		setMaxStackSize(64);
	}
	
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.none;
    }
    
    // Override to do nothing
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return par1ItemStack;
    }
    
    // Doesnt harvest webs
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block.blockID == Block.web.blockID;
    }
    
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        par1ItemStack.stackSize--;
        if (par1ItemStack.stackSize == 0)
        	par1ItemStack = null;
        return true;
    }

}
