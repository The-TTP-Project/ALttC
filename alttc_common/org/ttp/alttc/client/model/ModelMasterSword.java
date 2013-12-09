package org.ttp.alttc.client.model;

import org.ttp.alttc.common.lib.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelMasterSword extends ModelBase {

    private IModelCustom modelMasterSword;
    
    public ModelMasterSword() {
        modelMasterSword = AdvancedModelLoader.loadModel(Models.MASTER_SWORD);
    }
    
    public void renderAll() {
        modelMasterSword.renderAll();
    }
}
