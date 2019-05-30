package cz.veverka.vote;


import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class events implements Listener {

    private Main plugin;





    public events(Main main) {


        this.plugin = plugin;


    }

    @EventHandler
    public void OnVote(VotifierEvent e) {

        Vote v = e.getVote();
        Player p = Bukkit.getServer().getPlayer(v.getUsername());
        if (p == null) {
            return;
        }
        this.plugin.voters.add(p.getUniqueId());
    }
}
