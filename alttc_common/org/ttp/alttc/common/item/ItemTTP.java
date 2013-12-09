package org.ttp.alttc.common.item;

import net.minecraft.item.Item;

import org.ttp.alttc.ALttC;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemTTP extends Item{

    public ItemTTP(int id, String name) {
        super(id);
        setUnlocalizedName(name);
        setCreativeTab(ALttC.creativeTab);
        register(name);
    }
    
    public void register(String name){
        GameRegistry.registerItem(this, name);
    }

}
