/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.imine.mmo.stealth.skills.arrowReturn;

import nl.makertim.MMOmain.PlayerStats;
import nl.makertim.MMOmain.Skill;
import nl.makertim.MMOmain.lib.MMOOutlaws;
import nl.makertim.MMOmain.lib.SkillAction;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

/**
 *
 * @author Sander
 */
public class ArrowReturn extends SkillAction {

    private static Plugin plugin;

    public static void init() {
        MMOOutlaws.getInstance().addSkillHandler(ArrowReturn.class);
    }

    @Override
    public void registerEvents(PluginManager pm, Plugin pl) {
        System.out.println("J");
        super.registerEvents(pm, pl);
        plugin = pl;
        System.out.println("K");
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent evt) {
        System.out.println("L");
        if ((evt.getEntity() instanceof Player)) {
            if (PlayerStats.getPlayerStats((Player) evt.getEntity()).theTree.gotSkill(theSkill())) {
                if (evt.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
                    Block a = evt.getEntity().getLocation().add(0, -1, 0).getBlock();
                    Block b = evt.getEntity().getLocation().add(0, -2, 0).getBlock();
                    if (a.getType().equals(Material.HAY_BLOCK) || b.getType().equals(Material.HAY_BLOCK)) {
                        evt.setDamage(0D);
                        evt.setCancelled(true);
                    }
                }
            }
        }
    }

    @Override
    public Skill theSkill() {
        return Skill.Stealth.FLAME_ARROW;
    }

    @Override
    public ItemStack getItemStack() {
        return null;
    }

}
