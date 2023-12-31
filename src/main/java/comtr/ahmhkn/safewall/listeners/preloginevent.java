package comtr.ahmhkn.safewall.listeners;

import comtr.ahmhkn.safewall.main;
import comtr.ahmhkn.safewall.utilities.lang;
import comtr.ahmhkn.safewall.utilities.protection;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import java.util.UUID;

public class preloginevent implements Listener {

    @EventHandler
    public void prelogin(AsyncPlayerPreLoginEvent e) {
        if (protection.getProtection() && !protection.getWhiteList().contains(e.getUniqueId())) {
            String name = e.getName();
            UUID uuid = e.getUniqueId();

            e.setLoginResult(AsyncPlayerPreLoginEvent.Result.KICK_OTHER);
            e.setKickMessage(lang.getKickMessage());

            Bukkit.getScheduler().runTaskLaterAsynchronously(main.getInstance(), () -> {
                protection.addWhitelist(uuid);
                if (main.getInstance().getConfig().getBoolean("debug")) {
                    main.getInstance().getLogger().info("["+name+"] "+uuid+" added to whitelist.");
                }
            }, 10L);
        } else {
            protection.addThreshold();
            if (protection.getThreshold() >= main.getInstance().getConfig().getInt("threshold") && !protection.getProtection()) {
                protection.activateProtection();
                main.getInstance().getLogger().info("§aBot Protection activated.");
                Bukkit.getScheduler().runTaskLater(main.getInstance(), () -> {
                    protection.deactivateProtection();
                    main.getInstance().getLogger().info("§cBot Protection deactivated.");

                }, 20L * 60 * main.getInstance().getConfig().getInt("activate-min"));
                return;
            }
            Bukkit.getScheduler().runTaskLater(main.getInstance(), protection::reduceThreshold, 30L);
        }
    }
}
