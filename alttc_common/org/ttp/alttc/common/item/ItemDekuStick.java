package org.ttp.alttc.common.item;

import java.util.List;

import org.ttp.alttc.common.lib.Reference;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemDekuStick extends ItemWeaponBase {

	public ItemDekuStick(int id, String name) {
		super(id, name);
		setMaxStackSize(64);
		setMaxDamage(8);
	}

	private Icon[] icons = new Icon[2];
	
	@Override
	public void registerIcons(IconRegister register) {
		icons[0] = register.registerIcon(Reference.MOD_ID + ":dekuStick");
		icons[1] = register.registerIcon(Reference.MOD_ID + ":dekuStickFire");
	}
	
	@Override
	public Icon getIcon(ItemStack stack, int pass) {
		return stack.getItemDamage() > 0 ? icons[1] : icons[0];
	}
	
	@Override
	public Icon getIconFromDamage(int par1) {
		return par1 > 0 ? icons[1] : icons[0];
	}
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.none;
	}

	// Override to do nothing
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		return par1ItemStack;
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4,
			boolean par5) {
		// System.out.println(stack.getItemDamage());
		if (stack.getItemDamage() != 0 && entity instanceof EntityPlayer && !world.isRemote) {
			
			if (world.getWorldTime() % 20 == 0)
				stack.damageItem(1, (EntityLivingBase) entity);
			if (stack.getItemDamage() > 7 && stack.stackSize == 1)
				((EntityPlayer)entity).inventory.consumeInventoryItem(this.itemID);
			else if (stack.getItemDamage() > 7 && stack.stackSize > 1)
			{
				stack.stackSize--;
				stack.setItemDamage(0);
			}
		}
		
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase player, ItemStack stack) {

		if (player instanceof EntityPlayer && Minecraft.getMinecraft().objectMouseOver != null
				&& searchForFire((EntityPlayer) player, player.worldObj,
						Minecraft.getMinecraft().objectMouseOver.blockX,
						Minecraft.getMinecraft().objectMouseOver.blockY,
						Minecraft.getMinecraft().objectMouseOver.blockZ)) {
			stack.setItemDamage(1);
			return true;
		}
		return false;
	}

	private boolean searchForFire(EntityPlayer player, World world, int x,
			int y, int z) {
		switch (Minecraft.getMinecraft().objectMouseOver.sideHit) {
		case 0:
			return world.getBlockId(x, y - 1, z) == Block.fire.blockID;
		case 1:
			return world.getBlockId(x, y + 1, z) == Block.fire.blockID;
		case 2:
			return world.getBlockId(x, y, z - 1) == Block.fire.blockID;
		case 3:
			return world.getBlockId(x, y, z + 1) == Block.fire.blockID;
		case 4:
			return world.getBlockId(x - 1, y, z) == Block.fire.blockID;
		case 5:
			return world.getBlockId(x + 1, y, z) == Block.fire.blockID;
		default:
			return false;
		}
	}

	// Doesnt harvest webs
	public boolean canHarvestBlock(Block par1Block) {
		return false;
	}

	public boolean hitEntity(ItemStack par1ItemStack,
			EntityLivingBase par2EntityLivingBase,
			EntityLivingBase par3EntityLivingBase) {
		par1ItemStack.stackSize--;
		if (par1ItemStack.stackSize == 0)
			par1ItemStack = null;
		return true;
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) 
	{
		if (stack.getItemDamage() > 0 && entity instanceof EntityLivingBase && !player.worldObj.isRemote)
		{
			((EntityLivingBase)entity).setHealth(((EntityLivingBase)entity).getHealth() - 8.0f);
		}
		return false;
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack stack,
			EntityPlayer player, List list, boolean par4) {
		super.addInformation(stack, player, list, par4);
		
		if (stack.getItemDamage() == 0)
		{
			list.add("Does double damage when on fire.");
			list.add("Set this on fire by punching fire with it!");
		}
		else
		{
			list.add("How are you still holding this?");
			list.add("And why are you reading this?");
		}		
	}
	
	
}
