package me.ghostcode.lifesteal.versionsupport;

import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

// done
final class v1_16_R2 extends Version {
	
	@Override
	public int id() {
		return 162;
	}

	@Override
	public void sendActionBar(Player p, String content) {
		p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(content));
	}
	
	@Override
	public Player shouldUpdateTimer(Player p, Entity d) {
		if(d instanceof Egg || d instanceof Snowball || d instanceof AbstractArrow) {
			Projectile f = (Projectile) d;
			if(f.getShooter() instanceof Player)
				return (Player) f.getShooter();
		}
		return null;
	}

}
