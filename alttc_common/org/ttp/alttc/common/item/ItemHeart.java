package org.ttp.alttc.common.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import org.ttp.alttc.common.entity.EntityHeart;

public class ItemHeart extends ItemTTP {

	public ItemHeart(int id, String name) {
		super(id, name);
	}
	
	private Icon icon;
	
	@Override
	public void registerIcons(IconRegister register) {
		icon = register.registerIcon("alttc:heart");
	}
	
	@Override
	public Icon getIcon(ItemStack stack, int pass) {
		return icon;
	}
	
	@Override
	public Icon getIconFromDamage(int par1) {
		return icon;
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
