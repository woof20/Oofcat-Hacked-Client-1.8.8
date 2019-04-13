package oofcat.mods;

import org.darkstorm.minecraft.gui.util.GuiManagerDisplayScreen;
import org.lwjgl.input.Keyboard;

import oofcat.gui.UIRenderer;
import oofcat.main.Category;
import oofcat.main.Oofcat;

public class ClickGui extends Module{

	public ClickGui() {
		super("Click Gui", Keyboard.KEY_RBRACKET, Category.OTHER);
	}
	
	@Override
	public void onEnable() {
		 if(!(mc.currentScreen instanceof GuiManagerDisplayScreen)) {
			 mc.displayGuiScreen(new GuiManagerDisplayScreen(Oofcat.guiManager));
			 UIRenderer.renderAndUpdateFrames();
		 }
	}

}
