package oofcat.main;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import oofcat.gui.UIRenderer;
import oofcat.mods.Module;

public class GuiInGameHook extends GuiIngame{

	public GuiInGameHook(Minecraft mcIn) {
		super(mcIn);
	}
	
	public void renderGameOverlay(float partialTicks) {
		super.renderGameOverlay(partialTicks);
        ScaledResolution scaledresolution = new ScaledResolution(this.mc);
        this.mc.entityRenderer.setupOverlayRendering();
        GlStateManager.enableBlend();
        
        int count = 0;
        
        for(Module m: Oofcat.getModules()) {
        	if(m.isToggled()) {
        		mc.fontRendererObj.drawString(m.getName(), 445, 2 + (count * 10), 0xFF9900);
        		count++;
        	}
        }
        UIRenderer.renderAndUpdateFrames();
        drawTabGui();
    }
	
	public void drawTabGui() {
		drawRect(75, 20, 5, 40, Oofcat.tabManager.getCurrentTab()==0 ? 0xff0d0d0d : 0xff676c6e);
		mc.fontRendererObj.drawString("Render", 9, 26, 0xffffff);
		
		drawRect(75, 40, 5, 60, Oofcat.tabManager.getCurrentTab()==1 ? 0xff0d0d0d : 0xff676c6e);
		mc.fontRendererObj.drawString("Movement", 9, 46, 0xffffff);
		
		drawRect(75, 60, 5, 80, Oofcat.tabManager.getCurrentTab()==2 ? 0xff0d0d0d : 0xff676c6e);
		mc.fontRendererObj.drawString("Combat", 9, 66, 0xffffff);
		
		drawRect(75, 80, 5, 100, Oofcat.tabManager.getCurrentTab()==3 ? 0xff0d0d0d : 0xff676c6e);
		mc.fontRendererObj.drawString("Auto", 9, 86, 0xffffff);
		
		drawRect(75, 100, 5, 120, Oofcat.tabManager.getCurrentTab()==4 ? 0xff0d0d0d : 0xff676c6e);
		mc.fontRendererObj.drawString("Other", 9, 106, 0xffffff);
		
		if(Oofcat.tabManager.getTabs().get(0).isExpanded()) {
			drawRect(145, 20, 75, 40, Oofcat.tabManager.getCurrentRenderMod() == 0 ? 0xff0d0d0d : 0xff676c6e);
			mc.fontRendererObj.drawString("ChestESP", 85, 26, 0xffffff);
			
			drawRect(145, 40, 75, 60, Oofcat.tabManager.getCurrentRenderMod() == 1 ? 0xff0d0d0d : 0xff676c6e);
			mc.fontRendererObj.drawString("MobESP", 85, 46, 0xffffff);
			
			drawRect(145, 60, 75, 80, Oofcat.tabManager.getCurrentRenderMod() == 2 ? 0xff0d0d0d : 0xff676c6e);
			mc.fontRendererObj.drawString("Xray", 85, 66, 0xffffff);
			
			drawRect(145, 80, 75, 100, Oofcat.tabManager.getCurrentRenderMod() == 3 ? 0xff0d0d0d : 0xff676c6e);
			mc.fontRendererObj.drawString("Fullbright", 85, 86, 0xffffff);
			
			drawRect(145, 100, 75, 120, Oofcat.tabManager.getCurrentRenderMod() == 4 ? 0xff0d0d0d : 0xff676c6e);
			mc.fontRendererObj.drawString("MobTracer(s)", 85, 106, 0xffffff);
			
			drawRect(145, 120, 75, 140, Oofcat.tabManager.getCurrentRenderMod() == 5 ? 0xff0d0d0d : 0xff676c6e);
			mc.fontRendererObj.drawString("PlayerTracer(s)", 85, 126, 0xffffff);
		}
		
		if(Oofcat.tabManager.getTabs().get(1).isExpanded()) {
			drawRect(145, 40, 75, 60, Oofcat.tabManager.getCurrentMovementMod() == 0 ? 0xff0d0d0d : 0xff676c6e);
			mc.fontRendererObj.drawString("Flight", 85, 46, 0xffffff);
			
			drawRect(145, 60, 75, 80, Oofcat.tabManager.getCurrentMovementMod() == 1 ? 0xff0d0d0d : 0xff676c6e);
			mc.fontRendererObj.drawString("Nofall", 85, 66, 0xffffff);
			
			drawRect(145, 80, 75, 100, Oofcat.tabManager.getCurrentMovementMod() == 2 ? 0xff0d0d0d : 0xff676c6e);
			mc.fontRendererObj.drawString("Glide", 85, 86, 0xffffff);
			
			drawRect(145, 100, 75, 120, Oofcat.tabManager.getCurrentMovementMod() == 3 ? 0xff0d0d0d : 0xff676c6e);
			mc.fontRendererObj.drawString("Jesus", 85, 106, 0xffffff);
			
			drawRect(145, 120, 75, 140, Oofcat.tabManager.getCurrentMovementMod() == 4 ? 0xff0d0d0d : 0xff676c6e);
			mc.fontRendererObj.drawString("Sprint", 85, 126, 0xffffff);
			
			drawRect(145, 140, 75, 160, Oofcat.tabManager.getCurrentMovementMod() == 5 ? 0xff0d0d0d : 0xff676c6e);
			mc.fontRendererObj.drawString("Step", 85, 146, 0xffffff);
		}
		
	}

}
