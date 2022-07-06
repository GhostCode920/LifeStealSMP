package me.ghostcode.lifesteal.versionsupport;

import me.ghostcode.lifesteal.Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public abstract class Version {

	private static final Version[] vers = new Version[] {
		new v1_7_R3(), new v1_7_R4(),
		new v1_8_R1(), new v1_8_R2(), new v1_8_R3(), 
		new v1_9_R1(), new v1_9_R2(), 
		new v1_10_R1(), new v1_11_R1(), new v1_12_R1(), 
		new v1_13_R1(), new v1_13_R2(), 
		new v1_14_R1(), new v1_15_R1(), 
		new v1_16_R1(), new v1_16_R2(), new v1_16_R3(), 
		new v1_17_R1(),
		new v1_18_R1(), new v1_18_R2(), 
		new v1_19_R1() 
	};
	
	private static Version $Instance;
	public static Version get() {
		
		if($Instance == null) {
			for(Version v : vers)
				try {
					Class.forName("net.minecraft.server."+v.getClass().getSimpleName()+".Packet");
					return $Instance = v;
				} catch (ClassNotFoundException e) {}
			Bukkit.getConsoleSender().sendMessage("§cThe server's version is not supported. Check on spigotmc/lifestealsmp"); //TODO web
			Bukkit.getPluginManager().disablePlugin(Main.getInstance());
			return null;
		}
		
		return $Instance;
	}
	
	public abstract void sendActionBar(Player p, String content);
	
	public abstract Player shouldUpdateTimer(Player p, Entity d);

}
