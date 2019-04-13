package oofcat.commands;

import oofcat.command.Command;
import oofcat.main.Oofcat;
import oofcat.mods.Module;

public class Toggle extends Command{

	@Override
	public String getAlias() {
		return "toggle";
	}

	@Override
	public String getDescription() {
		return "Toggles a mod through the console";
	}

	@Override
	public String getSyntax() {
		return ".toggle <Module>";
	}

	@Override
	public void onCommand(String command, String[] args) throws Exception {
		boolean found = false;
		for(Module m: Oofcat.getModules()) {
			if(args[0].equalsIgnoreCase(m.getName())) {
				m.toggle();
				found = true;
				Oofcat.addChatMessage(m.getName() + " was toggled!");
			}
		}
		if(found == false) {
			Oofcat.addChatMessage("That hack doesn't exist dumb! ._.");
		}
	}

}
