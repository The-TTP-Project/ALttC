package org.ttp.alttc.common.item;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDekuStick extends ItemWeaponBase {

	private float weaponDamage;
	private final EnumToolMaterial toolMaterial;

	public ItemDekuStick(int id, String name) {
		super(id, name);
		toolMaterial = EnumToolMaterial.WOOD;
		setMaxStackSize(64);
		setMaxDamage(6);
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
		if (stack.getItemDamage() != 0) {
			long worldTimeStart = -1;
			if (worldTimeStart == -1)
				worldTimeStart = world.getWorldTime();
			if ((world.getWorldTime() - worldTimeStart) % 20 == 0) {
				stack.damageItem(1, (EntityLivingBase) entity);
			}
		}
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase player, ItemStack stack) {

		if (player instanceof EntityPlayer
				&& searchForFire((EntityPlayer) player, player.worldObj,
						Minecraft.getMinecraft().objectMouseOver.blockX,
						Minecraft.getMinecraft().objectMouseOver.blockY,
						Minecraft.getMinecraft().objectMouseOver.blockZ)) {
			System.out.println("test2");
			stack.setItemDamage(5);
			return true;
		}
		return false;
	}

	private boolean searchForFire(EntityPlayer player, World world, int x,
			int y, int z) {
		System.out.println("test");
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
		return par1Block.blockID == Block.web.blockID;
	}

	public boolean hitEntity(ItemStack par1ItemStack,
			EntityLivingBase par2EntityLivingBase,
			EntityLivingBase par3EntityLivingBase) {
		par1ItemStack.stackSize--;
		if (par1ItemStack.stackSize == 0)
			par1ItemStack = null;
		return true;
	}

}
