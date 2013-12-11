package org.ttp.alttc.common.core.handlers;

import java.util.logging.Level;

import net.minecraftforge.common.Configuration;

import org.ttp.alttc.common.lib.Reference;

import cpw.mods.fml.common.FMLLog;

public class ConfigHandler {
    private static Configuration config;
    
    // Blocks
    private static int blockDefault = 2000;
    public static int deceptionBlock;
    
    // Items
    private static int itemDefault = 4250;
    public static int itemHeart;
    public static int itemMasterSword;
	public static int dekuStick;
    public static int itemTunicGoron;
    public static int itemTunicZora;
        public static int itemLens;

    // Special
    public static boolean renderMasterSword;


    
    public static void init(Configuration fConfig)
    {
        config = fConfig;

        try {
            config.load();
            
            //Blocks
            deceptionBlock = config.getBlock("Blocks", "deceptionBlock", getBlockID()).getInt();            
                            
            //Items
            itemHeart = config.getItem("Items", "Heart", getItemID()).getInt();
            itemMasterSword = config.getItem("Gear", "MasterSword", getItemID()).getInt();
            dekuStick = config.getItem("Gear", getItemID()).getInt();
            itemLens = config.getItem("Items", "Lens Of Truth", getItemID()).getInt();
            
            //Reference values
            renderMasterSword = config.get("Sword", "UseMasterSwordModel", false).getBoolean(false);
            
        } catch (Exception e) {
            FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " has had a problem loading its block configuration");
        } finally {
            config.save();
        }
    }
    
    public static int getBlockID()
    {
            return blockDefault++;
    }
    
    public static int getItemID()
    {
            return itemDefault++;
    }
}