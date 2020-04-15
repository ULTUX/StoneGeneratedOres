package pl.bullcube.ULTUX.StoneGen;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    static Plugin plugin;
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("[SGEH] Plugin disabled!");
    }

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getConsoleSender().sendMessage("[SGEH] Plugin enabled!");
        getServer().getPluginManager().registerEvents(new Events(), this);
    }
}
