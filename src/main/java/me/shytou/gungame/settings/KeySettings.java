package me.shytou.gungame.settings;

public class KeySettings extends Settings {

    public int code;

    public KeySettings(int code) {
        this.name = "Keybind";
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setKeyCode(int code) {
        this.code = code;
    }
}
