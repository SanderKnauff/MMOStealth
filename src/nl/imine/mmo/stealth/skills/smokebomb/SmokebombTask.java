package nl.imine.mmo.stealth.skills.smokebomb;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SmokebombTask extends BukkitRunnable {

    List<Entity> bats = new ArrayList<>(); 

    public SmokebombTask(List<Entity> bats) {
        this.bats = bats;        
    }

    public void run() {
    }
}
