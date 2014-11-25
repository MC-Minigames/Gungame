package com.comze_instancelabs.gungame;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class LevelsConfig {

	private FileConfiguration arenaConfig = null;
	private File arenaFile = null;
	private JavaPlugin plugin = null;

	public LevelsConfig(JavaPlugin plugin) {
		this.plugin = plugin;
		this.getConfig().options().header("All level upgrades from 0 to 30.");

		this.getConfig().addDefault("config.join_level_items", "268*1");
		if (this.getConfig().isSet("config.generatedv1")) {
			this.getConfig().addDefault("levels.level0.items", "268*1;261*1;262*64");
			this.getConfig().addDefault("levels.level1.items", "268*1;261*1;262*64;262*64;299*1");
			this.getConfig().addDefault("levels.level2.items", "268*1;261*1;262*64;262*64;299*1;298*1;300*1;301*1");
			this.getConfig().addDefault("levels.level3.items", "272*1;261*1;262*64;262*64;299*1");
			this.getConfig().addDefault("levels.level4.items", "272#DAMAGE_ALL:1*1;261*1;262*64;262*64;315*1");
			this.getConfig().addDefault("levels.level5.items", "272#DAMAGE_ALL:1*1;261*1;262*64;262*64;315*1;314*1;316*1;317*1");
			this.getConfig().addDefault("levels.level6.items", "272#DAMAGE_ALL:1*1;261*1;262*64;262*64;315*1;314*1;316*1;317*1;373:8197*1");
			this.getConfig().addDefault("levels.level7.items", "272#DAMAGE_ALL:1*1;261#ARROW_DAMAGE:1*1;262*64;262*64;315*1;314*1;316*1;317*1");
			this.getConfig().addDefault("levels.level8.items", "272#DAMAGE_ALL:1*1;261#ARROW_DAMAGE:1*1;262*64;262*64;315*1;314*1;316*1;317*1;373:8197*2");
			this.getConfig().addDefault("levels.level9.items", "267*1;261#ARROW_DAMAGE:2*1;262*64;262*64;307#PROTECTION_ENVIRONMENTAL:1*1;373:8197*1");
			this.getConfig().addDefault("levels.level10.items", "267*1;261#ARROW_DAMAGE:2*1;262*64;262*64;315#PROTECTION_ENVIRONMENTAL:2*1;373:16456*2");
			this.getConfig().addDefault("levels.level11.items", "267#DAMAGE_ALL:1*1;261#ARROW_DAMAGE:3*1;262*64;262*64;315#PROTECTION_ENVIRONMENTAL:2*1;373:16456*3");
			this.getConfig().addDefault("levels.level12.items", "267#DAMAGE_ALL:1*1;261#ARROW_DAMAGE:3*1;262*64;262*64;315#PROTECTION_ENVIRONMENTAL:1*1;314#PROTECTION_ENVIRONMENTAL:1*1;316#PROTECTION_ENVIRONMENTAL:1*1;317#PROTECTION_ENVIRONMENTAL:1*1");
			this.getConfig().addDefault("levels.level13.items", "267#DAMAGE_ALL:1*1;261#ARROW_DAMAGE:3*1;262*64;262*64;315#PROTECTION_ENVIRONMENTAL:1*1;314#PROTECTION_ENVIRONMENTAL:1*1;316#PROTECTION_ENVIRONMENTAL:1*1;317#PROTECTION_ENVIRONMENTAL:1*1;373:16428*1");
			this.getConfig().addDefault("levels.level14.items", "267#DAMAGE_ALL:1*1;261#ARROW_DAMAGE:3*1;262*64;262*64;315#PROTECTION_ENVIRONMENTAL:1*1;314#PROTECTION_ENVIRONMENTAL:1*1;316#PROTECTION_ENVIRONMENTAL:1*1;317#PROTECTION_ENVIRONMENTAL:1*1;373:16428*2");
			this.getConfig().addDefault("levels.level15.items", "267#DAMAGE_ALL:2*1;261#ARROW_DAMAGE:3*1;262*64;262*64;315#PROTECTION_ENVIRONMENTAL:1*1;314#PROTECTION_ENVIRONMENTAL:1*1;316#PROTECTION_ENVIRONMENTAL:1*1;317#PROTECTION_ENVIRONMENTAL:1*1;373:8197*3");
			this.getConfig().addDefault("levels.level16.items", "267#DAMAGE_ALL:2*1;261#ARROW_DAMAGE:3*1;262*64;262*64;315#PROTECTION_ENVIRONMENTAL:1*1;314#PROTECTION_ENVIRONMENTAL:1*1;316#PROTECTION_ENVIRONMENTAL:1*1;317#PROTECTION_ENVIRONMENTAL:1*1;373:8197*3");
			this.getConfig().addDefault("levels.level17.items", "267#DAMAGE_ALL:2*1;261#ARROW_DAMAGE:3#ARROW_KNOCKBACK:1*1;262*64;262*64;315#PROTECTION_ENVIRONMENTAL:1*1;314#PROTECTION_ENVIRONMENTAL:1*1;316#PROTECTION_ENVIRONMENTAL:1*1;317#PROTECTION_ENVIRONMENTAL:1*1;373:8197*3");
			this.getConfig().addDefault("levels.level18.items", "267#DAMAGE_ALL:2*1;261#ARROW_DAMAGE:3#ARROW_KNOCKBACK:1*1;262*64;262*64;315#PROTECTION_ENVIRONMENTAL:1*1;314#PROTECTION_ENVIRONMENTAL:1*1;316#PROTECTION_ENVIRONMENTAL:1*1;317#PROTECTION_ENVIRONMENTAL:1*1;373:8197*3");
			this.getConfig().addDefault("levels.level19.items", "267#DAMAGE_ALL:2#KNOCKBACK:1*1;261#ARROW_DAMAGE:3#ARROW_KNOCKBACK:1*1;262*64;262*64;315#PROTECTION_ENVIRONMENTAL:1*1;314#PROTECTION_ENVIRONMENTAL:1*1;316#PROTECTION_ENVIRONMENTAL:1*1;317#PROTECTION_ENVIRONMENTAL:1*1;373:8197*3");
			this.getConfig().addDefault("levels.level20.items", "267#DAMAGE_ALL:3*1;261#ARROW_DAMAGE:3#ARROW_KNOCKBACK:1*1;262*64;262*64;315#PROTECTION_ENVIRONMENTAL:1*1;314#PROTECTION_ENVIRONMENTAL:1*1;316#PROTECTION_ENVIRONMENTAL:1*1;317#PROTECTION_ENVIRONMENTAL:1*1;373:8197*3");
			this.getConfig().addDefault("levels.level21.items", "267#DAMAGE_ALL:3*1;261#ARROW_DAMAGE:3#ARROW_KNOCKBACK:2*1;262*64;262*64;315#PROTECTION_ENVIRONMENTAL:1*1;314#PROTECTION_ENVIRONMENTAL:1*1;316#PROTECTION_ENVIRONMENTAL:1*1;317#PROTECTION_ENVIRONMENTAL:1*1;373:8197*3;373:16388*1");
			this.getConfig().addDefault("levels.level22.items", "267#DAMAGE_ALL:3*1;261#ARROW_DAMAGE:3#ARROW_KNOCKBACK:2*1;262*64;262*64;314*1;307#PROTECTION_ENVIRONMENTAL:2*1;317*1");
			this.getConfig().addDefault("levels.level23.items", "267#DAMAGE_ALL:3*1;261#ARROW_DAMAGE:3#ARROW_KNOCKBACK:2*1;262*64;262*64;314*1;307#PROTECTION_ENVIRONMENTAL:2*1;316*1;317*1;373:16388*1");
			this.getConfig().addDefault("levels.level24.items", "267#DAMAGE_ALL:3*1;261#ARROW_DAMAGE:3#ARROW_KNOCKBACK:2*1;262*64;262*64;314*1;307#PROTECTION_ENVIRONMENTAL:2*1;316*1;317*1;373:8197*1");
			this.getConfig().addDefault("levels.level25.items", "267#DAMAGE_ALL:3*1;261#ARROW_DAMAGE:4*1;262*64;262*64;314*1;307#PROTECTION_ENVIRONMENTAL:2*1;316*1;309*1;373:8197*1");
			this.getConfig().addDefault("levels.level26.items", "267#DAMAGE_ALL:3*1;261#ARROW_DAMAGE:4*1;262*64;262*64;306*1;307#PROTECTION_ENVIRONMENTAL:2*1;308*1;309*1");
			this.getConfig().addDefault("levels.level27.items", "267#DAMAGE_ALL:3*1;261#ARROW_DAMAGE:4#ARROW_INFINITE:1*1;262*1;306*1;307#PROTECTION_ENVIRONMENTAL:2*1;308*1;309*1");
			this.getConfig().addDefault("levels.level28.items", "267#DAMAGE_ALL:3*1;261#ARROW_DAMAGE:4#ARROW_INFINITE:1*1;262*1;306*1;307#PROTECTION_ENVIRONMENTAL:2*1;308*1;309*1;373:8197*3;373:16388*1");
			this.getConfig().addDefault("levels.level29.items", "267#DAMAGE_ALL:3*1;261#ARROW_DAMAGE:4#ARROW_INFINITE:1*1;262*1;306#PROTECTION_ENVIRONMENTAL:1*1;307#PROTECTION_ENVIRONMENTAL:1*1;308#PROTECTION_ENVIRONMENTAL:1*1;309#PROTECTION_ENVIRONMENTAL:1*1");
		}

		this.getConfig().options().copyDefaults(true);
		this.saveConfig();

		this.getConfig().set("config.generatedv1", true);
		this.saveConfig();
	}

	public FileConfiguration getConfig() {
		if (arenaConfig == null) {
			reloadConfig();
		}
		return arenaConfig;
	}

	public void saveConfig() {
		if (arenaConfig == null || arenaFile == null) {
			return;
		}
		try {
			getConfig().save(arenaFile);
		} catch (IOException ex) {

		}
	}

	public void reloadConfig() {
		if (arenaFile == null) {
			arenaFile = new File(plugin.getDataFolder(), "levels.yml");
		}
		arenaConfig = YamlConfiguration.loadConfiguration(arenaFile);

		InputStream defConfigStream = plugin.getResource("levels.yml");
		if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
			arenaConfig.setDefaults(defConfig);
		}
	}
}
