package com.comze_instancelabs.gungame;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.comze_instancelabs.minigamesapi.Arena;
import com.comze_instancelabs.minigamesapi.MinigamesAPI;
import com.comze_instancelabs.minigamesapi.util.ArenaScoreboard;

public class IArenaScoreboard extends ArenaScoreboard {

	HashMap<String, Scoreboard> ascore = new HashMap<String, Scoreboard>();
	HashMap<String, Objective> aobjective = new HashMap<String, Objective>();
	HashMap<String, Objective> gpp = new HashMap<String, Objective>();

	Main plugin = null;

	public IArenaScoreboard(Main m) {
		this.plugin = m;
	}

	public void updateScoreboard(final IArena arena) {
		if (arena != null) {
			for (String p_ : arena.getAllPlayers()) {
				Player p = Bukkit.getPlayer(p_);
				if (!ascore.containsKey(p_)) {
					ascore.put(p_, Bukkit.getScoreboardManager().getNewScoreboard());
				}
				if (!aobjective.containsKey(p_)) {
					aobjective.put(p_, ascore.get(p_).registerNewObjective(p_, "dummy"));
				}
				if (!gpp.containsKey(p_)) {
					if (p_.length() < 14) {
						gpp.put(p_, ascore.get(p_).registerNewObjective(p_ + "_2", "dummy"));
					} else {
						gpp.put(p_, ascore.get(p_).registerNewObjective(p_.subSequence(0, p_.length() - 1) + "-", "dummy"));
					}
				}

				aobjective.get(p_).setDisplaySlot(DisplaySlot.BELOW_NAME);
				aobjective.get(p_).setDisplayName(ChatColor.AQUA + "Lv");

				gpp.get(p_).setDisplaySlot(DisplaySlot.SIDEBAR);
				gpp.get(p_).setDisplayName("[" + p_ + "]");

				ascore.get(p_).resetScores(Bukkit.getOfflinePlayer(p_));
				if (!plugin.lv.containsKey(p_)) {
					plugin.lv.put(p_, 0);
				}
				for (String p__ : arena.getAllPlayers()) {
					aobjective.get(p_).getScore(Bukkit.getOfflinePlayer(p__)).setScore(plugin.lv.get(p__));
				}

				int gp = 0;
				if (plugin.getConfig().isSet("player." + p_)) {
					gp = plugin.getConfig().getInt("player." + p_ + ".gp"); // +2 gp!
				}

				gpp.get(p_).getScore(Bukkit.getOfflinePlayer("Your Level")).setScore(plugin.lv.get(p_));
				gpp.get(p_).getScore(Bukkit.getOfflinePlayer("Gunpoints")).setScore(gp);
				gpp.get(p_).getScore(Bukkit.getOfflinePlayer("Players")).setScore(arena.getAllPlayers().size());

				p.setScoreboard(ascore.get(p_));
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
