package com.amazon.main;

import com.amazon.containers.Coord;
import com.amazon.model.Ship;
import com.amazon.utils.CellEntity;
import com.amazon.utils.PlayerEnum;

import java.util.ArrayList;
import java.util.LinkedList;


/**
 * Created by Damian on 2016-03-04.
 */
public class Map {

    private PlayerEnum player;

    private int sizeX;
    private int sizeY;

    private CellEntity[][] map;
    private LinkedList<Coord> shipCoordinatesList;

    public Map(PlayerEnum player, int sizeX, int sizeY) {
        this.player = player;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        shipCoordinatesList = new LinkedList<Coord>();
        instantiateMap();
    }

    private void instantiateMap() {
        map = new CellEntity[sizeX][sizeY];

        for (int x=0; x<sizeX; ++x){
            for (int y=0 ; y<sizeY; ++y) {
                map[x][y] = CellEntity.EMPTY;
            }
        }

        System.out.println("map object instantiated, size: (" + sizeX + "," + sizeY + ")");
    }


    //placing a ship onto a map
    public void addShip(Ship ship) {
        LinkedList<Coord> shipCoordinates = new LinkedList<>();
//        shipCoordinates.add(new Coord(ship.getPosition()));

        switch(ship.getDirection().direction){
            case 1:
                for (int i=0; i < ship.getSize(); ++i){
                    shipCoordinates.add(new Coord(
                            ship.getPosition()[0],
                            ship.getPosition()[1] + i));
                }
                break;
            case 2:
                for (int i=0; i < ship.getSize(); ++i){
                    shipCoordinates.add(new Coord(
                            ship.getPosition()[0],
                            ship.getPosition()[1] - i));
                }
                break;
            case 3:

                for (int i=0; i < ship.getSize(); ++i){
                    shipCoordinates.add(new Coord(
                            ship.getPosition()[0] - i,
                            ship.getPosition()[1]));
                }
                break;
            case 4:

                for (int i=0; i < ship.getSize(); ++i){
                    shipCoordinates.add(new Coord(
                            ship.getPosition()[0] + i,
                            ship.getPosition()[1]));
                }
                break;
        }

        if (!validateShipPosition(shipCoordinates)) return;



    }


    //check if ship can be placed on a map
    //(check if its not colliding with other ships, if it fits into boundaries of a map etc.)
    private boolean validateShipPosition(LinkedList<Coord> coords) {
        System.out.println("printing ship coordinates:");
        for (Coord coord : coords)
            System.out.print("(" + coord.x() + "," + coord.y() + ")||");



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

    public int getMapSize() {
        return sizeX;
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
