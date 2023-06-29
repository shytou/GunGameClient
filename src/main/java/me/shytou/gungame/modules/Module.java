package me.shytou.gungame.modules;

import me.shytou.gungame.settings.KeySettings;
import me.shytou.gungame.settings.Settings;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Module {

    public String name;
    public boolean toggled;
    public KeySettings keyCode = new KeySettings(0);
    public Category category;
    public Minecraft mc = Minecraft.getMinecraft();
    public List<Settings> settings = new ArrayList<Settings>();

    public Module(String name, Integer key, Category category) {
        this.name = name;
        keyCode.code = key;
        this.category = category;
        this.addSettings(keyCode);
    }

    public void addSettings(Settings... settings) {
        this.settings.addAll(Arrays.asList(settings));
    }

    public boolean isEnabled() {
        return toggled;
    }


    public  int getKey() {
        return keyCode.code;
    }

    public void toggle() {
        toggled =  !toggled;
        if(toggled) {
            onEnable();
        }else  {
            onDisable();
        }
    }

    public void onEnable() {

    }

    public void onDisable() {

    }

    public void run() {

    }

    public enum Category {
        BLATANT,
        RENDER,
        BOOSTING,

    }

}
