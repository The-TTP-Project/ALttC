package org.ttp.alttc.common.lib;

import net.minecraft.util.ResourceLocation;

public class TextureMaps {
    // Texture Constants
    public static final String MODEL_SHEET_LOCATION = "textures/models/";
    
    public static final ResourceLocation MASTER_SWORD = getResource("masterSword.png");
    
    private static ResourceLocation getResource(String loc){
        return new ResourceLocation(Reference.MOD_ID.toLowerCase(), MODEL_SHEET_LOCATION + loc);
    }
}
