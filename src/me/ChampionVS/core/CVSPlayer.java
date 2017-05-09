package me.ChampionVS.core;

import com.KitNetwork.permissions.PermissionRanks;
import me.ChampionVS.managers.TeamManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CVSPlayer {

    private UUID uuid;
    private KitMain currentClass;
    private KitMain previousClass;
    private PermissionRanks rank;
    private List<KitMain> unlockedClasses = new ArrayList<>();
    private Team team;

    public CVSPlayer(UUID uuid){
        this.uuid = uuid;
    }

    public Player getBukkitPlayer(){
        return Bukkit.getPlayer(uuid);
    }

    public String getDisplayName(){
        return Bukkit.getPlayer(uuid).getDisplayName();
    }

    public void setClass(KitMain kit){
        currentClass = kit;
        if(currentClass != null){
            previousClass = currentClass;
        }

    }

    public UUID getUUID(){
        return uuid;
    }

    public KitMain getCurrentClass(){
        return currentClass;
    }

    public KitMain getPreviousClass(){
        return previousClass;
    }

    public List<KitMain> getUnlockedClasses(){
        return unlockedClasses;
    }

    public boolean isOnline(){
        return Bukkit.getPlayer(uuid).isOnline();
    }

    public void sendMessage(String string){
        getBukkitPlayer().sendMessage(string);
    }

    public void setTeam(Team team){this.team = team;
    }

    public void setNameDisplay(String string){

    }

    public Team getTeam(){
        return team;
    }

    public boolean isOnTeam(){
        for(Team team : TeamManager.getTeams()){
            if(team.getPlayers().contains(this)){
                return true;
            }
        }
        return false;
    }


}
