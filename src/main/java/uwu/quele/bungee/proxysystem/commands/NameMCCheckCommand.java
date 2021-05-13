package uwu.quele.bungee.proxysystem.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import uwu.quele.bungee.proxysystem.main.NameMcReward;
import uwu.quele.bungee.proxysystem.utils.NameMcRewardUtils;

/*
 * Author: quele
 * problems? add me on discord
 * discord: quele#0001
 */

public class NameMCCheckCommand extends Command {

    public NameMCCheckCommand() {
        super("reward", null);
    }

    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer player;
        if (sender instanceof ProxiedPlayer) {
            player = ( ProxiedPlayer ) sender;
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("check")) {
                    if (NameMcRewardUtils.check(player.getUniqueId())) {
                        player.sendMessage(NameMcReward.getInstance().getPrefix() + "§7Auf NameMC geliked §8» §a✔");
                    } else {
                        player.sendMessage(NameMcReward.getInstance().getPrefix() + "§7Auf NameMC geliked §8» §c✗");
                    }
                }
            } else {
                player.sendMessage(NameMcReward.getInstance().getPrefix() + "§cFalsche Benutzung§4!");

            }
        }
    }
}
