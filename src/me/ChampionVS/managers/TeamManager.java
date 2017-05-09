package me.ChampionVS.managers;


import me.ChampionVS.core.CVSPlayer;
import me.ChampionVS.core.ChampionVS;
import me.ChampionVS.core.Team;
import org.bukkit.DyeColor;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

public class TeamManager implements Listener {

    public TeamManager(){
        ChampionVS.registerEvents(this);
    }

    private  static List<Team> teams = new ArrayList<>();


    public void addTeam(String name, DyeColor color){
        teams.add(new Team(name, color));
    }

    public void removeTeam(String name){
        for(Team team : teams){
            if(team.getName().equalsIgnoreCase(name)){
                teams.remove(team);
                break;
            }
        }
    }

    public static void addToTeam(String name, CVSPlayer player){
        for(Team team : teams){
            if(team.getName().equalsIgnoreCase(name)){
                team.addPlayer(player);
                player.setTeam(team);
                break;
            }
        }
    }

    public static void removeFromTeam(CVSPlayer player){
        for(Team team : teams){
            if(team.getPlayers().contains(player)){
                team.getPlayers().remove(player);
                break;
            }
        }
    }

    public static Team getTeam(CVSPlayer player){
        for(Team team : teams){
            if(team.getPlayers().contains(player)){
                return team;
            }
        }
        return null;
    }

    public static List<Team> getTeams(){
        return teams;
    }

    public void sendMessageToTeam(String message, Team team){
        for(CVSPlayer player : team.getPlayers()){
            player.sendMessage(message);
        }
    }
}
