package org.ttp.alttc.common.item;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;

import org.ttp.alttc.ALttC;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemArmorTTP extends Item {
	
	public static EnumArmorMaterial materialTunic;
	public static EnumArmorMaterial materialBoots;
	public static EnumArmorMaterial materialMask;
	
	public ItemArmorTTP(int id, String name) {
        super(id);
        setUnlocalizedName(name);
        setCreativeTab(ALttC.creativeTab);
        register(name);
    }
    
    public void register(String name){
        GameRegistry.registerItem(this, name);
    }
}
