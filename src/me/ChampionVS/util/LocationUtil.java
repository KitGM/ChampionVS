package me.ChampionVS.util;

import org.bukkit.Location;

public class LocationUtil {

    public static float distance(Location pos1, Location pos2){
        double distance;
        distance = Math.sqrt((Math.pow(pos1.getX() - pos2.getX(), 2) + Math.pow(pos1.getY() - pos2.getY(), 2) + Math.pow(pos1.getZ() - pos2.getZ(), 2)));
        return (float) distance;
    }

}
