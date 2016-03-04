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
    private LinkedList<Ship> shipsList;

    public Map(PlayerEnum player, int sizeX, int sizeY) {
        this.player = player;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        shipsList = new LinkedList<>();
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

    //straszny burdel tutaj jest,  nie poletzam
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

        for (Coord coord : shipCoordinates) {
            if (player == PlayerEnum.PLAYER1)
                map[coord.x()][coord.y()] = CellEntity.PLAYER1SHIP;
            else if (player == PlayerEnum.PLAYER2)
                map[coord.x()][coord.y()] = CellEntity.PLAYER2SHIP;
            shipsList.add(ship);
        }
    }

    public void addShip(LinkedList<Ship> ships) {
        for (Ship ship : ships) {
            addShip(ship);
        }
    }


    //check if ship can be placed on a map
    //(check if its not colliding with other ships, if it fits into boundaries of a map etc.)
    private boolean validateShipPosition(LinkedList<Coord> coords) {


        for (Coord coord : coords) {
            if((coord.x() >= 0 && coord.x() < sizeX)
                    && (coord.y() >= 0 && coord.y() < sizeY)) {
                    if (map[coord.x()][coord.y()] == CellEntity.EMPTY)
                    {}
                    else {
                        return false;
                    }
            }
            else {
                return false;
            }
        }


        return true;
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
            case EMPTY: return '~';
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
