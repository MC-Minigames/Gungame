package com.comze_instancelabs.gungame;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;

import com.comze_instancelabs.minigamesapi.Arena;
import com.comze_instancelabs.minigamesapi.ArenaState;
import com.comze_instancelabs.minigamesapi.ArenaType;
import com.comze_instancelabs.minigamesapi.MinigamesAPI;
import com.comze_instancelabs.minigamesapi.PluginInstance;
import com.comze_instancelabs.minigamesapi.util.Util;

public class IArena extends Arena {

	public static Main m;
	public PluginInstance pli;
	
	boolean cteam = true;

	public IArena(Main m, String arena_id) {
		super(m, arena_id, ArenaType.JUMPNRUN);
		pli = MinigamesAPI.getAPI().pinstances.get(m);
		this.m = m;
	}

	@Override
	public void spectate(String playername) {

	}

	BukkitTask tt;
	int currentingamecount;
	
	@Override
	public void joinPlayerLobby(String p_){
		super.joinPlayerLobby(p_);
		m.lv.put(p_, 0);
		ItemStack w = new ItemStack(Material.WOOD_SWORD, 1);
		Player p= Bukkit.getPlayer(p_);
		p.getInventory().addItem(w);
		p.updateInventory();
		m.addextraitems(p);
		m.scoreboard.updateScoreboard(this);
		
		p.setGameMode(GameMode.SURVIVAL);
	}
	
	@Override
	public void leavePlayer(final String playername, boolean fullLeave) {
		super.leavePlayerRaw(playername, fullLeave);
	}
	
	@Override
	public void start(boolean tp) {

		super.start(false);

		final IArena a = this;
		m.scoreboard.updateScoreboard(this);
		tt = Bukkit.getScheduler().runTaskTimer(m, new Runnable() {
			public void run() {
				if (a.getArenaState() == ArenaState.INGAME) {
					Bukkit.getScheduler().runTaskLater(m, new Runnable() {
						public void run() {
							for (String p_ : a.getAllPlayers()) {
								// give items
								m.lv.put(p_, 0);
								ItemStack w = new ItemStack(Material.WOOD_SWORD, 1);
								Player p= Bukkit.getPlayer(p_);
								p.getInventory().addItem(w);
								p.updateInventory();
								m.addextraitems(p);
								m.scoreboard.updateScoreboard(a);
							}
						}
					}, 20L);
					tt.cancel();
				}
			}
		}, 20L, 20L);
	}

}
