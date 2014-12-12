/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.imine.mmo.stealth.skills.arrowReturn;

import nl.makertim.MMOmain.Skill;
import nl.makertim.MMOmain.lib.MMOOutlaws;
import nl.makertim.MMOmain.lib.SkillAction;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileHitEvent;
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
        super.registerEvents(pm, pl);
        plugin = pl;
    }

    @EventHandler
    public void onPlayerDammage(ProjectileHitEvent evt) {
        if (evt.getEntity() instanceof Arrow && evt.getEntity().getShooter() instanceof Player) {
            Player player = (Player) evt.getEntity().getShooter();
            //if (hasSkill(evt.getEntity().getShooter())) {
                if (Math.random() * 100 < 75) {
                    player.getInventory().addItem(new ItemStack(Material.ARROW, 1));
                }
           //}
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
