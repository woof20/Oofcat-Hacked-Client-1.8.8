package oofcat.tabgui;

import java.util.ArrayList;
import java.util.HashMap;

import org.lwjgl.input.Keyboard;

import oofcat.main.Oofcat;
import oofcat.mods.*;

public class TabManager {
	
	private ArrayList<Tab> tabs;
	private int currentTab;
	
	private HashMap<Integer, Module> renderMods, movementMods, combatMods, autoMods, otherMods;
	private int currentRenderMod, currentMovementMod, currentCombatMod, currentAutoMod, currentOtherMod;
	
	public TabManager() {
		tabs = new ArrayList();
		currentTab = 0;
		renderMods = new HashMap();
		movementMods = new HashMap();
		combatMods = new HashMap();
		autoMods = new HashMap();
		otherMods = new HashMap();
		currentRenderMod = 0;
		currentMovementMod = 0;
		currentCombatMod = 0;
		currentAutoMod = 0;
		currentOtherMod = 0;
		tabs.add(new TabOne());
		tabs.add(new TabTwo());
		
		renderMods.put(0, new ChestESP());
		renderMods.put(1, new MobESP());
		renderMods.put(2, new Xray());
		renderMods.put(3, new Fullbright());
		renderMods.put(4, new TracerMobs());
		renderMods.put(5, new TracerPlayer());
		
		movementMods.put(0, new Flight());
		movementMods.put(1, new NoFall());
		movementMods.put(2, new Glide());
		movementMods.put(3, new WaterWalk());
		movementMods.put(4, new Sprint());
		movementMods.put(5, new Step());
		
		combatMods.put(0, new KillAura());
		combatMods.put(1, new Aimbot());
		
		otherMods.put(1, new FastPlace());
	}
	
	public ArrayList<Tab> getTabs() {
		return tabs;
	}
	
	public int getCurrentOtherMod() {
		return currentOtherMod;
	}
	
	public int getCurrentAutoMod() {
		return currentAutoMod;
	}
	
	public int getCurrentCombatMod() {
		return currentCombatMod;
	}
	
	public int getCurrentMovementMod() {
		return currentMovementMod;
	}
	
	public int getCurrentRenderMod() {
		return currentRenderMod;
	}
	
	public int getCurrentTab() {
		return currentTab;
	}
	
	public void keyPressed(int k) {
		switch(k) {
		case Keyboard.KEY_UP:
			if(tabs.get(currentTab).isExpanded()) {
				switch(currentTab) {
				case 0:
					if(currentRenderMod != 0) {
						currentRenderMod--;
					}
					break;
				case 1:
					if(currentMovementMod != 0) {
						currentMovementMod--;
					}
					break;
				case 2:
					if(currentCombatMod != 0) {
						currentCombatMod--;
					}
					break;
				case 3:
					if(currentAutoMod != 0) {
						currentAutoMod--;
					}
					break;
				case 4:
					if(currentOtherMod != 0) {
						currentOtherMod--;
					}
					break;
				}
			}else {
				if(currentTab != 0) {
					currentTab--;
				}
			}
			break;
			
		case Keyboard.KEY_DOWN:
			if(tabs.get(currentTab).isExpanded()) {
				switch(currentTab) {
				case 0:
					if(currentRenderMod != renderMods.size()-1) {
						currentRenderMod++;
					}
					break;
				case 1:
					if(currentMovementMod != movementMods.size()-1) {
						currentMovementMod++;
					}
					break;
				case 2:
					if(currentCombatMod != combatMods.size()-1) {
						currentCombatMod++;
					}
					break;
				case 3:
					if(currentAutoMod != autoMods.size()-1) {
						currentAutoMod++;
					}
					break;
				case 4:
					if(currentOtherMod != otherMods.size()-1) {
						currentOtherMod++;
					}
					break;
				}
			}else {
				if(currentTab != 1) {
					currentTab++;
				}
			}
			break;
			
		case Keyboard.KEY_RIGHT:
			if(tabs.get(currentTab).isExpanded()) {
				switch(currentTab) {
				case 0:
					toggleMod(renderMods.get(currentRenderMod).getName());
					break;
				case 1:
					toggleMod(movementMods.get(currentMovementMod).getName());
					break;
				case 2:
					toggleMod(combatMods.get(currentCombatMod).getName());
					break;
				case 3:
					toggleMod(autoMods.get(currentAutoMod).getName());
					break;
				case 4:
					toggleMod(otherMods.get(currentOtherMod).getName());
					break;
				}
			}else {
				tabs.get(currentTab).setExpanded(true);
			}
			break;
	
		case Keyboard.KEY_LEFT:
			if(tabs.get(currentTab).isExpanded()) {
				tabs.get(currentTab).setExpanded(false);
			}
			break;
		}
	}
	
	private void toggleMod(String n) {
		for(Module m: Oofcat.getModules()) {
			if(m.getName().equalsIgnoreCase(n)) {
				m.toggle();
				break;
			}
		}
	}

}
