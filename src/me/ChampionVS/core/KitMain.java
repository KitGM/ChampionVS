package me.ChampionVS.core;

import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public abstract class KitMain implements Listener {

    public ItemStack getIcon(){
        return null;
    }

    public String getName(){
        return null;
    }

    public void spawnItems(CVSPlayer player){

    }

    public void cooldownFinishOperation(){}

}
