package me.ChampionVS.managers;


import me.ChampionVS.core.CVSPlayer;
import me.ChampionVS.core.ChampionVS;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.UUID;

public class PlayerManager implements Listener {

    private static HashMap<UUID, CVSPlayer> cvsPlayers = new HashMap<>();

    public PlayerManager(){
        ChampionVS.registerEvents(this);
        registerOnlinePlayers();
    }

    private void registerOnlinePlayers(){
        for(Player player : Bukkit.getServer().getOnlinePlayers()){
            cvsPlayers.put(player.getUniqueId(), new CVSPlayer(player.getUniqueId()));
        }
    }


    @EventHandler
    public void registerOnJoin(PlayerJoinEvent e){
        if(!cvsPlayers.containsKey(e.getPlayer().getUniqueId())){
            cvsPlayers.put(e.getPlayer().getUniqueId(), new CVSPlayer(e.getPlayer().getUniqueId()));
        }
    }



}
