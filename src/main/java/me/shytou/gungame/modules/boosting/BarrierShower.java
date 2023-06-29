/*package me.shytou.gungame.modules.boosting;

import me.shytou.gungame.FileHandler;
import me.shytou.gungame.modules.Module;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

import java.lang.reflect.Field;

public class BarrierShower extends Module {

    private static final FileHandler file = new FileHandler();

    public BarrierShower() {
        super("Barrier", Keyboard.getKeyIndex(file.getKey("barrier","key")), Category.BOOSTING);
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    public void renderBarrier(IBlockAccess world, BlockPos pos, BlockRendererDispatcher blockRenderer) {
        IBlockState state = world.getBlockState(pos);

        if(state.getBlock().equals(Blocks.barrier)) {
            Tessellator tester = Tessellator.getInstance();
            WorldRenderer renderer = tester.getWorldRenderer();
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.disableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.tryBlendFuncSeparate(770,771,1,0);
            GlStateManager.color(1.0F,1.0F,1.0F,0.5F);

            blockRenderer.renderBlock(state,pos,world,renderer);

            GlStateManager.disableBlend();
            GlStateManager.enableLighting();
            GlStateManager.enableTexture2D();
            GlStateManager.popMatrix();
        }

    }

    @SubscribeEvent
    public void onWorldRender(RenderWorldLastEvent event) {

      World world = mc.theWorld;
      BlockRendererDispatcher dispatcher = mc.getBlockRendererDispatcher();
      BlockPos pos = mc.thePlayer.getPosition();





    }
}*/
