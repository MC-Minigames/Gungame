package com.comze_instancelabs.gungame;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;

public class InventoryAdding {

	public static void addtoinv(Player p, Material m, Integer count, String name){
		ItemStack newitem = new ItemStack(m, count);
	    ItemMeta newmeta = (ItemMeta) newitem.getItemMeta();
	    newmeta.setDisplayName(name);
	    newitem.setItemMeta(newmeta);
	    p.getInventory().addItem(newitem);
	    p.updateInventory();
    }
    
    public static void addtoinv(Player p, Potion m, Integer count, String name){
    	ItemStack newitem = m.toItemStack(count);
        ItemMeta newmeta = (ItemMeta) newitem.getItemMeta();
        newmeta.setDisplayName(name);
        newitem.setItemMeta(newmeta);
        p.getInventory().addItem(newitem);
        p.updateInventory();
    }
    
    public static void addtoinv(Player p, String armor, Material m, Enchantment ench, Integer level){
    	if(armor.equalsIgnoreCase("helmet")){
            ItemStack it = new ItemStack(m, 1);
            it.addEnchantment(ench, level);
            p.getInventory().setHelmet(it);
    	}else if(armor.equalsIgnoreCase("chestplate")){
    		ItemStack it = new ItemStack(m, 1);
            it.addEnchantment(ench, level);
            p.getInventory().setChestplate(it);
    	}else if(armor.equalsIgnoreCase("leggings")){
    		ItemStack it = new ItemStack(m, 1);
            it.addEnchantment(ench, level);
            p.getInventory().setLeggings(it);
    	}else if(armor.equalsIgnoreCase("boots")){
    		ItemStack it = new ItemStack(m, 1);
            it.addEnchantment(ench, level);
            p.getInventory().setBoots(it);
    	}
    }

    public static void addtoinv(Player p, Material m, Integer count, String name, Enchantment ench, int lv){
		ItemStack newitem = new ItemStack(m, count);
		newitem.addEnchantment(ench, lv);
		ItemMeta newmeta = (ItemMeta) newitem.getItemMeta();
		newmeta.setDisplayName(name);
		newitem.setItemMeta(newmeta);
		p.getInventory().addItem(newitem);
		p.updateInventory();
    }
   
    public static void addtoinv(Player p, Material m, Integer count, String name, Enchantment ench, int lv, Enchantment ench1, int lv1){
		ItemStack newitem = new ItemStack(m, count);
		newitem.addEnchantment(ench, lv);
		newitem.addEnchantment(ench1, lv1);
		ItemMeta newmeta = (ItemMeta) newitem.getItemMeta();
		newmeta.setDisplayName(name);
		newitem.setItemMeta(newmeta);
		p.getInventory().addItem(newitem);
		p.updateInventory();
    }
	
}
