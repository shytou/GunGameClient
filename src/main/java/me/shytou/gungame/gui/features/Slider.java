package me.shytou.gungame.gui.features;

import me.shytou.gungame.FileHandler;
import net.minecraftforge.fml.client.config.GuiSlider;

public class Slider {

    private int id;
    private String text;
    private int x;
    private int y;
    private int width;
    private int height;
    private double minValue;
    private double maxValue;
    private double currentValue;
    private boolean showDecimal = true;
    private boolean writeText = true;
    private String suffix;
    private GuiSlider slider;
    private GuiSlider.ISlider islider;
    private FileHandler file = new FileHandler();

    public Slider(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public void setShowDecimal(boolean showDecimal) {
        this.showDecimal = showDecimal;
    }

    public void setWrite(boolean writeText) {
        this.writeText = writeText;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void ISlider (final double rawValue, final String configCategory, final String configValue, final boolean decimal) {
        islider = new GuiSlider.ISlider() {
            @Override
            public void onChangeSliderValue(GuiSlider guiSlider) {

                double value = 0;

                if(decimal) {
                    double rawValue1 = rawValue*100;
                    double roundedValue = Math.round(rawValue1);
                     value = roundedValue/100;
                }else {
                    value = Math.round(rawValue);
                }
                file.set(configCategory,configValue,value);
            }
        };
    }

    public GuiSlider build() {
        slider = new GuiSlider(id,x,y,width,height,text,suffix,minValue,maxValue,currentValue,showDecimal,writeText,islider);
        return slider;
    }
}
