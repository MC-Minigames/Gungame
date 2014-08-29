package com.comze_instancelabs.gungame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;

import com.comze_instancelabs.gungame.sql.MainSQL;
import com.comze_instancelabs.minigamesapi.Arena;
import com.comze_instancelabs.minigamesapi.ArenaSetup;
import com.comze_instancelabs.minigamesapi.ArenaState;
import com.comze_instancelabs.minigamesapi.MinigamesAPI;
import com.comze_instancelabs.minigamesapi.PluginInstance;
import com.comze_instancelabs.minigamesapi.config.ArenasConfig;
import com.comze_instancelabs.minigamesapi.config.MessagesConfig;
import com.comze_instancelabs.minigamesapi.config.StatsConfig;
import com.comze_instancelabs.minigamesapi.util.AClass;
import com.comze_instancelabs.minigamesapi.util.Util;
import com.comze_instancelabs.minigamesapi.util.Validator;

public class Main extends JavaPlugin implements Listener {

	MinigamesAPI api = null;
	PluginInstance pli = null;
	static Main m = null;
	IArenaScoreboard scoreboard = new IArenaScoreboard(this);

	HashMap<String, Integer> lv = new HashMap<String, Integer>();
	IClasses icl;

	ICommandHandler cmd;

	MainSQL mainsql;

	public void onEnable() {
		m = this;
		api = MinigamesAPI.getAPI().setupAPI(this, "gungame", IArena.class, new ArenasConfig(this), new MessagesConfig(this), new IClassesConfig(this), new StatsConfig(this, false), new IDefaultConfig(this), true);
		PluginInstance pinstance = api.pinstances.get(this);
		pinstance.addLoadedArenas(loadArenas(this, pinstance.getArenasConfig()));
		Bukkit.getPluginManager().registerEvents(this, this);
		pinstance.scoreboardManager = new IArenaScoreboard(this);
		icl = new IClasses(this);
		pinstance.setClassesHandler(icl);
		IArenaListener t = new IArenaListener(this, pinstance);
		api.registerArenaListenerLater(this, t);
		pinstance.setArenaListener(t);
		pli = pinstance;
		icl.loadClasses();

		cmd = new ICommandHandler();

		mainsql = new MainSQL(this, true);
		mainsql.createTables();
	}

	public static ArrayList<Arena> loadArenas(JavaPlugin plugin, ArenasConfig cf) {
		ArrayList<Arena> ret = new ArrayList<Arena>();
		FileConfiguration config = cf.getConfig();
		if (!config.isSet("arenas")) {
			return ret;
		}
		for (String arena : config.getConfigurationSection("arenas.").getKeys(false)) {
			if (Validator.isArenaValid(plugin, arena, cf.getConfig())) {
				ret.add(initArena(arena));
			}
		}
		return ret;
	}

	public static IArena initArena(String arena) {
		IArena a = new IArena(m, arena);
		ArenaSetup s = MinigamesAPI.getAPI().pinstances.get(m).arenaSetup;
		a.init(Util.getSignLocationFromArena(m, arena), Util.getAllSpawns(m, arena), Util.getMainLobby(m), Util.getComponentForArena(m, arena, "lobby"), s.getPlayerCount(m, arena, true), s.getPlayerCount(m, arena, false), s.getArenaVIP(m, arena));
		return a;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("gg")) {
			this.cmd.handleArgs(this, "gungame", "/" + cmd.getName(), sender, args);
			if (args.length > 0) {
				if (args[0].equalsIgnoreCase("shop")) {
					if (sender instanceof Player) {
						icl.openGUI(((Player) sender).getName());
					}
				} else if (args[0].equalsIgnoreCase("leaderboards") || args[0].equalsIgnoreCase("lb")) {
					sender.sendMessage("§aLeaderboards:\n" + this.getTop5());
				}
			}
			return true;
		} else if (cmd.getName().equalsIgnoreCase("gp")) {
			if (sender instanceof Player) {
				int i = getConfig().isSet("player." + sender.getName() + ".gp") ? getConfig().getInt("player." + sender.getName() + ".gp") : 0;
				sender.sendMessage(ChatColor.GREEN + "You have " + ChatColor.DARK_GREEN + i + ChatColor.GREEN + " GP. You can buy better gear with /gg shop.");
			}
			return true;
		}
		return true;
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		if (event.getEntity().getKiller() != null) {
			if (event.getEntity().getKiller() instanceof Player && event.getEntity() instanceof Player && pli.global_players.containsKey(event.getEntity().getName()) && pli.global_players.containsKey(event.getEntity().getKiller().getName())) {
				event.getEntity().setHealth(20);
				String killername = event.getEntity().getKiller().getName();
				String entityKilled = event.getEntity().getName();
				// getLogger().info(killername + " killed " + entityKilled);
				try {
					pli.getRewardsInstance().giveKillReward(killername, 2);
				} catch (Exception e) {
					System.out.println("Please update MinigamesLib to the latest version to enable kill rewards.");
				}
				final Player p1 = event.getEntity().getKiller();
				final Player p2 = event.getEntity();

				IArena a = (IArena) pli.global_players.get(p1.getName());
				Util.teleportPlayerFixed(p2, a.getSpawns().get(0));

				// gp updaten:
				Integer gpkiller = 2;
				Integer gploser = 0;
				if (getConfig().isSet("player." + killername)) {
					gpkiller = getConfig().getInt("player." + killername + ".gp") + 2; // +2 gp
				}
				if (getConfig().isSet("player." + entityKilled)) {
					gploser = Math.max(getConfig().getInt("player." + entityKilled + ".gp") - 1, 0); // -1 gp
				}
				getConfig().set("player." + killername + ".gp", gpkiller);
				getConfig().set("player." + entityKilled + ".gp", gploser);
				this.saveConfig();

				try {
					mainsql.updateStats(p1.getName(), 2);
					mainsql.updateStats(p2.getName(), -1);
				} catch (Exception e) {
					System.out.println("Failed updating sql gp.");
				}

				Bukkit.getScheduler().runTaskLater(this, new Runnable() {
					public void run() {
						p2.getInventory().clear();
						p2.getInventory().setHelmet(null);
						p2.getInventory().setChestplate(null);
						p2.getInventory().setLeggings(null);
						p2.getInventory().setBoots(null);
						p2.getInventory().setArmorContents(null);
						ItemStack selectwand = new ItemStack(Material.WOOD_SWORD, 1);
						ItemMeta meta = (ItemMeta) selectwand.getItemMeta();
						meta.setDisplayName("Gunsword");
						selectwand.setItemMeta(meta);
						p2.getInventory().addItem(selectwand);
						p2.updateInventory();

						m.addextraitems(p1);
						m.addextraitems(p2);
					}
				}, 20L);

				p2.playSound(p2.getLocation(), Sound.CAT_MEOW, 1F, 1);

				p2.setFoodLevel(20);

				lv.put(p2.getName(), 0);

				ArrayList<String> keys = new ArrayList<String>();
				if (!getConfig().isConfigurationSection("player." + p2.getName() + ".items")) {
					// getLogger().info("The killed player has no special items.");
				} else {
					keys.addAll(getConfig().getConfigurationSection("player." + p2.getName() + ".items").getKeys(false));
					for (int i = 0; i < keys.size(); i++) {
						getConfig().set("player." + p2.getName() + ".items." + keys.get(i), null);
						this.saveConfig();
					}
					getConfig().set("player." + p2.getName() + ".items", null);
					this.saveConfig();
				}

				for (PotionEffect effect : p2.getActivePotionEffects())
					p2.removePotionEffect(effect.getType());

				for (PotionEffect effect : p1.getActivePotionEffects())
					p1.removePotionEffect(effect.getType());

				p1.playEffect(p1.getLocation(), Effect.POTION_BREAK, 5);
				Integer current = lv.get(p1.getName());
				lv.put(p1.getName(), current + 1);
				p1.sendMessage(ChatColor.GREEN + "You got an upgrade: " + lv.get(p1.getName()));
				Level.updatelv(lv, p1);

				scoreboard.updateScoreboard(a);

				p1.setFoodLevel(20);
				p1.setHealth(20);
				p2.setHealth(20);
				p2.setFoodLevel(20);

				this.addextraitems(p1);
				this.addextraitems(p2);
			}
		} else {
			// death by something else -> respawn

			event.getEntity().setHealth(20);
			if (event.getEntity() != null) {
				if (event.getEntity() instanceof Player) {
					final Player p = (Player) event.getEntity();
					IArena a = (IArena) pli.global_players.get(p.getName());
					if (a != null && p != null) {
						Util.teleportPlayerFixed(p, a.getSpawns().get(0));
					} else {
						return;
					}

					p.playSound(p.getLocation(), Sound.CAT_MEOW, 1F, 1);

					p.setFoodLevel(20);

					lv.put(p.getName(), 0);

					Bukkit.getScheduler().runTaskLater(this, new Runnable() {
						public void run() {
							p.getInventory().clear();
							p.getInventory().setHelmet(null);
							p.getInventory().setChestplate(null);
							p.getInventory().setLeggings(null);
							p.getInventory().setBoots(null);
							p.getInventory().setArmorContents(null);
							ItemStack selectwand = new ItemStack(Material.WOOD_SWORD, 1);
							ItemMeta meta = (ItemMeta) selectwand.getItemMeta();
							meta.setDisplayName("Gunsword");
							selectwand.setItemMeta(meta);
							p.getInventory().addItem(selectwand);
							p.updateInventory();

							m.addextraitems(p);
						}
					}, 20L);

					for (PotionEffect effect : p.getActivePotionEffects())
						p.removePotionEffect(effect.getType());

					p.setHealth(20);
					p.setFoodLevel(20);

					this.addextraitems(p);
				}
			}
		}
	}

	@EventHandler
	public void onmove(PlayerMoveEvent event) {
		if (pli.global_players.containsKey(event.getPlayer().getName())) {
			int x = event.getFrom().getBlockX();
			int fromy = event.getFrom().getBlockY();
			int y = fromy;
			int z = event.getFrom().getBlockZ();
			Location loc = new Location(event.getFrom().getWorld(), x, y, z);

			IArena a = (IArena) pli.global_players.get(event.getPlayer().getName());

			if (loc.getBlock().isLiquid()) {
				Player p2 = event.getPlayer();
				p2.getInventory().clear();
				p2.getInventory().setHelmet(null);
				p2.getInventory().setChestplate(null);
				p2.getInventory().setLeggings(null);
				p2.getInventory().setBoots(null);
				Util.teleportPlayerFixed(p2, a.getSpawns().get(0));

				ArrayList<String> keys = new ArrayList<String>();
				if (!getConfig().isConfigurationSection("player." + p2.getName() + ".items")) {
					// getLogger().info("The killed player has no special items.");
				} else {
					keys.addAll(getConfig().getConfigurationSection("player." + p2.getName() + ".items").getKeys(false));
					for (int i = 0; i < keys.size(); i++) {
						getConfig().set("player." + p2.getName() + ".items." + keys.get(i), null);
						this.saveConfig();
					}
					getConfig().set("player." + p2.getName() + ".items", null);
					this.saveConfig();
				}

				// add the sword again:
				ItemStack selectwand = new ItemStack(Material.WOOD_SWORD, 1);
				ItemMeta meta = (ItemMeta) selectwand.getItemMeta();
				meta.setDisplayName("gunsword");
				selectwand.setItemMeta(meta);
				event.getPlayer().getInventory().addItem(selectwand);
				event.getPlayer().updateInventory();

				lv.put(p2.getName(), 0);

				scoreboard.updateScoreboard(a);
				boolean continue_ = true;
				Player p1 = null;
				try {
					EntityDamageByEntityEvent e = (EntityDamageByEntityEvent) event.getPlayer().getLastDamageCause();
					p1 = (Player) e.getDamager();
				} catch (Exception ex) {
					continue_ = false;
				}

				p2.setHealth(20);
				p2.setFoodLevel(20);

				if (continue_) {
					p1.setFoodLevel(20);
					p1.setHealth(20);

					String killerName = p1.getName();
					String entityKilled = event.getPlayer().getName();

					try {
						pli.getRewardsInstance().giveKillReward(killerName, 2);
					} catch (Exception e) {
						System.out.println("Please update MinigamesLib to the latest version to enable kill rewards.");
					}

					Integer gpkiller = 0;
					Integer gploser = 0;
					if (getConfig().isSet("player." + killerName)) {
						gpkiller = getConfig().getInt("player." + killerName + ".gp") + 2; // +2 gp!
					}
					if (getConfig().isSet("player." + entityKilled)) {
						gploser = getConfig().getInt("player." + entityKilled + ".gp") - 1; // -1 gp!
					}
					// getLogger().info("gpkiller:" + Integer.toString(0) + " gploser:" + Integer.toString(gploser));
					getConfig().set("player." + killerName + ".gp", gpkiller);
					getConfig().set("player." + entityKilled + ".gp", gploser);
					this.saveConfig();

					try {
						mainsql.updateStats(p1.getName(), 2);
						mainsql.updateStats(p2.getName(), -1);
					} catch (Exception e) {
						System.out.println("Failed updating sql gp.");
					}

					p1.playEffect(p1.getLocation(), Effect.POTION_BREAK, 5);
					Integer current = lv.get(p1.getName());
					lv.put(p1.getName(), current + 1);
					p1.sendMessage(ChatColor.GREEN + "You got an upgrade: " + lv.get(p1.getName()));
					Level.updatelv(lv, p1);
					scoreboard.updateScoreboard(a);
					p1.setFoodLevel(20);
					p1.setHealth(20);
					p2.setHealth(20);
					p2.setFoodLevel(20);

					// add extra items
					this.addextraitems(p1);
				}

			}
		}
	}

	public void addextraitems(Player p) {
		ArrayList<String> keys = new ArrayList<String>();
		boolean continue_ = true;
		try {
			keys.addAll(getConfig().getConfigurationSection("player." + p.getName() + ".items").getKeys(false));
		} catch (Exception ex) {
			continue_ = false;
		}
		if (continue_) {
			for (int i = 0; i < keys.size(); i++) {
				for (AClass n : icl.c) {
					if (n.getName().equalsIgnoreCase(keys.get(i))) {
						for (ItemStack item : n.getItems()) {
							p.getInventory().addItem(item);
							p.updateInventory();
						}
					}
				}
				/*
				 * if (keys.get(i).toString().equalsIgnoreCase("Diamond_Sword_Lv_I")) { InventoryAdding.addtoinv(p, Material.DIAMOND_SWORD, 1,
				 * "gunsword", Enchantment.DAMAGE_ALL, 1); } if (keys.get(i).toString().equalsIgnoreCase("Diamond_Sword_Lv_II")) {
				 * InventoryAdding.addtoinv(p, Material.DIAMOND_SWORD, 1, "gunsword", Enchantment.DAMAGE_ALL, 4); } if
				 * (keys.get(i).toString().equalsIgnoreCase("Instant_Heal")) { PotionEffect heal = PotionEffectType.HEAL.createEffect(99999999, 7);
				 * p.addPotionEffect(heal, true); } if (keys.get(i).toString().equalsIgnoreCase("OP_Bow")) { InventoryAdding.addtoinv(p, Material.BOW,
				 * 1, "gunbow", Enchantment.ARROW_DAMAGE, 5); } if (keys.get(i).toString().equalsIgnoreCase("Diamond_Armor")) {
				 * p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1)); p.getInventory().setChestplate(new
				 * ItemStack(Material.DIAMOND_CHESTPLATE, 1)); p.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
				 * p.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1)); }
				 */
			}
		}

	}

	// Disable fall damage!
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player p = (Player) event.getEntity();
			if (event.getCause().equals(DamageCause.FALL) && pli.global_players.containsKey(p.getName())) {
				event.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onPlayerDropItem(PlayerDropItemEvent event) {
		Player p = event.getPlayer();
		if (pli.global_players.containsKey(p.getName())) {
			IArena a = (IArena) pli.global_players.get(p.getName());
			if (a.getArenaState() == ArenaState.INGAME) {
				event.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		final Player p = event.getPlayer();
		if (pli.global_players.containsKey(p.getName())) {
			event.setCancelled(true);
		}
	}

	// copied from old gungame, might need some recode
	public String getTop5() {
		boolean boo = false;
		ArrayList<String> keys = new ArrayList<String>();
		keys.addAll(getConfig().getConfigurationSection("player.").getKeys(false));
		ArrayList<Integer> serious = new ArrayList<Integer>();
		HashMap<Integer, String> seriousp = new HashMap<Integer, String>();
		for (int i = 0; i < keys.size(); i++) {
			serious.add(getConfig().getInt("player." + keys.get(i) + ".gp"));
			seriousp.put(getConfig().getInt("player." + keys.get(i) + ".gp"), keys.get(i));
		}
		Comparator<Integer> comparator = Collections.<Integer> reverseOrder();
		Collections.sort(serious, comparator);
		String retstr = "";
		for (int i = 0; i < serious.size(); i++) {
			retstr += serious.get(i).toString() + " - " + seriousp.get(serious.get(i)) + "\n";
			if (i == 6) {
				break;
			}
		}
		return retstr;
	}

}
