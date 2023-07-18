package comtr.ahmhkn.safewall.utilities;

import comtr.ahmhkn.safewall.main;
import org.bukkit.ChatColor;

public class lang {

    public static String getKickMessage() {
       return ChatColor.translateAlternateColorCodes('&', main.getInstance().getConfig().getString("kick-message"));
    }
}
