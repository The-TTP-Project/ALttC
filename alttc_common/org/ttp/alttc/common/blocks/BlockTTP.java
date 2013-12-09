package org.ttp.alttc.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

import org.ttp.alttc.ALttC;
import org.ttp.alttc.common.lib.Reference;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTTP extends Block{

    public BlockTTP(int id, Material material, String name) {
        super(id, material);
        setCreativeTab(ALttC.creativeTab);
        setUnlocalizedName(name);
        register(name);
    }
    
    private void register(String name){
        GameRegistry.registerBlock(this, name);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().replace("tile.", ""));
    }
    
}
