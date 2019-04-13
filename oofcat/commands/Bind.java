package oofcat.commands;

import org.lwjgl.input.Keyboard;

import oofcat.command.Command;
import oofcat.main.Oofcat;
import oofcat.mods.Module;

public class Bind extends Command{

	@Override
	public String getAlias() {
		return "bind";
	}

	@Override
	public String getDescription() {
		return "Allows user to change keybind of Module(e.g. Xray)";
	}

	@Override
	public String getSyntax() {
		return ".bind set [MOD] [Key] | .bind del [MOD] | .bind clear";
	}

	@Override
	public void onCommand(String command, String[] args) throws Exception {
		if(args[0].equalsIgnoreCase("set")) {
			args[2].toUpperCase();
			int key = Keyboard.getKeyIndex(args[2]);
			
			for(Module m: Oofcat.getModules()) {
				if(args[1].equalsIgnoreCase(m.getName())) {
					m.setKey(Keyboard.getKeyIndex(Keyboard.getKeyName(key)));
					Oofcat.addChatMessage(args[1] + " has been binded to " + args[2]);
				}
			}
			
		}else if(args[0].equalsIgnoreCase("del")) {
			for(Module m: Oofcat.getModules()) {
				if(m.getName().equalsIgnoreCase(args[1])) {
					m.setKey(0);
					Oofcat.addChatMessage(args[1] + " has been unbinded :D");
				}
			}
		}else if(args[0].equalsIgnoreCase("clear")) {
			for(Module m: Oofcat.getModules()) {
				m.setKey(0);
			}
			Oofcat.addChatMessage("All Keys cleared :P");
		}
	}
	
}
