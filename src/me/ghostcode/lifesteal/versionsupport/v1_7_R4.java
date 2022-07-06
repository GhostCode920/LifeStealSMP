package me.ghostcode.lifesteal.versionsupport;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;

final class v1_7_R4 extends Version {

	@Override
	public void sendActionBar(Player p, String content) {
		
	}
	
	@Override
	public Player shouldUpdateTimer(Player p, Entity d) {
		if(d instanceof Egg || d instanceof Snowball || d instanceof (Abstract)Arrow) {
			Projectile f = (Projectile) d;
			if(f.getShooter() instanceof Player)
				return (Player) f.getShooter();
		}
		return null;
	}

}
