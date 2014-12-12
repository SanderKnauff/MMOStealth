/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.imine.mmo.stealth.skills.hide;

import nl.makertim.MMOmain.PlayerStats;
import nl.makertim.MMOmain.Skill;
import nl.makertim.MMOmain.lib.MMOOutlaws;
import nl.makertim.MMOmain.lib.SkillAction;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
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
        System.out.println("G");
        super.registerEvents(pm, pl);
        plugin = pl;
        System.out.println("H");
    }

    @EventHandler
    public void onPlayerDammage(PlayerMoveEvent evt) {
        if (PlayerStats.getPlayerStats(evt.getPlayer()).theTree.gotSkill(theSkill())) {
            System.out.println("R");
            Player player = evt.getPlayer();
            Block pBlock = player.getLocation().getBlock();
            if(pBlock.getLightLevel() == 0 || pBlock.getType().equals(Material.DOUBLE_PLANT) || 
                (pBlock.getRelative(BlockFace.DOWN).getType().equals(Material.HAY_BLOCK) && player.isSneaking())){
                System.out.println("S");
                MMOOutlaws.setInvis(player, 100);
            }
            MMOOutlaws.setInvis(player, 0);
        }
    }

    @Override
    public Skill theSkill() {
        return Skill.Stealth.NO_SIGHT;
    }

    @Override
    public ItemStack getItemStack() {
        return null;
    }

}
