package org.ttp.alttc.common.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import org.ttp.alttc.ALttC;
import org.ttp.alttc.common.lib.Reference;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTTP extends Item {
	
	private boolean is3D;
	
	public ItemTTP(int id, String name, boolean is3D) {
		super(id);
		setUnlocalizedName(name);
		setCreativeTab(ALttC.creativeTab);
		register(name);
		this.is3D = is3D;
	}

	public void register(String name){
		GameRegistry.registerItem(this, name);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().replace("item.", ""));
	}
	
	@Override
	public boolean isFull3D() {
		return is3D;
	}
}
