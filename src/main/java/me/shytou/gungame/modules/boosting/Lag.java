package me.shytou.gungame.modules.boosting;

import me.shytou.gungame.FileHandler;
import me.shytou.gungame.modules.Module;
import org.lwjgl.input.Keyboard;

import java.io.File;

public class Lag extends Module {

    private static final FileHandler file = new FileHandler();


    public Lag() {
        super("Lag", Keyboard.getKeyIndex(file.getKey("lag","key")), Category.BOOSTING);
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }




    public void run() {
        double lagTime = (int) new FileHandler().get("lag","value");
        executeLag(lagTime);
        toggled = false;
    }

    public void executeLag(double lagTime) {
        try {

            long time = (long) (lagTime*1000);

            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
