package com.comze_instancelabs.gungame;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.comze_instancelabs.minigamesapi.config.MessagesConfig;

public class IMessagesConfig extends MessagesConfig {

	public String broadcast_next_map = "&6Next map on map rotation in &c10 &6seconds!";

	public IMessagesConfig(JavaPlugin arg0) {
		super(arg0);

		this.getConfig().addDefault("messages.broadcast_next_map", broadcast_next_map);

		this.getConfig().options().copyDefaults(true);
		this.saveConfig();

		this.broadcast_next_map = ChatColor.translateAlternateColorCodes('&', getConfig().getString("messages.broadcast_next_map"));
	}

}
