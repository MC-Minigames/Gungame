package com.comze_instancelabs.gungame.sql;

import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainSQL {

	// used for rewards and stats

	JavaPlugin plugin = null;
	private boolean mysql = true; // false for sqlite
	MySQL MySQL;
	SQLite SQLite;

	public MainSQL(JavaPlugin plugin, boolean mysql) {
		this.plugin = plugin;
		this.mysql = mysql;

		if (mysql) {
			MySQL = new MySQL(plugin.getConfig().getString("mysql.host"), "3306", plugin.getConfig().getString("mysql.database"), plugin.getConfig().getString("mysql.user"), plugin.getConfig().getString("mysql.pw"));
		} else {
			SQLite = new SQLite(plugin.getConfig().getString("mysql.database"), plugin.getConfig().getString("mysql.user"), plugin.getConfig().getString("mysql.pw"));
		}

		if (plugin.getConfig().getBoolean("mysql.enabled") && MySQL != null) {
			this.createTables();
		} else if (plugin.getConfig().getBoolean("mysql.enabled") && MySQL == null) {
			System.out.println("Failed initializing MySQL. Disabling!");
			plugin.getConfig().set("mysql.enabled", false);
			plugin.saveConfig();
		}
	}

	public void createTables() {
		if (!plugin.getConfig().getBoolean("mysql.enabled")) {
			return;
		}
		if (!mysql) {
			// TODO SQLite
		}
		Connection c = MySQL.open();

		try {
			c.createStatement().execute("CREATE DATABASE IF NOT EXISTS `" + plugin.getConfig().getString("mysql.database") + "`");
			c.createStatement().execute("CREATE TABLE IF NOT EXISTS " + plugin.getName() + "_gp" + " (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, player VARCHAR(100), gp INT)");
			// }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateStats(String p_, int gp) {
		if (!plugin.getConfig().getBoolean("mysql.enabled")) {
			return;
		}
		if (!mysql) {
			// TODO SQLite
		}
		Connection c = MySQL.open();

		try {
			ResultSet res3 = c.createStatement().executeQuery("SELECT * FROM " + plugin.getName() + "_gp" + " WHERE player='" + p_ + "'");
			if (!res3.isBeforeFirst()) {
				// there's no such user
				if(gp < 0){
					gp = 0;
				}
				c.createStatement().executeUpdate("INSERT INTO " + plugin.getName() + "_gp" + " VALUES('0', '" + p_ + "', '" + Integer.toString(gp) + "')");
				return;
			}
			res3.next();
			int points = res3.getInt("gp") + gp;
			
			if(points < 0){
				points = 0;
			}

			c.createStatement().executeUpdate("UPDATE " + plugin.getName() + "_gp" + " SET gp='" + Integer.toString(points) + "' WHERE player='" + p_ + "'");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getPoints(String p_) {
		if (!plugin.getConfig().getBoolean("mysql.enabled")) {
			return -1;
		}
		if (!mysql) {
			// TODO SQLite
		}
		Connection c = MySQL.open();

		try {
			ResultSet res3 = c.createStatement().executeQuery("SELECT * FROM " + plugin.getName() + "_gp" + " WHERE player='" + p_ + "'");

			if (res3.isBeforeFirst()) {
				res3.next();
				int credits = res3.getInt("gp");
				return credits;
			} else {
				// System.out.println("New User detected.");
			}
		} catch (SQLException e) {
			//
		}
		return -1;
	}

}
