package org.ttp.alttc.common.item;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.EnumHelper;

import org.ttp.alttc.ALttC;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemArmorTunic extends ItemArmor
{

	public static EnumArmorMaterial materialTunic;
	public static EnumArmorMaterial materialBoots;
	public static EnumArmorMaterial materialMask;

	public ItemArmorTunic(int id, String name, int render)
	{
		super(id, materialBoots, render, 1);
		setCreativeTab(ALttC.creativeTab);
		register(name);
	}

	public void register(String name) {
		this.setUnlocalizedName(name);
		GameRegistry.registerItem(this, name);
	}
}
