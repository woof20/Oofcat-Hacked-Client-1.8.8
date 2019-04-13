package oofcat.gui;

import org.darkstorm.minecraft.gui.component.Frame;
import org.darkstorm.minecraft.gui.util.GuiManagerDisplayScreen;

import net.minecraft.client.Minecraft;
import oofcat.main.Oofcat;

public class UIRenderer {

	public static void renderAndUpdateFrames() {
		for(Frame f: Oofcat.guiManager.getFrames()) {
			f.update();
		} 
		for(Frame f: Oofcat.guiManager.getFrames()) {
			if(f.isPinned() || Minecraft.getMinecraft().currentScreen instanceof GuiManagerDisplayScreen) {
				f.render();
			}
		}
	}
	
}
