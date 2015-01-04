package com.comze_instancelabs.gungame;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.comze_instancelabs.minigamesapi.Arena;
import com.comze_instancelabs.minigamesapi.util.Validator;
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

		int temp_lv = 0;

		if (m.items.size() < lv + 1) {
			if (m.first_to_max_wins) {
				Arena a = m.pli.global_players.get(p.getName());
				for (String p_ : a.getAllPlayers()) {
					if (!p_.equalsIgnoreCase(p.getName())) {
						m.pli.global_lost.put(p_, a);
					}
					if (Validator.isPlayerOnline(p_)) {
						Bukkit.getPlayer(p_).sendMessage(m.pli.getMessagesConfig().server_broadcast_winner.replaceAll("<arena>", a.getName()).replaceAll("<player>", p.getName()));
					}
				}
				a.stop();
			}
		}

		if (m.items.size() > lv) {
			temp_lv = lv;
		} else {
			// lv higher than 30 (default)
			temp_lv = m.items.size() - 1;
		}
		ArrayList<ItemStack> items = m.items.get(temp_lv);
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
			if ((item.getTypeId() > 297 && item.getTypeId() < 318)) {
				if (item.getTypeId() == 298 || item.getTypeId() == 302 || item.getTypeId() == 306 || item.getTypeId() == 310 || item.getTypeId() == 314) {
					p.getInventory().setHelmet(item);
				}
				if (item.getTypeId() == 299 || item.getTypeId() == 303 || item.getTypeId() == 307 || item.getTypeId() == 311 || item.getTypeId() == 315) {
					p.getInventory().setChestplate(item);
				}
				if (item.getTypeId() == 300 || item.getTypeId() == 304 || item.getTypeId() == 308 || item.getTypeId() == 312 || item.getTypeId() == 316) {
					p.getInventory().setLeggings(item);
				}
				if (item.getTypeId() == 301 || item.getTypeId() == 305 || item.getTypeId() == 309 || item.getTypeId() == 313 || item.getTypeId() == 317) {
					p.getInventory().setBoots(item);
				}
			} else {
				p.getInventory().addItem(item);
			}
		}
		p.updateInventory();

	}
}
