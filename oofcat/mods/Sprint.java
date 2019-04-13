package oofcat.mods;

import oofcat.main.Category;

public class Sprint extends Module{

	public Sprint() {
		super("Sprint", 0, Category.MOVEMENT);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			mc.thePlayer.setSprinting(true);
		}else {
			mc.thePlayer.setSprinting(false);
		}
	}

}
