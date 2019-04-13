package oofcat.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C03PacketPlayer;
import oofcat.main.Category;

public class NoFall extends Module{

	public NoFall() {
		super("NoFall", Keyboard.KEY_N, Category.MOVEMENT);
	}
	
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.thePlayer.fallDistance > 2F) {
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
			} 
		}
		super.onUpdate();
	}

}
