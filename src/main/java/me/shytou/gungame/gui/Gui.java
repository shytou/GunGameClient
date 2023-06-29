package me.shytou.gungame.gui;

import me.shytou.gungame.FileHandler;

import me.shytou.gungame.GunGameClient;
import me.shytou.gungame.modules.Module;
import me.shytou.gungame.modules.boosting.Lag;
import me.shytou.gungame.modules.boosting.Timer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraftforge.fml.client.config.GuiSlider;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;

import java.io.IOException;
import java.text.DecimalFormat;

public class Gui extends GuiScreen {

    private final FileHandler file= new FileHandler();
    private GuiTextField timerTextField;
    private GuiTextField lagTextField;


    @Override
    public void initGui() {

        GuiSlider timerSlider = new GuiSlider(1, 20, 30, "Timer: ", 0.10,
                1, file.get("timer","value"), new GuiSlider.ISlider() {
            @Override
            public void onChangeSliderValue(GuiSlider guiSlider) {
                double guiSliderValue = guiSlider.getValue()*100.0;
                double roundedSliderValue = Math.round(guiSliderValue);
                double timerValue = roundedSliderValue/100;

                file.set("timer","value", timerValue);
            }
        });
        GuiSlider lagSlider = new GuiSlider(2, 20, 60, timerSlider.width, timerSlider.height, "Lag: ", " sec", 0.1,
                10, file.get("lag","value"), true, true, new GuiSlider.ISlider() {
            @Override
            public void onChangeSliderValue(GuiSlider guiSlider) {
                double guiSliderValue = guiSlider.getValue()*10.0;
                double roundedSliderValue = Math.round(guiSliderValue);
                double value = roundedSliderValue/10;
                file.set("lag","value", value);
            }
        });

        buttonList.add(timerSlider);
        buttonList.add(lagSlider);

         timerTextField = new GuiTextField(10,mc.fontRendererObj,timerSlider.width+20+timerSlider.height,30,timerSlider.height,timerSlider.height);
        timerTextField.setMaxStringLength(1);

        lagTextField = new GuiTextField(11,mc.fontRendererObj,lagSlider.width+20+lagSlider.height,60,lagSlider.height,lagSlider.height);
        lagTextField.setMaxStringLength(1);


    }

    @Override
    public void drawScreen(int p_drawScreen_1_, int p_drawScreen_2_, float p_drawScreen_3_) {
        drawDefaultBackground();
        timerTextField.drawTextBox();
        lagTextField.drawTextBox();

        super.drawScreen(p_drawScreen_1_, p_drawScreen_2_,p_drawScreen_3_);
    }

    @Override
    public void keyTyped(char typedKey,int keyCode) {
        try {
            super.keyTyped(typedKey, keyCode);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(timerTextField.isFocused()) {
            timerTextField.textboxKeyTyped(typedKey, keyCode);
            file.setKey("timer","key", timerTextField.getText().toUpperCase());
            for(Module m : GunGameClient.modules) {
                if(m.name.equalsIgnoreCase("timer")) {
                    m.keyCode.setKeyCode(Keyboard.getKeyIndex(file.getKey("timer","key")));
                    break;
                }
            }

        }else if(lagTextField.isFocused()) {
            lagTextField.textboxKeyTyped(typedKey, keyCode);
            file.setKey("lag","key", lagTextField.getText().toUpperCase());
            for(Module m : GunGameClient.modules) {
                if(m.name.equalsIgnoreCase("lag")) {
                    m.keyCode.setKeyCode(Keyboard.getKeyIndex(file.getKey("lag","key")));
                    break;
                }
            }


        }

    }

    @Override
    protected void actionPerformed(GuiButton button) {

    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        timerTextField.updateCursorCounter();
        lagTextField.updateCursorCounter();
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        try {
            super.mouseClicked(mouseX, mouseY, mouseButton);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        timerTextField.mouseClicked(mouseX, mouseY, mouseButton);
        lagTextField.mouseClicked(mouseX, mouseY, mouseButton);

    }
    

    public void execute() {
        if (mc.currentScreen instanceof Gui) {
            Gui gui = (Gui) mc.currentScreen;
            for (GuiButton button : gui.buttonList) {
                if (button.id == 1) {
                }
            }
        }
    }
}
