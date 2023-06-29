package me.shytou.gungame.modules.boosting;

import me.shytou.gungame.FileHandler;
import me.shytou.gungame.modules.Module;
import org.lwjgl.input.Keyboard;

import java.lang.reflect.Field;

public class Timer extends Module {


    private  static final FileHandler file = new FileHandler();


    public Timer() {
        super("Timer", Keyboard.getKeyIndex(file.getKey("timer","key")), Category.BOOSTING);
    }

    @Override
    public void onEnable() {


        double time = new FileHandler().get("timer","value");

        setTimer((float) time);

    }
    @Override
    public void onDisable() {
        setTimer(1.0F);
    }
    @Override
    public void run() {

    }


    public void setTimer(float timerSpeed) {

        try {

            Field timerField =
                    mc.getClass().getDeclaredField("field_71428_T");
                    //mc.getClass().getDeclaredField("timer");
            timerField.setAccessible(true);
            Object timerObject = timerField.get(mc);
            Field timerSpeedField =
                    timerObject.getClass().getDeclaredField("field_74278_d");
                    //timerObject.getClass().getDeclaredField("timerSpeed");
            timerSpeedField.setAccessible(true);

            timerSpeedField.setFloat(timerObject,timerSpeed);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
