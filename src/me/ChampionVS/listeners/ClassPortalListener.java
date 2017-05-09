package me.ChampionVS.listeners;

import me.ChampionVS.core.CVSPlayer;
import me.ChampionVS.core.ChampionVS;
import me.ChampionVS.core.KitMain;
import me.ChampionVS.util.Cooldown;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class ClassPortalListener extends KitMain implements Listener {

    private Cooldown cooldown = new Cooldown(ChampionVS.getInstance());

    private Player lastPlayer;

    public ClassPortalListener(){
        ChampionVS.registerEvents(this);
    }

    @Override
    public void cooldownFinishOperation() {}

    @EventHandler
    public void onChangeClass(PlayerTeleportEvent e){
        if(e.getCause() == PlayerTeleportEvent.TeleportCause.NETHER_PORTAL){

            e.setCancelled(true);
            //---------------------
            //TODO
            //---------------------
            cooldown.createCooldown(2, e.getPlayer(), this);
            lastPlayer = e.getPlayer();
        }
    }

}
