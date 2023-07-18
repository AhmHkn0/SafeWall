package comtr.ahmhkn.safewall;

import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    private static main plugin;

    @Override
    public void onEnable() {
        comtr.ahmhkn.safewall.utilities.protection.register();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public static main getInstance() {
        return plugin;
    }

}
