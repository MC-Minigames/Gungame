package com.comze_instancelabs.gungame;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import com.comze_instancelabs.minigamesapi.MinigamesAPI;
import com.comze_instancelabs.minigamesapi.util.Util;
import com.shampaggon.crackshot.CSUtility;

public class Level {

	public static void updatelv(Main m, HashMap<String, Integer> plv, Player p) {
		p.getInventory().clear();
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);

		int lv = plv.get(p.getName()) - 1;
		if (lv < 0) {
			lv = 0;
		}

		if (m.items.size() > lv) {
			ArrayList<ItemStack> items = m.items.get(lv);
			for (ItemStack item : items) {
				if (item.getItemMeta().hasDisplayName()) {
					if (item.getItemMeta().getDisplayName().startsWith("crackshot:")) {
						if (m.crackshot) {
							CSUtility cs = new CSUtility();
							cs.giveWeapon(p, item.getItemMeta().getDisplayName().split(":")[1], 1);
							continue;
						}
					}

				}
				if ((item.getTypeId() > 297 && item.getTypeId() < 302) || (item.getTypeId() > 305 && item.getTypeId() < 310) || (item.getTypeId() > 313 && item.getTypeId() < 318)) {
					if (item.getTypeId() == 298 || item.getTypeId() == 306 || item.getTypeId() == 314) {
						p.getInventory().setHelmet(item);
					}
					if (item.getTypeId() == 299 || item.getTypeId() == 307 || item.getTypeId() == 315) {
						p.getInventory().setChestplate(item);
					}
					if (item.getTypeId() == 300 || item.getTypeId() == 308 || item.getTypeId() == 316) {
						p.getInventory().setLeggings(item);
					}
					if (item.getTypeId() == 301 || item.getTypeId() == 309 || item.getTypeId() == 317) {
						p.getInventory().setBoots(item);
					}
				} else {
					p.getInventory().addItem(item);
				}
			}
		} else {

		}
		p.updateInventory();

	}
}
