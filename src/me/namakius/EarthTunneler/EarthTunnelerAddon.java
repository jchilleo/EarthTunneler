package me.namakius.EarthTunneler;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

import com.projectkorra.projectkorra.ProjectKorra;
import com.projectkorra.projectkorra.ability.AddonAbility;
import com.projectkorra.projectkorra.ability.EarthAbility;
import com.projectkorra.projectkorra.configuration.ConfigManager;

/**
 * EarthTunneler Ability Addon for ProjectKorra. Developed by Namakius. Please
 * feel free to modify but do not claim as your own.
 * 
 * @author Namakius
 * 
 */
public class EarthTunnelerAddon extends EarthAbility implements AddonAbility {

	public EarthTunnelerAddon(Player player) {
		super(player);
		// TODO Auto-generated constructor stub
	}

	public String getAuthor() {
		return "Namakius";
	}

	public String getVersion() {
		return "v1.0";
	}

	public String getDescription() {
		return

		getName() + " " + getVersion() + " Developed by " + getAuthor()
				+ "\nEarthTunneler is a very useful EarthBending move, "
				+ "to start using this technique start digging the ground around you ";
	}

	public void load() {
		FileConfiguration c = ConfigManager.defaultConfig.get();
		c.addDefault("Abilities.EarthTunneler.Enabled", Boolean.TRUE);
		c.addDefault("Abilities.EarthTunneler.MaxRadius", 1);
		c.addDefault("Abilities.EarthTunneler.Range", 50);
		c.addDefault("Abilities.EarthTunneler.Radius", 1.5D);
		c.addDefault("Abilities.EarthTunneler.Interval", 30);
		c.addDefault("Abilities.EarthTunneler.Revert", Boolean.FALSE);

		ProjectKorra.plugin.saveConfig();

		ProjectKorra.plugin.getServer().getScheduler().runTaskLater(ProjectKorra.plugin, new Runnable() {
			public void run() {
				ConfigManager.defaultConfig.save();
			}
		}, 20L);

		ProjectKorra.plugin.getServer().getLogger()
				.info(getName() + " " + getVersion() + "Developed by " + getAuthor() + " has been enabled!");
		ProjectKorra.plugin.getServer().getPluginManager().registerEvents(new EarthTunnelerListener(),
				ProjectKorra.plugin);
		ProjectKorra.plugin.getServer().getPluginManager()
				.addPermission(new Permission("bending.ability.EarthTunneler"));
		ProjectKorra.plugin.getServer().getPluginManager().getPermission("bending.ability.EarthTunneler")
				.setDefault(PermissionDefault.TRUE);
		ProjectKorra.plugin.getServer().getPluginManager().registerEvents(new EarthTunnelerListener(),
				ProjectKorra.plugin);

	}

	public void stop() {
		ProjectKorra.plugin.getServer().getLogger()
				.info(getName() + " " + getVersion() + "Developed by " + getAuthor() + " has been disabled!");
		ProjectKorra.plugin.getServer().getPluginManager().removePermission("bending.ability.EarthTunneler");
		super.remove();
	}

	@Override
	public long getCooldown() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "EarthTunneler";
	}

	@Override
	public boolean isHarmlessAbility() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSneakAbility() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void progress() {
		// TODO Auto-generated method stub

	}

}
