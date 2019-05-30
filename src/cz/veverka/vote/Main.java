package cz.veverka.vote;


import net.milkbowl.vault.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.UUID;

public class Main extends JavaPlugin {


    Boolean sent = Boolean.valueOf(false);
    ArrayList<UUID> voters = new ArrayList();
    public Chat vaultChat = null;
    Map <String, String> players = null;


    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        saveDefaultConfig();
        events EventHand1 = new events(this);
        getServer().getPluginManager().registerEvents((Listener) EventHand1, this);
        getCommand("votes").setExecutor(new votes(this));
        getCommand("vote").setExecutor(new vote(this));
        getCommand("novotefinder").setExecutor(new novotefinder(this));
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
        {
            public void run()
            {
                Calendar now = Calendar.getInstance();
                if (now.get(11) % 2 == 0)
                {
                    if ((!Main.this.sent.booleanValue()) && (now.get(12) == 0))
                    {
                        for (Player p : Bukkit.getServer().getOnlinePlayers())
                        {
                            p.sendTitle("§c§lVote", "§7Muzes znova hlasovat pro nas server !", 20, 80, 20);
                            p.sendMessage("§c§lVote §f- §7Muzes znova hlasovat pro nas server! §8(§c/vote§8)");
                        }
                        Main.this.voters.clear();
                        Main.this.sent = Boolean.valueOf(true);
                    }
                }
                else {
                    Main.this.sent = Boolean.valueOf(false);
                }
            }
        }, 0L, 20L);
    }
}
