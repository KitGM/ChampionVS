package me.ChampionVS.core;

import com.KitNetwork.core.KNCore;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class ChampionVS extends JavaPlugin implements Listener {

    private static ChampionVS instance;

    public ChampionVS(){
        instance = this;
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        KNCore.log("ChampionVS Enabled!");
    }

    public static void registerEvents(Listener listener){
        Bukkit.getPluginManager().registerEvents(listener, instance);
    }

    public static ChampionVS getInstance(){
        return instance;
    }

}
