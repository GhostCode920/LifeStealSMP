package me.ghostcode.lifesteal.versionsupport;

import me.ghostcode.lifesteal.Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public abstract class Version {
	
	private static Version $Instance;
	public static Version get() {
		
		if($Instance == null) {
			// if i found better i'll change
			for(Class<? extends Version> clazz : new Class[] {v1_16_R3.class}) {
				try {
					Class.forName("net.minecraft.server."+clazz.getSimpleName()+".Packet");
					return $Instance = clazz.newInstance();
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
					
				}
			}
			Bukkit.getConsoleSender().sendMessage("§cThe server's version is not supported. Check for on -->web<--"); //TODO -->web<--
			Bukkit.getPluginManager().disablePlugin(Main.getInstance());
			return null;
		}
		
		return $Instance;
	}
	
	public abstract void sendActionBar(Player p, String content);

}
