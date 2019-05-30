package cz.veverka.vote;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class votes implements CommandExecutor {

    private Main plugin;
    public votes(Main plugin) {

        this.plugin = plugin;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        Player p = (Player)sender;
        p.sendMessage("§3§l▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
        p.sendMessage(" ");
        p.sendMessage("§bVote for server here:");


        TextComponent message = new TextComponent();
        if (!this.
                plugin.
                voters.
                contains(
                        p.
                                getUniqueId())) {

            message = new TextComponent(TextComponent.fromLegacyText("§bClick on this text!"));
            message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, plugin.getConfig().getString("clickevent") + p.getName()));
            message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§bClick to get to the voting page").create()));
        }
        else {

            message = new TextComponent(TextComponent.fromLegacyText("§cYou've already voted, try it in an even hour"));
        }

        p.spigot().sendMessage(message);
        p.sendMessage(" ");
        p.sendMessage("§3§l▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");

        return true;
    }
}