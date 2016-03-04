package com.amazon.random;

import com.amazon.main.Map;
import com.amazon.model.Ship;
import com.amazon.utils.Direction;

import java.util.Random;

/**
 * Created by Ciemek on 04/03/16.
 */
public class Randomizer {

    private static int STANDARD_SIZE = 3;
    private Random random;
    private Map map;

    public Randomizer(Map map) {
        random = new Random();
        this.map = map;
    }

    public Ship createShip() {
        int positionX = random.nextInt((map.getMapSize() -0) + 1) + 0;
        int positionY = random.nextInt((map.getMapSize() -0) + 1) + 0;
        Direction direction = new Direction(random.nextInt((4 -1) + 1) + 1);

        int[] positionArray = {positionX, positionY};


        return new Ship(positionArray, direction, STANDARD_SIZE);
    }


    public Ship createShip(int size) {
        int positionX = random.nextInt((map.getMapSize() -0) + 1) + 0;
        int positionY = random.nextInt((map.getMapSize() -0) + 1) + 0;
        Direction direction = new Direction(random.nextInt((4 -1) + 1) + 1);

        int[] positionArray = {positionX, positionY};


        return new Ship(positionArray, direction, size);
    }


}
