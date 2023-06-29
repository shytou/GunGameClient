package me.shytou.gungame;

import me.shytou.gungame.gui.Gui;
import me.shytou.gungame.mixin.MixinLoader;
import me.shytou.gungame.modules.Module;
import me.shytou.gungame.modules.boosting.Lag;
import me.shytou.gungame.modules.boosting.Timer;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;

import java.security.Key;
import java.time.chrono.MinguoChronology;
import java.util.concurrent.CopyOnWriteArrayList;


@Mod(modid = GunGameClient.MODID, version = GunGameClient.VERSION)
public class GunGameClient
{
    public static final String MODID = "gungameclient";
    public static final String VERSION = "1.0";
    public static CopyOnWriteArrayList<Module> modules = new CopyOnWriteArrayList<Module>();
    private final Gui gui = new Gui();
    private final FileHandler fileHandler = new FileHandler();


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MixinLoader loader = new MixinLoader();
        fileHandler.load();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        modules.add(new Lag());
        modules.add(new Timer());
        MinecraftForge.EVENT_BUS.register(this);
    }


    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void keyInput(InputEvent event) {


        if(Keyboard.isKeyDown(Keyboard.getEventKey())) {
            for(Module m : modules) {
                if(m.getKey() == Keyboard.getEventKey()) {
                    m.toggle();
                }
            }

            int key = Keyboard.getEventKey();
            if(key == Keyboard.KEY_RSHIFT) {
                Minecraft.getMinecraft().displayGuiScreen(new Gui());
            }

        }
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        for(Module m : modules) {
            if(!m.toggled)
                continue;
            m.run();
        }
    }


}
