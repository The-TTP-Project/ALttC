package org.ttp.alttc.common;

import net.minecraft.item.Item;

import org.ttp.alttc.common.core.handlers.ConfigHandler;
import org.ttp.alttc.common.item.ItemHeart;
import org.ttp.alttc.common.item.ItemMasterSword;

public class ModItems {
	public static Item itemHeart;
	public static Item masterSword;

	// Tunics
	public static Item tunicGoron;
	public static Item tunicZora;

	// Boots
	public static Item bootsPegasus;
	public static Item bootsIron;
	public static Item bootsHover;

	public static void init(){
		itemHeart = new ItemHeart(ConfigHandler.itemHeart, "pickupHeart");
		masterSword = new ItemMasterSword(ConfigHandler.itemMasterSword, "masterSword");
	}
}
