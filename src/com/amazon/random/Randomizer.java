package com.amazon.random;

import com.amazon.main.Map;
import com.amazon.model.Ship;
import com.amazon.utils.Direction;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Ciemek on 04/03/16.
 */
public class Randomizer {

    private static int STANDARD_SIZE = 3;
    private Random random;
    private Map map;

    //randomizer components:
    private int positionX;
    private int positionY;
    private Direction direction;
    private int[] positionArray;


    public Randomizer(Map map) {
        random = new Random();
        this.map = map;
    }

    public Ship createShip() {
        assigningRandomValues();

        return new Ship(positionArray, direction, STANDARD_SIZE);
    }


    public Ship createShip(int size) {
        assigningRandomValues();

        return new Ship(positionArray, direction, size);
    }

    public LinkedList<Ship> bulkCreateShip(){
        LinkedList<Ship> createdShips = new LinkedList<>();

        createdShips.add(createShip(5));
        createdShips.add(createShip(5));
        createdShips.add(createShip(4));
        createdShips.add(createShip(4));
        createdShips.add(createShip(4));
        createdShips.add(createShip(3));
        createdShips.add(createShip(3));
        createdShips.add(createShip(3));
        createdShips.add(createShip(3));
        createdShips.add(createShip(3));
        createdShips.add(createShip(2));
        createdShips.add(createShip(2));
        createdShips.add(createShip(2));
        createdShips.add(createShip(2));
        return createdShips;
    }

    private void assigningRandomValues() {
        positionX = random.nextInt((map.getMapSize()-2 -1) + 1) + 1;
        positionY = random.nextInt((map.getMapSize()-2 -1) + 1) + 1;
        direction = new Direction(random.nextInt((4 -1) + 1) + 1);

        positionArray = new int[2];
        positionArray[0] = positionX;
        positionArray[1] = positionY;
    }


}
