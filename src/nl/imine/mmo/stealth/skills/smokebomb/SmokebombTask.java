package nl.imine.mmo.stealth.skills.smokebomb;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class SmokebombTask extends BukkitRunnable {

    List<Entity> bats = new ArrayList<>(); 

    public SmokebombTask(List<Entity> bats, Plugin plugin) {
        this.bats = bats;
        this.runTaskLater(plugin, 50L);
    }

    public void run() {
        for (Entity b : bats) {
            b.remove();
        }
    }
}
