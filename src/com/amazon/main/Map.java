package com.amazon.main;

import com.amazon.model.Ship;
import com.amazon.utils.MapEntity;
import com.amazon.utils.PlayerEnum;
import com.oracle.tools.packager.Log;

/**
 * Created by Damian on 2016-03-04.
 */
public class Map {

    private int sizeX;
    private int sizeY;

    private MapEntity[][] map;

    public Map(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        instantiateMap();
    }

    private void instantiateMap() {
        map = new MapEntity[sizeX][sizeY];

        for (MapEntity[] row : map)
            for (MapEntity cell : row)
                cell = MapEntity.EMPTY;


        Log.debug("map object instantiated, size: (" + sizeX + "," + sizeY + ")");
    }


    //placing a ship onto a map
    public void addShip(PlayerEnum playerEnum, Ship ship) {
        
    }


    //check if ship can be placed on a map
    //(check if its not colliding with other ships, if it fits into boundaries of a map etc.)
    private boolean validateShipPosition(Ship ship) {

        return false;
    }



    //accessors:
    public MapEntity getSingleEntity(int sizeX, int sizeY) {
        return map[sizeX][sizeY];
    }


    public MapEntity[][] getMap() {
        return map;
    }
}
