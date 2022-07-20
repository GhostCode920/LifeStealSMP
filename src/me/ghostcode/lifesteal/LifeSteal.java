package me.ghostcode.lifesteal;

import me.ghostcode.lifesteal.language.Language;
import me.ghostcode.lifesteal.versionsupport.Version;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class LifeSteal extends JavaPlugin implements Listener {
	
	private static LifeSteal $Instance;
	public static LifeSteal getInstance() {
		return $Instance;
	}
	
	@Override
	public void onLoad() {
		super.onLoad();
		$Instance = this;
	}
	
	@Override
	public void onEnable() {
		if(Version.get() == null) return;
		saveDefaultConfig();
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(this, this);
		pm.registerEvents(new OreBoost(), this);
	}
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onDeath(PlayerDeathEvent e) {
		
		Player p = e.getEntity();
		Member m = Member.get(p);
		
		if(m.getTimer() <= 0) {
			if(customDeathMessages())
				e.setDeathMessage(Language.get().playerDeath().replace("$player$", p.getName()));
		}else {
			Member k = Member.get(m.getLastHit());
			if(m.maxHealth()>1) {
				k.maxHealth(true);
				m.maxHealth(false);
			}
			m.timer = -1; // so if he respawns and die, his previous killer wont get a kill
			if(customDeathMessages())
				e.setDeathMessage(Language.get().playerKilledBy().replace("$player$", p.getName().replace("$killer$", m.getLastHit().getName())));
		}
		
	} 
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDamage(EntityDamageByEntityEvent e) {
		if(!(e.getEntity() instanceof Player)) return;
		Player p = (Player) e.getEntity();
		Member m = Member.get(p);
		
		if(e.getDamager() instanceof Player) {
			m.updateTimer((Player)e.getDamager());
			return;
		}
		
		Player d;
		if((d = Version.get().shouldUpdateTimer(p, e.getDamager())) != null) {
			m.updateTimer(d);
		}
	}

	public int getTimer() {
		return getConfig().getInt("timer", 15);
	}
	
	public boolean customDeathMessages() {
		return getConfig().getBoolean("custom-death-messages", true);
	}
	
	public boolean[] ironAndGoldPrevent() {
		return new boolean[] {getConfig().getBoolean("iron-prevent", true), getConfig().getBoolean("gold-prevent", true)};
	}
	
	public int oreBoost() {
		return Math.max(0, getConfig().getInt("ores-boost", 1));
		// Math.max(0, *) because of idiots that can put -1...
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onQuit(PlayerQuitEvent e) {
		Member m = Member.get(e.getPlayer());
		if(m.getTimer() > 0)
			m.getPlayer().setHealth(0);
		// still have to test
	}

	
} 
