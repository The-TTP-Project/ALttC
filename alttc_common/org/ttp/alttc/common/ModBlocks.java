package org.ttp.alttc.common;

import org.ttp.alttc.common.blocks.BlockDeception;
import org.ttp.alttc.common.core.handlers.ConfigHandler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
    
    //If you want to keep a reference to the block, for other reasons
    public static Block deceptionBlock;
    
    public static void init() {
        //testblock = new BlockTest(BlockIds.BLOCK_TEST, Material.anvil, Strings.BLOCK_TEST);
        deceptionBlock = new BlockDeception(ConfigHandler.deceptionBlock, Material.rock, "tile.deceptionBlock");
        initBlockRecipes();
    }
    
    public static void initBlockRecipes(){
        //TODO Recipes
    }
}
