package org.ttp.alttc.common.item;

import net.minecraft.item.EnumToolMaterial;

public class ItemMasterSword extends ItemTTP {
	
	private float weaponDamage;
    private final EnumToolMaterial toolMaterial;
    
    public ItemMasterSword(int id, String name) {
		super(id, name);
		toolMaterial = EnumToolMaterial.EMERALD;
		weaponDamage = 8.0f;
	}


}
