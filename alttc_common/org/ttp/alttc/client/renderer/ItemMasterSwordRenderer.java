package org.ttp.alttc.client.renderer;

import org.lwjgl.opengl.GL11;
import org.ttp.alttc.client.models.ModelMasterSword;
import org.ttp.alttc.client.utils.RenderUtils;
import org.ttp.alttc.common.lib.TextureMaps;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemMasterSwordRenderer implements IItemRenderer {

    private ModelMasterSword modelMasterSword;

    public ItemMasterSwordRenderer() {
        modelMasterSword = new ModelMasterSword();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch (type) {
        case ENTITY: {
            renderMasterSword(0F, 0.5F, 0F, 0.4F, false, false, false);
            return;
        }

        case EQUIPPED_FIRST_PERSON: {
            renderMasterSword(0F, 1.0F, 0.4F, 0.5F, true, false, false);
            break;
        }

        case INVENTORY: {
            renderMasterSword(0F, 0.1F, 0.0F, 0.4F, false, true, false);
            return;
        }

        case EQUIPPED: {
            renderMasterSword(0.5F, 0.5F, 0.4F, 0.5F, false, false, true);
            return;
        }

        default:
            return;
        }
    }
    
    private void renderMasterSword(float x, float y, float z, float scale, boolean fp, boolean inv, boolean eq) {

        TextureManager texture = Minecraft.getMinecraft().renderEngine;

        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);

        GL11.glTranslatef(x, y, z);
        GL11.glScalef(scale, scale, scale);

        if (fp)
//            GL11.glTranslatef(0F, -0.20F, -0.17F);
            
        if (inv)
//            GL11.glTranslatef(-0.01F, 0.12F, 0.0F);
            
        if (eq)
//            GL11.glTranslatef(-0.22F, 0F, 0F);

        // Translate, texture, and render the electrons. Theoretically I can
        // easily add electrons.
//        GL11.glRotatef((float)angle, 0.0F, 1.0F, 0.0F);
        RenderUtils.bindTexture(TextureMaps.MASTER_SWORD);
        modelMasterSword.renderAll();

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();

    }

}
