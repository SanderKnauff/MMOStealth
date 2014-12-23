/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.imine.mmo.stealth.skills.stab;

import nl.makertim.MMOmain.lib.InventoryCleanupEvent;
import nl.makertim.MMOmain.lib.MMOOutlaws;
import nl.makertim.MMOmain.skill.Skill;
import nl.makertim.MMOmain.skill.SkillAction;
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
        super.registerEvents(pm, pl);
        plugin = pl;
    }

    @EventHandler
    public void onPlayerDammage(EntityDamageByEntityEvent evt) {
        if (evt.getEntity() instanceof Player && evt.getDamager() instanceof Player) {
            if (gotSkill((Player) evt.getDamager())) {
                Player player = (Player) evt.getEntity();
                Player damager = (Player) evt.getDamager();
                double angle = player.getLocation().getYaw() - damager.getLocation().getYaw();
                if (angle < 45 && angle > -45) {
                    evt.setDamage(evt.getDamage() * (1.50));
                }
            }
        }
    }

    @Override
    public Skill theSkill() {
        return Skill.Stealth.BACK_SLASH;
    }

    @Override
    public void onInventoryClean(InventoryCleanupEvent ice) {
    }
}
