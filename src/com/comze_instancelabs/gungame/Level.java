package com.comze_instancelabs.gungame;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class Level {

	public static void updatelv(HashMap <String, Integer> arenap, Player p1){
		switch(arenap.get(p1.getName())){
	        case 0:
	        	break;
	        case 1:
	        	p1.getInventory().clear();
	            p1.getInventory().setHelmet(null);
	            p1.getInventory().setChestplate(null);
	            p1.getInventory().setLeggings(null);
	            p1.getInventory().setBoots(null);
	            InventoryAdding.addtoinv(p1, Material.WOOD_SWORD, 1, "gunsword");
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	        	break;
	        case 2:
	        	p1.getInventory().clear();
	            p1.getInventory().setHelmet(null);
	            p1.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
	            p1.getInventory().setLeggings(null);
	            p1.getInventory().setBoots(null);
	            InventoryAdding.addtoinv(p1, Material.WOOD_SWORD, 1, "gunsword");
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	        	break;
	        case 3:
	        	p1.getInventory().clear();
	            p1.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
	            p1.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
	            p1.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
	            p1.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS, 1));
	            InventoryAdding.addtoinv(p1, Material.WOOD_SWORD, 1, "gunsword");
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            break;
	        case 4:
	        	p1.getInventory().clear();
	            p1.getInventory().setHelmet(null);
	            p1.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
	            p1.getInventory().setLeggings(null);
	            p1.getInventory().setBoots(null);
	            InventoryAdding.addtoinv(p1, Material.STONE_SWORD, 1, "gunsword");
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            break;
	        case 5:
	        	p1.getInventory().clear();
	            p1.getInventory().setHelmet(null);
	            p1.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
	            p1.getInventory().setLeggings(null);
	            p1.getInventory().setBoots(null);
	            InventoryAdding.addtoinv(p1, Material.STONE_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 1);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            break;
	        case 6:
	        	p1.getInventory().clear();
	            p1.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
	            p1.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
	            p1.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
	            p1.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
	            InventoryAdding.addtoinv(p1, Material.STONE_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 1);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            break;
	        case 7:
	        	p1.getInventory().clear();
	            p1.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
	            p1.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
	            p1.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
	            p1.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
	            InventoryAdding.addtoinv(p1, Material.STONE_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 1);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, new Potion(PotionType.INSTANT_HEAL), 1, "gunpotion");
	            break;
	        case 8:
	        	p1.getInventory().clear();
	            p1.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
	            p1.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
	            p1.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
	            p1.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
	            InventoryAdding.addtoinv(p1, Material.STONE_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 1);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 1);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            PotionEffect speed = PotionEffectType.SPEED.createEffect(99999999, 7);
	            p1.addPotionEffect(speed, true);
	            break;
	        case 9:
	        	p1.getInventory().clear();
	            p1.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
	            p1.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
	            p1.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
	            p1.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
	            InventoryAdding.addtoinv(p1, Material.STONE_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 2);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 1);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, new Potion(PotionType.INSTANT_HEAL), 1, "gunpotion");
	            InventoryAdding.addtoinv(p1, new Potion(PotionType.INSTANT_HEAL), 1, "gunpotion");
	            p1.getActivePotionEffects().clear();
	            break;
	        case 10:
	        	p1.getInventory().clear();
	            p1.getInventory().setHelmet(null);
	            //ItemStack it = new ItemStack(Material.IRON_CHESTPLATE, 1);
	            //it.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	            //p1.getInventory().setChestplate(it);
	            InventoryAdding.addtoinv(p1, "chestplate", Material.IRON_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	            p1.getInventory().setLeggings(null);
	            p1.getInventory().setBoots(null);
	            InventoryAdding.addtoinv(p1, Material.IRON_SWORD, 1, "gunsword");
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 2);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, new Potion(PotionType.INSTANT_HEAL), 1, "gunpotion");
	            break;
	        case 11:
	        	p1.getInventory().clear();
	            p1.getInventory().setHelmet(null);
	            InventoryAdding.addtoinv(p1, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 2);
	            p1.getInventory().setLeggings(null);
	            p1.getInventory().setBoots(null);
	            InventoryAdding.addtoinv(p1, Material.IRON_SWORD, 1, "gunsword");
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 2);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, new Potion(PotionType.WEAKNESS).splash(), 3, "gunpotion");
	            break;
	        case 12:
	        	p1.getInventory().clear();
	            p1.getInventory().setHelmet(null);
	            InventoryAdding.addtoinv(p1, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 2);
	            p1.getInventory().setLeggings(null);
	            p1.getInventory().setBoots(null);
	            InventoryAdding.addtoinv(p1, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 1);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, new Potion(PotionType.WEAKNESS).splash(), 3, "gunpotion");
	            break;
	        case 13:
	        	p1.getInventory().clear();
	        	InventoryAdding.addtoinv(p1, "helmet", Material.GOLD_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "leggings", Material.GOLD_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "boots", Material.GOLD_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	            InventoryAdding.addtoinv(p1, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 1);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            break;
	        case 14:
	        	p1.getInventory().clear();
	        	InventoryAdding.addtoinv(p1, "helmet", Material.GOLD_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "leggings", Material.GOLD_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "boots", Material.GOLD_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	            InventoryAdding.addtoinv(p1, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 1);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, new Potion(PotionType.INSTANT_DAMAGE).splash(), 1, "gunpotion");
	            PotionEffect speed1 = PotionEffectType.SPEED.createEffect(99999999, 7);
	            p1.addPotionEffect(speed1, true);
	            break;
	        case 15:
	        	p1.getInventory().clear();
	        	InventoryAdding.addtoinv(p1, "helmet", Material.GOLD_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "leggings", Material.GOLD_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "boots", Material.GOLD_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	            InventoryAdding.addtoinv(p1, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 1);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, new Potion(PotionType.INSTANT_DAMAGE).splash(), 2, "gunpotion");
	            PotionEffect speed2 = PotionEffectType.SPEED.createEffect(99999999, 7);
	            p1.addPotionEffect(speed2, true);
	            break;
	        case 16:
	        	p1.getInventory().clear();
	        	InventoryAdding.addtoinv(p1, "helmet", Material.GOLD_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "leggings", Material.GOLD_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "boots", Material.GOLD_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	            InventoryAdding.addtoinv(p1, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 2);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, new Potion(PotionType.INSTANT_HEAL), 2, "gunpotion");
	            p1.getActivePotionEffects().clear();
	            break;
	        case 17:
	        	p1.getInventory().clear();
	        	InventoryAdding.addtoinv(p1, "helmet", Material.GOLD_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "leggings", Material.GOLD_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "boots", Material.GOLD_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	            InventoryAdding.addtoinv(p1, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 2);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, new Potion(PotionType.INSTANT_HEAL), 2, "gunpotion");
	            PotionEffect speed3 = PotionEffectType.SPEED.createEffect(99999999, 7);
	            p1.addPotionEffect(speed3, true);
	            break;
	        case 18:
	        	p1.getInventory().clear();
	        	InventoryAdding.addtoinv(p1, "helmet", Material.GOLD_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "leggings", Material.GOLD_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "boots", Material.GOLD_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	            InventoryAdding.addtoinv(p1, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 2);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3, Enchantment.ARROW_KNOCKBACK, 1);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, new Potion(PotionType.INSTANT_HEAL), 1, "gunpotion");
	            p1.getActivePotionEffects().clear();
	            break;
	        case 19:
	        	p1.getInventory().clear();
	        	InventoryAdding.addtoinv(p1, "helmet", Material.GOLD_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "leggings", Material.GOLD_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "boots", Material.GOLD_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	            InventoryAdding.addtoinv(p1, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 2);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3, Enchantment.ARROW_KNOCKBACK, 1);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, new Potion(PotionType.INSTANT_HEAL), 1, "gunpotion");
	            PotionEffect sprung = PotionEffectType.JUMP.createEffect(99999999, 7);
	            p1.addPotionEffect(sprung, true);
	            break;
	        case 20:
	        	p1.getInventory().clear();
	        	InventoryAdding.addtoinv(p1, "helmet", Material.GOLD_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "leggings", Material.GOLD_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "boots", Material.GOLD_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	            InventoryAdding.addtoinv(p1, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 2, Enchantment.KNOCKBACK, 1);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3, Enchantment.ARROW_KNOCKBACK, 1);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, new Potion(PotionType.INSTANT_HEAL), 1, "gunpotion");
	            p1.getActivePotionEffects().clear();
	            break;
	        case 21:
	        	p1.getInventory().clear();
	        	InventoryAdding.addtoinv(p1, "helmet", Material.GOLD_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "leggings", Material.GOLD_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "boots", Material.GOLD_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	            InventoryAdding.addtoinv(p1, Material.GOLD_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 3);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3, Enchantment.ARROW_KNOCKBACK, 1);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, new Potion(PotionType.INSTANT_HEAL, 2), 1, "gunpotion");
	            p1.getActivePotionEffects().clear();
	            break;
	        case 22:
	        	p1.getInventory().clear();
	        	InventoryAdding.addtoinv(p1, "helmet", Material.GOLD_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "chestplate", Material.GOLD_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "leggings", Material.GOLD_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "boots", Material.GOLD_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	            InventoryAdding.addtoinv(p1, Material.GOLD_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 3);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3, Enchantment.ARROW_KNOCKBACK, 2);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, new Potion(PotionType.INSTANT_HEAL, 2), 1, "gunpotion");
	            InventoryAdding.addtoinv(p1, new Potion(PotionType.POISON).splash(), 1, "gunpotion");
	            break;
	        case 23:
	        	p1.getInventory().clear();
	        	p1.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET));
	        	InventoryAdding.addtoinv(p1, "chestplate", Material.IRON_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 2);
	        	p1.getInventory().setLeggings(null);
	        	p1.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS));
	            InventoryAdding.addtoinv(p1, Material.GOLD_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 3);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3, Enchantment.ARROW_KNOCKBACK, 2);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            break;
	        case 24:
	        	p1.getInventory().clear();
	        	p1.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET));
	        	InventoryAdding.addtoinv(p1, "chestplate", Material.IRON_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 2);
	        	p1.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS));
	        	p1.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS));
	            InventoryAdding.addtoinv(p1, Material.GOLD_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 3);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3, Enchantment.ARROW_KNOCKBACK, 2);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, new Potion(PotionType.POISON).splash(), 1, "gunpotion");
	            break;
	        case 25:
	        	p1.getInventory().clear();
	        	p1.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET));
	        	InventoryAdding.addtoinv(p1, "chestplate", Material.IRON_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 2);
	        	p1.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS));
	        	p1.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS));
	            InventoryAdding.addtoinv(p1, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 3);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 3, Enchantment.ARROW_KNOCKBACK, 2);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, new Potion(PotionType.INSTANT_HEAL, 2), 1, "gunpotion");
	            break;
	        case 26:
	        	p1.getInventory().clear();
	        	p1.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET));
	        	InventoryAdding.addtoinv(p1, "chestplate", Material.IRON_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 2);
	        	p1.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS));
	        	p1.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
	            InventoryAdding.addtoinv(p1, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 3);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 4);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, new Potion(PotionType.INSTANT_HEAL, 2), 1, "gunpotion");
	            break;
	        case 27:
	        	p1.getInventory().clear();
	        	p1.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
	        	InventoryAdding.addtoinv(p1, "chestplate", Material.IRON_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 2);
	        	p1.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
	        	p1.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
	            InventoryAdding.addtoinv(p1, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 3);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 4);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            InventoryAdding.addtoinv(p1, Material.ARROW, 64, "gunsarrow");
	            break;
	        case 28:
	        	p1.getInventory().clear();
	        	p1.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
	        	InventoryAdding.addtoinv(p1, "chestplate", Material.IRON_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 2);
	        	p1.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
	        	p1.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
	            InventoryAdding.addtoinv(p1, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 3);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 4, Enchantment.ARROW_INFINITE, 1);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 1, "gunsarrow");
	            break;
	        case 29:
	        	p1.getInventory().clear();
	        	p1.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
	        	InventoryAdding.addtoinv(p1, "chestplate", Material.IRON_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 2);
	        	p1.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
	        	p1.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
	            InventoryAdding.addtoinv(p1, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 3);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 4, Enchantment.ARROW_INFINITE, 1);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 1, "gunsarrow");
	            InventoryAdding.addtoinv(p1, new Potion(PotionType.INSTANT_HEAL, 2), 2, "gunpotion");
	            InventoryAdding.addtoinv(p1, new Potion(PotionType.POISON).splash(), 1, "gunpotion");
	            PotionEffect speed4 = PotionEffectType.SPEED.createEffect(99999999, 7);
	            p1.addPotionEffect(speed4, true);
	            break;
	        case 30:
	        	p1.getInventory().clear();
	        	InventoryAdding.addtoinv(p1, "helmet", Material.IRON_HELMET, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "chestplate", Material.IRON_CHESTPLATE, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "leggings", Material.IRON_LEGGINGS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	        	InventoryAdding.addtoinv(p1, "boots", Material.IRON_BOOTS, Enchantment.PROTECTION_ENVIRONMENTAL, 1);
	            InventoryAdding.addtoinv(p1, Material.IRON_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 3);
	            InventoryAdding.addtoinv(p1, Material.BOW, 1, "gunbow", Enchantment.ARROW_DAMAGE, 4, Enchantment.ARROW_INFINITE, 1);
	            InventoryAdding.addtoinv(p1, Material.ARROW, 1, "gunsarrow");
	            break;
	        default:
	        	p1.sendMessage("You reached an uber level, please contact ped4 to get a surprise.");
	    }
	}
}
