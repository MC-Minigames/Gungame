package com.comze_instancelabs.gungame;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.comze_instancelabs.minigamesapi.config.DefaultConfig;

public class IDefaultConfig extends DefaultConfig {

	public IDefaultConfig(JavaPlugin plugin) {
		super(plugin, false);
		IDefaultConfig.init(plugin);
	}

	public static void init(JavaPlugin plugin) {
		FileConfiguration config = plugin.getConfig();
		config.addDefault("config.classes_selection_item", 399);
		config.addDefault("config.default_max_players", 4);
		config.addDefault("config.default_min_players", 2);
		config.addDefault("config.lobby_countdown", 0);
		config.addDefault("config.ingame_countdown", 0);
		config.addDefault("config.rewards.economy", true);
		config.addDefault("config.rewards.economy_reward", 10);
		config.addDefault("config.rewards.item_reward", false);
		config.addDefault("config.rewards.item_reward_ids", "264*1;11*1");
		config.addDefault("config.rewards.command_reward", false);
		config.addDefault("config.rewards.command", "pex user <player> add SKILLZ.*");
		config.addDefault("config.arcade.min_players", 1);
		config.addDefault("config.arcade.max_players", 16);
		config.options().copyDefaults(true);
		plugin.saveConfig();
	}

}
