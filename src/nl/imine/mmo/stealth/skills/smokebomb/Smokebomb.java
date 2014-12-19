/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.imine.mmo.stealth.skills.smokebomb;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import nl.imine.mmo.stealth.lib.FireworkEffectPlayer;
import nl.makertim.MMOmain.lib.InventoryCleanupEvent;
import nl.makertim.MMOmain.lib.MMOOutlaws;
import nl.makertim.MMOmain.skill.Skill;
import nl.makertim.MMOmain.skill.SkillAction;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 *
 * @author Sander
 */
public class Smokebomb extends SkillAction {

    public static Plugin plugin;
    
    public static void init() {
        MMOOutlaws.getInstance().addSkillHandler(Smokebomb.class);
    }

    @Override
    public void registerEvents(PluginManager pm, Plugin pl) {
        super.registerEvents(pm, pl);
        this.plugin = pl;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent evt) {
        if (gotSkill(evt.getPlayer())) {
            if (evt.getAction().equals(Action.RIGHT_CLICK_AIR) || evt.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                Player player = evt.getPlayer();
                if (player.getItemInHand().getType().equals(Material.COAL)) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 150, 0));
                    Location smokeball = player.getLocation();
                    smokeball.setY(smokeball.getY() + 1);
                    FireworkEffectPlayer fplayer = new FireworkEffectPlayer();
                    try {
                        fplayer.playFirework(evt.getPlayer().getWorld(), smokeball, FireworkEffect.builder().with(Type.BALL).withColor(Color.WHITE).build());
                    } catch (IllegalAccessException | InvocationTargetException ex) {
                    }
                    List<Entity> bats = new ArrayList<>();
                    for (int i = 0; i < 25; i++) {
                        bats.add(player.getWorld().spawnEntity(player.getLocation(), EntityType.BAT));
                    }
                    new SmokebombTask(bats, plugin);
                    player.getItemInHand().setAmount(player.getItemInHand().getAmount() - 1);
                    evt.setCancelled(true);
                }
            }
        }
    }

    @Override
    public Skill theSkill() {
        return Skill.Stealth.BAT_BOM;
    }

    @Override
    public void onInventoryClean(InventoryCleanupEvent ice) {
    }
}
