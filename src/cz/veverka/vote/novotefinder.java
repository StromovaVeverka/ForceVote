package cz.veverka.vote;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;


public class novotefinder implements CommandExecutor {


    private Main plugin;
    ArrayList<String> novote = new ArrayList();

    public novotefinder(Main plugin) {
        this.plugin  = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        Player p = (Player)sender;
        for (Player all : Bukkit.getServer().getOnlinePlayers()) {
            if (!plugin.
                    voters.
                    contains(
                            p.
                                    getUniqueId())) {
                this.novote.add(all.getDisplayName());
            }
        }
        p.sendMessage("§3§l▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
        p.sendMessage(" ");
        p.sendMessage("§bThese players did not vote for us: §b" + StringUtils.join(this.novote, "§3,§b "));
        p.sendMessage(" ");
        p.sendMessage("§3§l▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
        this.novote.clear();

        return true;
    }
}
