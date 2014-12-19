/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.imine.mmo.stealth.skills.hide;

import nl.makertim.MMOmain.lib.InventoryCleanupEvent;
import nl.makertim.MMOmain.lib.MMOOutlaws;
import nl.makertim.MMOmain.skill.Skill;
import nl.makertim.MMOmain.skill.SkillAction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

/**
 *
 * @author Sander
 */
public class Hide extends SkillAction {

    private static Plugin plugin;

    public static void init() {
        MMOOutlaws.getInstance().addSkillHandler(Hide.class);
    }

    @Override
    public void registerEvents(PluginManager pm, Plugin pl) {
        super.registerEvents(pm, pl);
        plugin = pl;
        new HideTask(this, plugin);
    }

    @Override
    public Skill theSkill() {
        return Skill.Stealth.HIDE;
    }

    @Override
    public void onInventoryClean(InventoryCleanupEvent ice) {
        
    }
}
