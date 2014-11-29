package com.comze_instancelabs.gungame;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.comze_instancelabs.minigamesapi.Classes;
import com.comze_instancelabs.minigamesapi.MinigamesAPI;
import com.comze_instancelabs.minigamesapi.util.AClass;
import com.comze_instancelabs.minigamesapi.util.IconMenu;
import com.comze_instancelabs.minigamesapi.util.Util;

public class IClasses extends Classes {

	Main plugin;

	public ArrayList<AClass> c = new ArrayList<AClass>();
	public HashMap<String, IconMenu> lasticonm = new HashMap<String, IconMenu>();

	public IClasses(Main m) {
		super(m);
		this.plugin = m;
	}

	@Override
	public void openGUI(final String p_) {
		final Player p = Bukkit.getPlayer(p_);
		final FileConfiguration config = MinigamesAPI.getAPI().pinstances.get(plugin).getClassesConfig().getConfig();
		IconMenu iconm;
		if (lasticonm.containsKey(p.getName())) {
			iconm = lasticonm.get(p.getName());
		} else {
			iconm = new IconMenu("Shop", 9, new IconMenu.OptionClickEventHandler() {
				@Override
				public void onOptionClick(IconMenu.OptionClickEvent event) {
					String d = event.getName();
					if (event.getPlayer().getName().equalsIgnoreCase(p_)) {
						for (AClass n : c) {
							if (n.getName().equalsIgnoreCase(d)) {
								int gp = config.getInt("conf.kits." + n.getName() + ".money_amount");
								int pgp = getConfig().isSet("player." + p.getName() + ".gp") ? getConfig().getInt("player." + p.getName() + ".gp") : 0;
								p.sendMessage(ChatColor.GREEN + "You need " + gp + " GP for " + event.getName() + ".");
								if (pgp > gp - 1) {
									getConfig().set("player." + p.getName() + ".items." + event.getName(), "true");
									getConfig().set("player." + p.getName() + ".gp", getConfig().getInt("player." + p.getName() + ".gp") - gp);
									plugin.saveConfig();
									if (MinigamesAPI.getAPI().pinstances.get(plugin).global_players.containsKey(event.getPlayer().getName())) {
										plugin.addextraitems(event.getPlayer());
									}
									p.sendMessage(ChatColor.GREEN + "Successfully purchased " + d + ".");
								} else {
									p.sendMessage(ChatColor.RED + "You don't have enough GP!");
								}
							}
						}
					}
					event.setWillClose(true);
				}
			}, plugin);
		}
		int count = 0;
		for (AClass n : c) {
			iconm.setOption(count, n.getItems()[0], n.getName(), config.getString("conf.kits." + n.getName() + ".lore"));
			count++;
		}

		iconm.open(p);
		lasticonm.put(p.getName(), iconm);
	}

	public FileConfiguration getConfig() {
		return plugin.getConfig();
	}

	@Override
	public void loadClasses() {
		FileConfiguration config = MinigamesAPI.getAPI().pinstances.get(plugin).getClassesConfig().getConfig();
		if (config.isSet("conf.kits")) {
			for (String aclass : config.getConfigurationSection("conf.kits.").getKeys(false)) {
				AClass n = new AClass(plugin, aclass, Util.parseItems(config.getString("conf.kits." + aclass + ".items")));
				c.add(n);
			}
		}
	}

}
