package cz.veverka.vote;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class vote implements CommandExecutor {

    private Main plugin;
    public vote(Main plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        Player p = (Player)sender;
        if (args.length == 0) {

            p.sendMessage("§eVote §7/vote <player>");
            return true;
        }

        Player t = Bukkit.getServer().getPlayer(args[0]);
        if (t == null) {

            p.sendMessage("§eVote §cThis user is not online!");
            return true;
        }
        if (this.plugin.voters.contains(t.getUniqueId())) {
            p.sendMessage("§eVote §cThis user has voted for the server");
            return true;
        }
        p.sendMessage("§eVote §cThis user did not vote for us server!");


        return true;
    }
}

