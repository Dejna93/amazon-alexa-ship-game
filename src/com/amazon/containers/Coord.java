package com.amazon.containers;

/**
 * Created by Ciemek on 04/03/16.
 */
public class Coord {

    private int x;
    private int y;

    public Coord() {
        this.x = -1;
        this.y = -1;
    }

    public Coord(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Coord(int[] coordinates){
        this.x = coordinates[0];
        this.y = coordinates[1];
    }


    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
}
