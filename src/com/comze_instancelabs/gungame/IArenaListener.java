package com.comze_instancelabs.gungame;

import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.comze_instancelabs.minigamesapi.ArenaListener;
import com.comze_instancelabs.minigamesapi.PluginInstance;

public class IArenaListener extends ArenaListener {

	public IArenaListener(JavaPlugin plugin, PluginInstance pinstance) {
		super(plugin, pinstance, "gungame");
	}

	@Override
	public void onPlayerDeath(PlayerDeathEvent event) {
		
	}

}
