package oofcat.main;

import java.util.ArrayList;

import org.darkstorm.minecraft.gui.theme.simple.SimpleTheme;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.util.ChatComponentText;
import oofcat.command.CommandManager;
import oofcat.gui.OofcatGuiManager;
import oofcat.mods.*;
import oofcat.tabgui.TabManager;
import oofcat.utils.XrayUtils;

public class Oofcat {
	
	private static ArrayList<Module> mods;
	private static CommandManager cmdManager;
	public static OofcatGuiManager guiManager;
	public static TabManager tabManager;
	public static Object options;
	
	public Oofcat() {
		mods = new ArrayList<Module>();
		cmdManager = new CommandManager();
		tabManager = new TabManager();
		XrayUtils.initXRayBlocks();
		addMod(new Flight());
		addMod(new NoFall());
		addMod(new Fullbright());
		addMod(new ClickGui());
		addMod(new Glide());
		addMod(new MobESP());
		addMod(new ChestESP());
		addMod(new Xray());
		addMod(new WaterWalk());
		addMod(new Sprint());
		addMod(new Step());
		addMod(new KillAura());
		addMod(new FastPlace());
		addMod(new TracerMobs());
		addMod(new TracerPlayer());
		addMod(new Aimbot());
		guiManager = new OofcatGuiManager();
		guiManager.setTheme(new SimpleTheme());
		guiManager.setup();
	}
	
	public static void addMod(Module m) {
		mods.add(m);
	}
	
	public static ArrayList<Module> getModules() {
		return mods;
	}
	
	public static void onUpdate() {
		for(Module m: mods) {
			m.onUpdate();
		}
	}
	
	public static void onRender() {
		for(Module m: mods) {
			m.onRender();
		}
	}
	
	public static void onKeyPressed(int k) {
		for(Module m: mods) {
			if(m.getKey() == k) {
				m.toggle();
			}
		}
	}
	
	public static void addChatMessage(String s) {
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Oofcat: " + s));
	}
	
	public static boolean onSendChatMessage(String s) {//EntityPlayerSP
		if(s.startsWith(".")) {
			cmdManager.callCommand(s.substring(1));
			return false;
		}
		for(Module m: getModules()) {
			if(m.isToggled()) {
				return m.onSendChatMessage(s);
			}
		}
		return true;
	}
	
	public static boolean onRecieveChatMessage(S02PacketChat packet) {
		for(Module m: getModules()) {
			if(m.isToggled()) {
				return m.onRecieveChatMessage(packet);
			}
		}
		return true;
	}
	
	public static int getOptions(int options) {
		return options;
	}
	
}
