package org.ttp.alttc;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.ttp.alttc.common.ModBlocks;
import org.ttp.alttc.common.ModItems;
import org.ttp.alttc.common.core.TTPLogger;
import org.ttp.alttc.common.core.handlers.ConfigHandler;
import org.ttp.alttc.common.lib.Reference;
import org.ttp.alttc.common.packets.PacketHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(channels = { Reference.CHANNEL_NAME }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class ALttC {
    
    @Instance(Reference.MOD_ID)
    public static ALttC instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    
    public static CreativeTabs creativeTab = new CreativeTabs(Reference.MOD_ID) {
        public ItemStack getIconItemStack() {
            return new ItemStack(ModItems.itemHeart, 1, 0);
        }
    };
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        TTPLogger.init();
        ConfigHandler.init(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.CHANNEL_NAME.toLowerCase() + File.separator);
        ModBlocks.init();
        ModItems.init();
        proxy.runClientSide();
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event) {
        
    }

    @EventHandler
    public void postLoaded(FMLPostInitializationEvent event) {
        
    }
    
    @EventHandler
    public void onServerStart(FMLServerStartingEvent event){
        
    }
    
}
