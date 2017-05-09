package me.ChampionVS.core;


import org.bukkit.DyeColor;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name = "";
    private List<CVSPlayer> playersOnTeam = new ArrayList<>();
    private DyeColor teamColor;

    public Team(String name, DyeColor color){
        this.teamColor = color;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public List<CVSPlayer> getPlayers(){
        return playersOnTeam;
    }

    public void addPlayer(CVSPlayer player){
        playersOnTeam.add(player);
    }

    public DyeColor getTeamColor(){
        return teamColor;
    }

}
