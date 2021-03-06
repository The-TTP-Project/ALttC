package org.ttp.alttc.common.core;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.ttp.alttc.common.lib.Reference;

import cpw.mods.fml.common.FMLLog;

public class TTPLogger {
    // Logger thanks to Pahimar. :P
    private static Logger ttpLogger = Logger.getLogger(Reference.MOD_ID);

    public static void init() {
        ttpLogger.setParent(FMLLog.getLogger());
    }

    public static void log(Level logLevel, Object object) {
        ttpLogger.log(logLevel, object.toString());
    }

    public static void severe(Object object) {

        log(Level.SEVERE, object.toString());
    }

    public static void debug(Object object) {

        log(Level.WARNING, "[DEBUG] " + object.toString());
    }

    public static void warning(Object object) {

        log(Level.WARNING, object.toString());
    }

    public static void info(Object object) {

        log(Level.INFO, object.toString());
    }

    public static void config(Object object) {

        log(Level.CONFIG, object.toString());
    }

    public static void fine(Object object) {

        log(Level.FINE, object.toString());
    }

    public static void finer(Object object) {

        log(Level.FINER, object.toString());
    }

    public static void finest(Object object) {

        log(Level.FINEST, object.toString());
    }
}
