package com.comze_instancelabs.gungame;

import java.util.ArrayList;

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

	public IClasses(Main m) {
		super(m);
		this.plugin = m;
	}

	@Override
	public void openGUI(String p_) {
		final Player p = Bukkit.getPlayer(p_);
		final FileConfiguration config = MinigamesAPI.getAPI().pinstances.get(plugin).getClassesConfig().getConfig();
		IconMenu iconm = new IconMenu("Shop", 9, new IconMenu.OptionClickEventHandler() {
			@Override
			public void onOptionClick(IconMenu.OptionClickEvent event) {
				String d = event.getName();
				for(AClass n : c){
					if(n.getName().equalsIgnoreCase(d)){
						int gp = config.getInt("conf.kits." + n.getName() + ".money_amount");
						int pgp = getConfig().isSet("player." + p.getName() + ".gp") ? getConfig().getInt("player." + p.getName() + ".gp") : 0;
						p.sendMessage(ChatColor.GREEN + "You need " + gp + " GP for " + event.getName() + ".");
						if(pgp > gp - 1){
							getConfig().set("player." + p.getName() + ".items." + event.getName(), "true");
							getConfig().set("player." + p.getName() + ".gp", getConfig().getInt("player." + p.getName() + ".gp") - gp);
							plugin.saveConfig();
							if(MinigamesAPI.getAPI().pinstances.get(plugin).global_players.containsKey(event.getPlayer().getName())){
								plugin.addextraitems(event.getPlayer());
							}
							p.sendMessage(ChatColor.GREEN + "Successfully purchased " + d + ".");
						}else{
							p.sendMessage(ChatColor.RED + "You don't have enough GP!");
						}
					}
				}
				/*if (d.equalsIgnoreCase("Diamond Sword Lv I")) {
					p.sendMessage("You need 50 gp for a " + event.getName());
					if (getConfig().getInt("player." + p.getName() + ".gp") > 49) {
						getConfig().set("player." + p.getName() + ".items.Diamond_Sword_Lv_I", "Diamond Sword Lv I");
						getConfig().set("player." + p.getName() + ".gp", getConfig().getInt("player." + p.getName() + ".gp") - 50);
						plugin.saveConfig();
						plugin.addextraitems(p);
					}
				} else if (d.equalsIgnoreCase("Diamond Sword Lv II")) {
					p.sendMessage("You need 120 gp for a " + event.getName());
					if (getConfig().getInt("player." + p.getName() + ".gp") > 119) {
						getConfig().set("player." + p.getName() + ".items.Diamond_Sword_Lv_II", "Diamond Sword Lv II");
						getConfig().set("player." + p.getName() + ".gp", getConfig().getInt("player." + p.getName() + ".gp") - 120);
						plugin.saveConfig();
						plugin.addextraitems(p);
					}
				} else if (d.equalsIgnoreCase("OP Bow")) {
					p.sendMessage("You need 80 gp for a " + event.getName());
					if (getConfig().getInt("player." + p.getName() + ".gp") > 79) {
						getConfig().set("player." + p.getName() + ".items.OP_Bow", "OP Bow");
						getConfig().set("player." + p.getName() + ".gp", getConfig().getInt("player." + p.getName() + ".gp") - 80);
						plugin.saveConfig();
						plugin.addextraitems(p);
					}
				} else if (d.equalsIgnoreCase("Instant Heal")) {
					p.sendMessage("You need 30 gp for a " + event.getName());
					if (getConfig().getInt("player." + p.getName() + ".gp") > 29) {
						getConfig().set("player." + p.getName() + ".items.Instant_Heal", "Instant Heal");
						getConfig().set("player." + p.getName() + ".gp", getConfig().getInt("player." + p.getName() + ".gp") - 30);
						plugin.saveConfig();
						plugin.addextraitems(p);
					}
				} else if (d.equalsIgnoreCase("Diamond Armor")) {
					p.sendMessage("You need 200 gp for a " + event.getName());
					if (getConfig().getInt("player." + p.getName() + ".gp") > 199) {
						getConfig().set("player." + p.getName() + ".items.Diamond_Armor", "Diamond Armor");
						getConfig().set("player." + p.getName() + ".gp", getConfig().getInt("player." + p.getName() + ".gp") - 200);
						plugin.saveConfig();
						plugin.addextraitems(p);
					}
				}*/
				event.setWillClose(true);
			}
		}, plugin);

		int count = 0;
		for (AClass n : c) {
			iconm.setOption(count, n.getItems()[0], n.getName(), config.getString("conf.kits." + n.getName() + ".lore"));
			count++;
		}

		iconm.open(p);
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
