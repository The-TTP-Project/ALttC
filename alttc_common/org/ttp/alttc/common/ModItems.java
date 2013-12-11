package org.ttp.alttc.common;

import net.minecraft.item.Item;

import org.ttp.alttc.common.core.handlers.ConfigHandler;
import org.ttp.alttc.common.item.ItemDekuStick;
import org.ttp.alttc.common.item.ItemHeart;
import org.ttp.alttc.common.item.ItemWeaponBase;
import org.ttp.alttc.common.item.ItemTTP;

public class ModItems {
    public static Item itemHeart;
    public static Item masterSword;
    public static Item dekuStick;
    public static Item lensOfTruth;
    
    // Tunics
    public static Item tunicGoron;
    public static Item tunicZora;
    
    // Boots
    public static Item bootsPegasus;
    public static Item bootsIron;
    public static Item bootsHover;
    
    public static void init(){
        itemHeart = new ItemHeart(ConfigHandler.itemHeart, "pickupHeart");
        masterSword = new ItemWeaponBase(ConfigHandler.itemMasterSword, "masterSword");
        dekuStick = new ItemDekuStick(ConfigHandler.dekuStick, "dekuStick");
        lensOfTruth = new ItemTTP(ConfigHandler.itemLens, "lensOfTruth");
    }
}