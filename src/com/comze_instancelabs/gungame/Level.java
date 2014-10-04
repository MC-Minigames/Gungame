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

		boolean test = true;

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

		// TODO don't use the old stuff anymore
		if (test) {
			return;
		}

		switch (plv.get(p.getName())) {
		case 0:
			break;
		case 1:
			p.getInventory().clear();
			p.getInventory().setHelmet(null);
			p.getInventory().setChestplate(null);
			p.getInventory().setLeggings(null);
			p.getInventory().setBoots(null);
			InventoryAdding.addtoinv(p, Material.WOOD_SWORD, 1, "gunsword");
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			break;
		case 2:
			p.getInventory().clear();
			p.getInventory().setHelmet(null);
			p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
			p.getInventory().setLeggings(null);
			p.getInventory().setBoots(null);
			InventoryAdding.addtoinv(p, Material.WOOD_SWORD, 1, "gunsword");
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			break;
		case 3:
			p.getInventory().clear();
			p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
			p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
			p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
			p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS, 1));
			InventoryAdding.addtoinv(p, Material.WOOD_SWORD, 1, "gunsword");
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			break;
		case 4:
			p.getInventory().clear();
			p.getInventory().setHelmet(null);
			p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
			p.getInventory().setLeggings(null);
			p.getInventory().setBoots(null);
			InventoryAdding.addtoinv(p, Material.STONE_SWORD, 1, "gunsword");
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			break;
		case 5:
			p.getInventory().clear();
			p.getInventory().setHelmet(null);
			p.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
			p.getInventory().setLeggings(null);
			p.getInventory().setBoots(null);
			InventoryAdding.addtoinv(p, Material.STONE_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 1);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			break;
		case 6:
			p.getInventory().clear();
			p.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
			p.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
			p.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
			p.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
			InventoryAdding.addtoinv(p, Material.STONE_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 1);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			break;
		case 7:
			p.getInventory().clear();
			p.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
			p.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
			p.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
			p.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
			InventoryAdding.addtoinv(p, Material.STONE_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 1);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, new Potion(PotionType.INSTANT_HEAL), 1, "gunpotion");
			break;
		case 8:
			p.getInventory().clear();
			p.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
			p.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
			p.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
			p.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
			InventoryAdding.addtoinv(p, Material.STONE_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 1);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 1);
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			PotionEffect speed = PotionEffectType.SPEED.createEffect(99999999, 7);
			p.addPotionEffect(speed, true);
			break;
		case 9:
			p.getInventory().clear();
			p.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
			p.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
			p.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
			p.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
			InventoryAdding.addtoinv(p, Material.STONE_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 2);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 1);
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, new Potion(PotionType.INSTANT_HEAL), 1, "gunpotion");
			InventoryAdding.addtoinv(p, new Potion(PotionType.INSTANT_HEAL), 1, "gunpotion");
			p.getActivePotionEffects().clear();
			break;
		case 10:
			p.getInventory().clear();
			p.getInventory().setHelmet(null);
			// ItemStack it = new ItemStack(Material.IRON_CHESTPLATE, 1);
			// it.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			// p1.getInventory().setChestplate(it);
			InventoryAdding.addtoinv(p, "chestplate", Material.IRON_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			p.getInventory().setLeggings(null);
			p.getInventory().setBoots(null);
			InventoryAdding.addtoinv(p, Material.IRON_SWORD, 1, "gunsword");
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 2);
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, new Potion(PotionType.INSTANT_HEAL), 1, "gunpotion");
			break;
		case 11:
			p.getInventory().clear();
			p.getInventory().setHelmet(null);
			InventoryAdding.addtoinv(p, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			p.getInventory().setLeggings(null);
			p.getInventory().setBoots(null);
			InventoryAdding.addtoinv(p, Material.IRON_SWORD, 1, "gunsword");
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 2);
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, new Potion(PotionType.WEAKNESS).splash(), 3, "gunpotion");
			break;
		case 12:
			p.getInventory().clear();
			p.getInventory().setHelmet(null);
			InventoryAdding.addtoinv(p, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			p.getInventory().setLeggings(null);
			p.getInventory().setBoots(null);
			InventoryAdding.addtoinv(p, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 1);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3);
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, new Potion(PotionType.WEAKNESS).splash(), 3, "gunpotion");
			break;
		case 13:
			p.getInventory().clear();
			InventoryAdding.addtoinv(p, "helmet", Material.GOLD_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "leggings", Material.GOLD_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "boots", Material.GOLD_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 1);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3);
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			break;
		case 14:
			p.getInventory().clear();
			InventoryAdding.addtoinv(p, "helmet", Material.GOLD_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "leggings", Material.GOLD_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "boots", Material.GOLD_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 1);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3);
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, new Potion(PotionType.INSTANT_DAMAGE).splash(), 1, "gunpotion");
			PotionEffect speed1 = PotionEffectType.SPEED.createEffect(99999999, 7);
			p.addPotionEffect(speed1, true);
			break;
		case 15:
			p.getInventory().clear();
			InventoryAdding.addtoinv(p, "helmet", Material.GOLD_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "leggings", Material.GOLD_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "boots", Material.GOLD_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 1);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3);
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, new Potion(PotionType.INSTANT_DAMAGE).splash(), 2, "gunpotion");
			PotionEffect speed2 = PotionEffectType.SPEED.createEffect(99999999, 7);
			p.addPotionEffect(speed2, true);
			break;
		case 16:
			p.getInventory().clear();
			InventoryAdding.addtoinv(p, "helmet", Material.GOLD_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "leggings", Material.GOLD_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "boots", Material.GOLD_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 2);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3);
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, new Potion(PotionType.INSTANT_HEAL), 2, "gunpotion");
			p.getActivePotionEffects().clear();
			break;
		case 17:
			p.getInventory().clear();
			InventoryAdding.addtoinv(p, "helmet", Material.GOLD_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "leggings", Material.GOLD_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "boots", Material.GOLD_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 2);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3);
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, new Potion(PotionType.INSTANT_HEAL), 2, "gunpotion");
			PotionEffect speed3 = PotionEffectType.SPEED.createEffect(99999999, 7);
			p.addPotionEffect(speed3, true);
			break;
		case 18:
			p.getInventory().clear();
			InventoryAdding.addtoinv(p, "helmet", Material.GOLD_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "leggings", Material.GOLD_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "boots", Material.GOLD_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 2);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3, Enchantment.ARROW_KNOCKBACK, 1);
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, new Potion(PotionType.INSTANT_HEAL), 1, "gunpotion");
			p.getActivePotionEffects().clear();
			break;
		case 19:
			p.getInventory().clear();
			InventoryAdding.addtoinv(p, "helmet", Material.GOLD_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "leggings", Material.GOLD_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "boots", Material.GOLD_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 2);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3, Enchantment.ARROW_KNOCKBACK, 1);
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, new Potion(PotionType.INSTANT_HEAL), 1, "gunpotion");
			PotionEffect sprung = PotionEffectType.JUMP.createEffect(99999999, 7);
			p.addPotionEffect(sprung, true);
			break;
		case 20:
			p.getInventory().clear();
			InventoryAdding.addtoinv(p, "helmet", Material.GOLD_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "leggings", Material.GOLD_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "boots", Material.GOLD_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 2, Enchantment.KNOCKBACK, 1);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3, Enchantment.ARROW_KNOCKBACK, 1);
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, new Potion(PotionType.INSTANT_HEAL), 1, "gunpotion");
			p.getActivePotionEffects().clear();
			break;
		case 21:
			p.getInventory().clear();
			InventoryAdding.addtoinv(p, "helmet", Material.GOLD_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "leggings", Material.GOLD_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "boots", Material.GOLD_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, Material.GOLD_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 3);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3, Enchantment.ARROW_KNOCKBACK, 1);
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, new Potion(PotionType.INSTANT_HEAL, 2), 1, "gunpotion");
			p.getActivePotionEffects().clear();
			break;
		case 22:
			p.getInventory().clear();
			InventoryAdding.addtoinv(p, "helmet", Material.GOLD_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "leggings", Material.GOLD_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "boots", Material.GOLD_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, Material.GOLD_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 3);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3, Enchantment.ARROW_KNOCKBACK, 2);
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, new Potion(PotionType.INSTANT_HEAL, 2), 1, "gunpotion");
			InventoryAdding.addtoinv(p, new Potion(PotionType.POISON).splash(), 1, "gunpotion");
			break;
		case 23:
			p.getInventory().clear();
			p.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET));
			InventoryAdding.addtoinv(p, "chestplate", Material.IRON_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			p.getInventory().setLeggings(null);
			p.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS));
			InventoryAdding.addtoinv(p, Material.GOLD_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 3);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3, Enchantment.ARROW_KNOCKBACK, 2);
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			break;
		case 24:
			p.getInventory().clear();
			p.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET));
			InventoryAdding.addtoinv(p, "chestplate", Material.IRON_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			p.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS));
			p.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS));
			InventoryAdding.addtoinv(p, Material.GOLD_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 3);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3, Enchantment.ARROW_KNOCKBACK, 2);
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, new Potion(PotionType.POISON).splash(), 1, "gunpotion");
			break;
		case 25:
			p.getInventory().clear();
			p.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET));
			InventoryAdding.addtoinv(p, "chestplate", Material.IRON_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			p.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS));
			p.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS));
			InventoryAdding.addtoinv(p, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 3);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3, Enchantment.ARROW_KNOCKBACK, 2);
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, new Potion(PotionType.INSTANT_HEAL, 2), 1, "gunpotion");
			break;
		case 26:
			p.getInventory().clear();
			p.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET));
			InventoryAdding.addtoinv(p, "chestplate", Material.IRON_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			p.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS));
			p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
			InventoryAdding.addtoinv(p, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 3);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 4);
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, new Potion(PotionType.INSTANT_HEAL, 2), 1, "gunpotion");
			break;
		case 27:
			p.getInventory().clear();
			p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
			InventoryAdding.addtoinv(p, "chestplate", Material.IRON_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
			p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
			InventoryAdding.addtoinv(p, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 3);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 4);
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			InventoryAdding.addtoinv(p, Material.ARROW, 64, "gunsarrow");
			break;
		case 28:
			p.getInventory().clear();
			p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
			InventoryAdding.addtoinv(p, "chestplate", Material.IRON_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
			p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
			InventoryAdding.addtoinv(p, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 3);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 4, Enchantment.ARROW_INFINITE, 1);
			InventoryAdding.addtoinv(p, Material.ARROW, 1, "gunsarrow");
			break;
		case 29:
			p.getInventory().clear();
			p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
			InventoryAdding.addtoinv(p, "chestplate", Material.IRON_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
			p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
			InventoryAdding.addtoinv(p, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 3);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 4, Enchantment.ARROW_INFINITE, 1);
			InventoryAdding.addtoinv(p, Material.ARROW, 1, "gunsarrow");
			InventoryAdding.addtoinv(p, new Potion(PotionType.INSTANT_HEAL, 2), 2, "gunpotion");
			InventoryAdding.addtoinv(p, new Potion(PotionType.POISON).splash(), 1, "gunpotion");
			PotionEffect speed4 = PotionEffectType.SPEED.createEffect(99999999, 7);
			p.addPotionEffect(speed4, true);
			break;
		case 30:
			p.getInventory().clear();
			InventoryAdding.addtoinv(p, "helmet", Material.IRON_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "chestplate", Material.IRON_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "leggings", Material.IRON_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, "boots", Material.IRON_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
			InventoryAdding.addtoinv(p, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 3);
			InventoryAdding.addtoinv(p, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 4, Enchantment.ARROW_INFINITE, 1);
			InventoryAdding.addtoinv(p, Material.ARROW, 1, "gunsarrow");
			break;
		default:
			p.sendMessage(ChatColor.AQUA + "You reached the maximum level, congrats. Now try to stay on the top of the leaderboards or get yourself some good stuff from the shop.");
		}
	}
}
