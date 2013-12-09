package org.ttp.alttc.client.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.ResourceLocation;

public class RenderUtils {
    
    static RenderBlocks renderBlocksInstance = new RenderBlocks();
    
    public static void bindTexture(ResourceLocation rl) {
        Minecraft.getMinecraft().renderEngine.bindTexture(rl);
    }
}
