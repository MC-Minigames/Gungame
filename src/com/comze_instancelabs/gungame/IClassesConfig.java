package com.comze_instancelabs.gungame;

import org.bukkit.plugin.java.JavaPlugin;

import com.comze_instancelabs.minigamesapi.config.ClassesConfig;

public class IClassesConfig extends ClassesConfig {

	public IClassesConfig(JavaPlugin plugin) {
		super(plugin, true);
		this.getConfig().options().header("Used for saving classes. Default class:");
		
		this.getConfig().addDefault("conf.kits.diamond1.name", "Diamond1");
		this.getConfig().addDefault("conf.kits.diamond1.items", "276#DAMAGE_ALL:1*1");
		this.getConfig().addDefault("conf.kits.diamond1.lore", "The Diamond Lv. 1 class. [50 GP]");
		this.getConfig().addDefault("conf.kits.diamond1.requires_money", true);
		this.getConfig().addDefault("conf.kits.diamond1.requires_permission", false);
		this.getConfig().addDefault("conf.kits.diamond1.money_amount", 50);
		this.getConfig().addDefault("conf.kits.diamond1.permission_node", "minigames.kits.diamond1");

		this.getConfig().addDefault("conf.kits.diamond2.name", "Diamond2");
		this.getConfig().addDefault("conf.kits.diamond2.items", "276#DAMAGE_ALL:4*1");
		this.getConfig().addDefault("conf.kits.diamond2.lore", "The Diamond Lv. 2 class. [120 GP]");
		this.getConfig().addDefault("conf.kits.diamond2.requires_money", true);
		this.getConfig().addDefault("conf.kits.diamond2.requires_permission", false);
		this.getConfig().addDefault("conf.kits.diamond2.money_amount", 120);
		this.getConfig().addDefault("conf.kits.diamond2.permission_node", "minigames.kits.diamond2");

		this.getConfig().addDefault("conf.kits.bow.name", "Bow");
		this.getConfig().addDefault("conf.kits.bow.items", "261#ARROW_DAMAGE:5*1");
		this.getConfig().addDefault("conf.kits.bow.lore", "The Bow class. [90 GP]");
		this.getConfig().addDefault("conf.kits.bow.requires_money", true);
		this.getConfig().addDefault("conf.kits.bow.requires_permission", false);
		this.getConfig().addDefault("conf.kits.bow.money_amount", 90);
		this.getConfig().addDefault("conf.kits.bow.permission_node", "minigames.kits.bow");

		this.getConfig().addDefault("conf.kits.heal.name", "Instant Heal");
		this.getConfig().addDefault("conf.kits.heal.items", "373:16421*3");
		this.getConfig().addDefault("conf.kits.heal.lore", "The Heal class. [30 GP]");
		this.getConfig().addDefault("conf.kits.heal.requires_money", true);
		this.getConfig().addDefault("conf.kits.heal.requires_permission", false);
		this.getConfig().addDefault("conf.kits.heal.money_amount", 30);
		this.getConfig().addDefault("conf.kits.heal.permission_node", "minigames.kits.heal");

		this.getConfig().addDefault("conf.kits.armor.name", "Armor");
		this.getConfig().addDefault("conf.kits.armor.items", "310*1;311*1;312*1;313*1");
		this.getConfig().addDefault("conf.kits.armor.lore", "The Armor class. [200 GP]");
		this.getConfig().addDefault("conf.kits.armor.requires_money", true);
		this.getConfig().addDefault("conf.kits.armor.requires_permission", false);
		this.getConfig().addDefault("conf.kits.armor.money_amount", 200);
		this.getConfig().addDefault("conf.kits.armor.permission_node", "minigames.kits.armor");

		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}

}
