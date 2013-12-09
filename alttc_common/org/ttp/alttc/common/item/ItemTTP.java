package org.ttp.alttc.common.item;

import net.minecraft.item.Item;

import org.ttp.alttc.ALttC;

public class ItemTTP extends Item{

    public ItemTTP(int id, String name) {
        super(id);
        setUnlocalizedName(name);
        setCreativeTab(ALttC.creativeTab);
    }

}
