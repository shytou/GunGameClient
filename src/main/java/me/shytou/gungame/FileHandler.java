package me.shytou.gungame;

import com.google.gson.Gson;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lwjgl.input.Keyboard;

import javax.xml.crypto.Data;
import java.io.*;

public class FileHandler {
    File configFile = new File(Loader.instance().getConfigDir(), "gungameclient.cfg");
    private final Configuration config = new Configuration(configFile);;


    public FileHandler() {
    }

    public void load() {
        config.load();
        config.get("timer","value",0.1);
        config.get("timer","key","K");
        config.get("lag","value",2.0);
        config.get("lag","key","L");
        if(config.hasChanged()) {
            config.save();
        }
    }

    public double get(String category,String key) {
        config.load();
         Property property = config.get(category,key,1.0);
         return property.getDouble();
    }

    public void set(String category, String key,double value) {
        config.load();
        config.get(category,key,1.0).set(value);
        config.save();

    }

    public String getKey(String category,String key) {
        config.load();
        Property property = config.get(category,key,"none");
        return property.getString();
    }

    public void setKey(String category, String key,String value) {
        config.load();
        config.get(category,key,1.0).set(value);
        config.save();

    }
}
