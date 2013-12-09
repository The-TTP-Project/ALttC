package org.ttp.alttc.common.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import org.ttp.alttc.ALttC;
import org.ttp.alttc.common.lib.Reference;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTTP extends Item {
    public ItemTTP(int id, String name) {
        super(id);
        setUnlocalizedName(name);
        setCreativeTab(ALttC.creativeTab);
        register(name);
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
}
