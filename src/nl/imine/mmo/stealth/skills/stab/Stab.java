/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.imine.mmo.stealth.skills.stab;

import nl.makertim.MMOmain.PlayerStats;
import nl.makertim.MMOmain.Skill;
import nl.makertim.MMOmain.lib.MMOOutlaws;
import nl.makertim.MMOmain.lib.SkillAction;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

/**
 *
 * @author Sander
 */
public class Stab extends SkillAction {

    private static Plugin plugin;

    public static void init() {
        MMOOutlaws.getInstance().addSkillHandler(Stab.class);
    }

    @Override
    public void registerEvents(PluginManager pm, Plugin pl) {
        System.out.println("A");
        super.registerEvents(pm, pl);
        plugin = pl;
        System.out.println("B");
    }

    @EventHandler
    public void onPlayerDammage(EntityDamageByEntityEvent evt) {
        System.out.println("C");
        if (evt.getEntity() instanceof Player && evt.getDamager() instanceof Player) {
            if (PlayerStats.getPlayerStats((Player) evt.getDamager()).theTree.gotSkill(theSkill())) {
                Player player = (Player) evt.getEntity();
                Player damager = (Player) evt.getDamager();
                double angle = player.getLocation().getYaw() - damager.getLocation().getYaw();
                System.out.println("RESULT: " + (angle < 45 && angle > -45));
                if (angle < 45 && angle > -45) {
                    evt.setDamage(evt.getDamage() * (1.25));
                }
            }
        }
    }

    @Override
    public Skill theSkill() {
        return Skill.Stealth.BACK_SLASH;
    }

    @Override
    public ItemStack getItemStack() {
        return null;
    }

}
