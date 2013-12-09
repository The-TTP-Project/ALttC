package org.ttp.alttc.common.core.handlers;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;

import org.ttp.alttc.common.lib.BlockIds;
import org.ttp.alttc.common.lib.ItemIds;
import org.ttp.alttc.common.lib.Reference;
import org.ttp.alttc.common.lib.Strings;

import cpw.mods.fml.common.FMLLog;

public class ConfigHandler {
    private static Configuration config;
    private static String var = "Misc";
    
    public static void init(String file) {
        config = new Configuration(new File(file + Reference.MOD_ID + ".cfg"));

        try {
            config.load();
            
            //Blocks
            BlockIds.BLOCK_TEST = config.getBlock(Strings.BLOCK_TEST, BlockIds.BLOCK_TEST_DEFAULT).getInt();
            
            //Items
            ItemIds.ITEM_HEART = config.getItem(Strings.ITEM_HEART, ItemIds.ITEM_HEART_DEFAULT).getInt();
            ItemIds.ITEM_MASTERSWORD = config.getItem(Strings.ITEM_MASTERSWORD, ItemIds.ITEM_MASTERSWORD_DEFAULT).getInt();
            
            //Reference values
            Reference.USE_MASTER_SWORD_MODEL = config.get("Reference Values", "Use MasterSword model", Reference.USE_MASTER_SWORD_MODEL).getBoolean(true);
            
        } catch (Exception e) {
            FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " has had a problem loading its block configuration");
        } finally {
            config.save();
        }
    }
}
