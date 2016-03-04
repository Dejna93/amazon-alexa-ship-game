package com.amazon.model;

import com.amazon.utils.Direction;

/**
 * Created by Damian on 2016-03-04.
 */
public class Ship {

    private int[] position = new int[2];

    private Direction direction =new Direction(Direction.TOP);

    private int size;


    public Ship() {

    }

    public Ship(int[] position, Direction direction, int size) {
        this.position = position;
        this.direction = direction;
        this.size = size;
    }

    public void update(){

    }

    public boolean isHit(int[] hitPossition){

        if(direction.direction == Direction.TOP){
            //petla po y lecaca do gory
            for(int i = hitPossition[1] ; i < hitPossition[1] + size  ; i++){
                //sprawdzanie czy hit jest w pozycji statku
                if(i == position[1]){
                    return true;
                }
            }
            return false;
        }
        if(direction.direction == Direction.BOT){
            //petla po y lecaca do gory
            for(int i = hitPossition[1] ; i < hitPossition[1] + size  ; i++){
                //sprawdzanie czy hit jest w pozycji statku
                if(i == position[1]){
                    return true;
                }
            }
            return false;
        }
        if(direction.direction == Direction.RIGHT){

        }
        if(direction.direction == Direction.LEFT){

        }



        return true;
    }


    public int[] getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getSize() {
        return size;
    }
}
