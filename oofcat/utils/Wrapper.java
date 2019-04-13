package oofcat.utils;

import java.awt.Font;
import oofcat.utils.FontUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class Wrapper {

	public static Minecraft mc = Minecraft.getMinecraft();
	public static FontRenderer fr = mc.fontRendererObj;
	public static FontUtils fu_default = new FontUtils("Audiowide", Font.PLAIN, 18);

}
	
	


