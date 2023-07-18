package comtr.ahmhkn.safewall;

import comtr.ahmhkn.safewall.command.cmd;
import comtr.ahmhkn.safewall.listeners.preloginevent;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    private static main plugin;

    @Override
    public void onEnable() {
        plugin = this;
        comtr.ahmhkn.safewall.utilities.protection.register();
        getServer().getPluginManager().registerEvents(new preloginevent(), plugin);
        getCommand("safewall").setExecutor(new cmd());
    }

    @Override
    public void onDisable() {
        getLogger().info("§3Good bye!");
    }


    public static main getInstance() {
        return plugin;
    }

}
