/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.imine.mmo.stealth;

import nl.imine.mmo.stealth.skills.smokebomb.Smokebomb;
import nl.imine.mmo.stealth.skills.hide.Hide;
import nl.imine.mmo.stealth.skills.arrowReturn.ArrowReturn;
import nl.imine.mmo.stealth.skills.stab.Stab;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Sander
 */
public class MMOStealth extends JavaPlugin {

    @Override
    public void onEnable(){
        ArrowReturn.init();
        Stab.init();
        Hide.init();
        Smokebomb.init();
    }
}
