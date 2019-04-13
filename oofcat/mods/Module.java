package oofcat.mods;

import java.util.ArrayList;

import org.darkstorm.minecraft.gui.component.basic.BasicSlider;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.S02PacketChat;
import oofcat.main.Category;

public class Module {
	
	protected ArrayList<BasicSlider>moduleSliders = new ArrayList<BasicSlider>();
	
	protected Minecraft mc = Minecraft.getMinecraft();
	private String name;
	private int key;
	private boolean toggled;
	private Category category;
	
	public Module(String nm, int k, Category c) {
		name = nm;
		key = k;
		category = c;
		toggled = false;
	}
	
	public void toggle() {
		toggled = !toggled;
		if(toggled) {
			onEnable();
		}else {
			onDisable();
		}
	}
	
	public void onEnable() {}
	public void onDisable() {}
	public void onUpdate() {}
	public void onRender() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Category getCategory() {
		return category;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public boolean isToggled() {
		return toggled;
	}

	public void setToggled(boolean toggled) {
		this.toggled = toggled;
	}
	
	public boolean onSendChatMessage(String s){
		return true;
	}
		 
	public boolean onRecieveChatMessage(S02PacketChat packet){
		return true;
	}

}
