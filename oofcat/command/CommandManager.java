package oofcat.command;

import java.util.ArrayList;

import oofcat.commands.*;
import oofcat.main.Oofcat;

public class CommandManager {
	
	private ArrayList<Command> commands;
	
	public CommandManager() {
		commands = new ArrayList();
		addCommand(new Bind());
		addCommand(new Toggle());
	}
	
	public void addCommand(Command c) {
		commands.add(c);
	}
	
	public ArrayList<Command> getCommands() {
		return commands;
	}
	
	public void callCommand(String input) {
		String[] split = input.split(" ");
		String command = split[0];
		String args = input.substring(command.length()).trim();
		for(Command c: getCommands()) {
			if(c.getAlias().equalsIgnoreCase(command)) {
				try {
					c.onCommand(args, args.split(" "));
				}catch(Exception e) {
					Oofcat.addChatMessage("Invalid Command usage!" + " ._.");
					Oofcat.addChatMessage(c.getSyntax());
				}
				return;
			}
		}
		Oofcat.addChatMessage("Command not found! " + ";-;");
	}

}
