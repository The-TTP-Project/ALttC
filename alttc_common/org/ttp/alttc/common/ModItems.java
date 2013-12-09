package org.ttp.alttc.common;

import net.minecraft.item.Item;

import org.ttp.alttc.common.item.ItemHeart;
import org.ttp.alttc.common.item.ItemMasterSword;
import org.ttp.alttc.common.lib.ItemIds;
import org.ttp.alttc.common.lib.Strings;

public class ModItems {
    public static Item itemHeart;
    public static Item masterSword;
    
    public static void init(){
        itemHeart = new ItemHeart(ItemIds.ITEM_HEART, Strings.ITEM_HEART);
        masterSword = new ItemMasterSword(ItemIds.ITEM_MASTERSWORD, Strings.ITEM_MASTERSWORD);
    }
}
