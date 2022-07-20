package me.ghostcode.lifesteal.versionsupport;

import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;

import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutChat;

// done
final class v1_8_R1 extends Version {
	
	@Override
	public int id() {
		return 81;
	}

	@Override
	public void sendActionBar(Player p, String content) {
		((CraftPlayer)p).getHandle().playerConnection.sendPacket(new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\": \""+content+"\"}"), (byte)2));
	}
	
	@Override
	public Player shouldUpdateTimer(Player p, Entity d) {
		if(d instanceof Egg || d instanceof Snowball || d instanceof Arrow) {
			Projectile f = (Projectile) d;
			if(f.getShooter() instanceof Player)
				return (Player) f.getShooter();
		}
		return null;
	}

}
