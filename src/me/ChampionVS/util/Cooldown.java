package me.ChampionVS.util;

import me.ChampionVS.core.KitMain;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class Cooldown {

    private HashMap<Player, Integer> cooldownTime;
    private HashMap<Player, BukkitRunnable> cooldownTask;

    private Plugin plugin;

    private Effect effect;
    private int amount;
    private String displayeMessage;
    private KitMain kitMain;

    public Cooldown(Plugin p){
        this.plugin = p;
        cooldownTime = new HashMap<>();
        cooldownTask = new HashMap<>();
    }

    public void createCooldown(int cooldown, Player player, KitMain kit){
        startCooldown(player, cooldown, kit);
    }

    private void startCooldown(Player player, int cooldown, KitMain kit) {
        final Player p = player;
        final KitMain k = kit;
        this.kitMain = kit;
        cooldownTime.put(p, cooldown);
        cooldownTask.put(p, new BukkitRunnable() {
            @Override
            public void run() {
                cooldownTime.put(p, cooldownTime.get(p) - 1);
                if(effect != null){
                    p.getWorld().playEffect(p.getLocation(), effect, amount);
                }
                if(displayeMessage != null){
                    p.sendMessage(displayeMessage);
                }
                if(cooldownTime.get(p) == 0){
                    cooldownTime.remove(p);
                    cooldownTask.remove(p);
                    runFinal();
                    cancel();
                }
            }
        });

        cooldownTask.get(p).runTaskTimer(plugin, 20, 20);
    }

    public boolean canUse(Player p){
        if(cooldownTime.containsKey(p)){
            return false;
        }else{
            return true;
        }
    }

    public int getCurrentTime(Player p){
        return cooldownTime.get(p);
    }

    public String getItemName(ItemStack item, Player p){
        String temp = item.getItemMeta().getDisplayName();
        String name = temp + " " + cooldownTime.get(p);
        return name;
    }

    public void setCooldownEffect(Effect effect, int amount){
        this.effect = effect;
        this.amount = amount;
    }

    public void setDisplayMessage(String message){
        this.displayeMessage = message;
    }

    public void runFinal(){
        if(kitMain != null){
            kitMain.cooldownFinishOperation();
        }
    }


}
