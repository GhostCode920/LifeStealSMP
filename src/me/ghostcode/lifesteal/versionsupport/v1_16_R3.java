package me.ghostcode.lifesteal.versionsupport;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

final class v1_16_R3 extends Version {

	@Override
	public void sendActionBar(Player p, String content) {
		p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(content));
	}

}
