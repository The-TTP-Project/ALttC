package org.ttp.alttc.common;

import net.minecraft.block.Block;

public class ModBlocks {
    
    //If you want to keep a reference to the block, for other reasons
    public static Block testblock;
    
    public static void init() {
        //testblock = new BlockTest(BlockIds.BLOCK_TEST, Material.anvil, Strings.BLOCK_TEST);
        
        initBlockRecipes();
    }
    
    public static void initBlockRecipes(){
        //TODO Recipes
    }
}
