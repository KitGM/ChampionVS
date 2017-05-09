package me.ChampionVS.listeners;

import me.ChampionVS.core.ChampionVS;
import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class SoulboundListener implements Listener {

    public SoulboundListener(){
        ChampionVS.registerEvents(this);
    }

    @EventHandler
    public void onDeathSoulboundClear(PlayerDeathEvent e){
        for(int i = 0; i < e.getDrops().size(); i++){
            if(e.getDrops().get(i).getItemMeta().hasLore()){
                if(e.getDrops().get(i).getItemMeta().getLore().contains(ChatColor.GOLD + "Soulbound")){
                    e.getDrops().set(i, null);
                }
            }
        }
    }

    @EventHandler
    public void onDropItem(PlayerDropItemEvent e){
        Item item = e.getItemDrop();
        if(item.getItemStack().getItemMeta().getLore().contains(ChatColor.GOLD + "Soulbound")){
            item.remove();
        }
    }

}
