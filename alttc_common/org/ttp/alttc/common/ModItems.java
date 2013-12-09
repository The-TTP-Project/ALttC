package org.ttp.alttc.common;

import org.ttp.alttc.common.items.ItemHeart;
import org.ttp.alttc.common.items.ItemMasterSword;
import org.ttp.alttc.common.lib.ItemIds;
import org.ttp.alttc.common.lib.Strings;

import net.minecraft.item.Item;

public class ModItems {
    public static Item itemHeart;
    public static Item masterSword;
    
    public static void init(){
        itemHeart = new ItemHeart(ItemIds.ITEM_HEART, Strings.ITEM_HEART);
        masterSword = new ItemMasterSword(ItemIds.ITEM_MASTERSWORD, Strings.ITEM_MASTERSWORD);
    }
}
