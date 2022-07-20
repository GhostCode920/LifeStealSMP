package me.ghostcode.lifesteal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import me.ghostcode.lifesteal.language.Language;
import me.ghostcode.lifesteal.versionsupport.Version;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

// Some parts from one of my old api
public final class Member {
	
	private static final ArrayList<Member> members = new ArrayList<>();
	
	private Member(Player p) {
		player = p;
		members.add(this);
	}
	
	public static ArrayList<Member> getAllRegistedMembers() {
		return members;
	}
	
	public static Member get(Player p) {
		for(Member m : members) {
			if(m.getPlayer() == p)
				return m;
		}
		return new Member(p);
	}	
	
	public void sendActionBar(String content) {
		Version.get().sendActionBar(player, content);
	} 
	
	
	private final Player player;
	public Player getPlayer() {
		return player;
	}
	
	protected int timer;
	protected Player lastHit;
	public void updateTimer(Player hit) {
		lastHit = hit;
		timer = LifeSteal.getInstance().getTimer();
	}
	public void runTimer() {
		new BukkitRunnable() {
			@Override public void run() {
				if(timer-- == 0)
					sendActionBar(Language.get().noLongerInCombat());
				else if(timer > 0)
					sendActionBar(Language.get().combatTimer().replace("$timer$", timer+""));
			} 
		}.runTaskTimerAsynchronously(LifeSteal.getInstance(), 0l, 20l);
	} 
	public int getTimer() {
		return timer;
	}
	public Player getLastHit() {
		return lastHit;
	}

	public int maxHealth() {
		if(!config().contains("health"))
			config().set("health", 10);
		return config().getInt("health", 10);
	}
	
	public void maxHealth(boolean add) {
		config().set("health", maxHealth()+(add?1:-1));
		getPlayer().setMaxHealth(maxHealth()*2);
	}
	
	
	
	private YamlConfiguration c;
	public YamlConfiguration config() {
		if(c != null) return c;
		
		try {
			File f = new File("plugins/LifeSteal/members/"+player.getUniqueId().toString()+".yml");
			f.mkdirs();
			f.createNewFile();
			return c = YamlConfiguration.loadConfiguration(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
} 
