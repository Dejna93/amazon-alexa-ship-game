package com.amazon.main;

import com.amazon.model.Ship;
import com.amazon.utils.CellEntity;
import com.amazon.utils.PlayerEnum;
import com.oracle.tools.packager.Log;


/**
 * Created by Damian on 2016-03-04.
 */
public class Map {

    private PlayerEnum player;

    private int sizeX;
    private int sizeY;

    private CellEntity[][] map;

    public Map(PlayerEnum player, int sizeX, int sizeY) {
        this.player = player;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        instantiateMap();
    }

    private void instantiateMap() {
        map = new CellEntity[sizeX][sizeY];

        for (int x=0; x<sizeX; ++x){
            for (int y=0 ; y<sizeY; ++y) {
                map[x][y] = CellEntity.EMPTY;
            }
        }

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



    //printer:
    public void printAll() {
        System.out.println("\nPriting map: player " + player.toString() + "\n");

        for (CellEntity[] row : this.map) {
            System.out.print("[");

            for (CellEntity cell : row) System.out.print(cellGetShorterID(cell));

            System.out.println("]");
        }
    }

    private char cellGetShorterID(CellEntity cell){
        switch(cell){
            case EMPTY: return 'E';
            case PLAYER1SHIP: return '1';
            case PLAYER2SHIP: return '2';
            default: return '!';
        }
    }



    //accessors:
    public CellEntity getSingleEntity(int sizeX, int sizeY) {
        return map[sizeX][sizeY];
    }


    public CellEntity[][] getMap() {
        return map;
    }

    public PlayerEnum getPlayer() {
        return player;
    }

    public void setPlayer(PlayerEnum player) {
        this.player = player;
    }
}
