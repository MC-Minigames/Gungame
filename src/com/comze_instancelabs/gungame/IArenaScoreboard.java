package com.comze_instancelabs.gungame;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.comze_instancelabs.minigamesapi.Arena;
import com.comze_instancelabs.minigamesapi.MinigamesAPI;
import com.comze_instancelabs.minigamesapi.util.ArenaScoreboard;

public class IArenaScoreboard extends ArenaScoreboard {

	static Scoreboard board;
	static Objective objective;

	Main plugin = null;

	public IArenaScoreboard(Main m) {
		this.plugin = m;
	}

	public void updateScoreboard(final IArena arena) {
		if (arena != null) {
			for (String p_ : arena.getAllPlayers()) {
				Player p = Bukkit.getPlayer(p_);
				if (board == null) {
					board = Bukkit.getScoreboardManager().getNewScoreboard();
				}
				if (objective == null) {
					objective = board.registerNewObjective("test", "dummy");
				}

				objective.setDisplaySlot(DisplaySlot.BELOW_NAME);

				objective.setDisplayName("§3Lv");

				board.resetScores(p_);
				if (!plugin.lv.containsKey(p_)) {
					plugin.lv.put(p_, 0);
				}
				objective.getScore(p_).setScore(plugin.lv.get(p_));

				p.setScoreboard(board);
			}
		}
	}

	@Override
	public void updateScoreboard(JavaPlugin plugin, final Arena arena) {
		IArena a = (IArena) MinigamesAPI.getAPI().pinstances.get(plugin).getArenaByName(arena.getName());
		this.updateScoreboard(a);
	}

	@Override
	public void removeScoreboard(String arena, Player p) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard sc = manager.getNewScoreboard();
		sc.clearSlot(DisplaySlot.SIDEBAR);
		p.setScoreboard(sc);
	}

}
