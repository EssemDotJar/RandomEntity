package jar.essem.main;

import jar.essem.main.listeners.BlockBreakListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("Started!");

		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new BlockBreakListener(), this);
	}
}
