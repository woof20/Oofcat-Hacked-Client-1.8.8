package oofcat.mods;

import org.lwjgl.input.Keyboard;

import oofcat.main.Category;
import oofcat.utils.Wrapper;

public class FastPlace extends Module{

	public FastPlace() {
		super("FastPlace", Keyboard.KEY_NONE, Category.OTHER);
	}
	
	public void onUpdate() {
		if (this.isToggled()) {
			Wrapper.mc.rightClickDelayTimer = 0;
		}
	}

	public void onDisable() {
		Wrapper.mc.rightClickDelayTimer = 6;
	}

}
