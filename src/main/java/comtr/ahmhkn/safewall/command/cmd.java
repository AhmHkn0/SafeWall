package comtr.ahmhkn.safewall.command;

import comtr.ahmhkn.safewall.main;
import comtr.ahmhkn.safewall.utilities.protection;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("safewall")) {
            if (sender instanceof Player) {
                Player p = ((Player) sender);
                if (!p.hasPermission("safewall.reset") && !p.hasPermission("safewall.reload"))
                    return false;
            }
            if (args.length == 0) {
                sender.sendMessage("§3"+ main.getInstance().getDescription().getName()+" " + main.getInstance().getDescription().getVersion() + " §7is running.");
                sender.sendMessage("§aAvailable commands:");
                sender.sendMessage("§b/safewall reset - §3Reset whitelist.");
                sender.sendMessage("§b/safewall reload - §3Reload config.");
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reset")) {
                    protection.resetWhitelist();
                    sender.sendMessage("§aWhitelist cleaned.");
                }
                if (args[0].equalsIgnoreCase("reload")) {
                    protection.resetWhitelist();
                    sender.sendMessage("§aConfig reloaded.");
                }
            }
        }
        return false;
    }
}
