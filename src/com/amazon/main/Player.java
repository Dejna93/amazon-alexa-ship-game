package com.amazon.main;

import com.amazon.model.Ship;
import com.amazon.utils.PlayerEnum;

import java.util.LinkedList;

/**
 * Created by Ciemek on 04/03/16.
 */
public class Player {

    private PlayerEnum playerEnum;
    private Map map;
    private LinkedList<Ship> shipList;


    public Player(PlayerEnum playerEnum) {
        this.playerEnum = playerEnum;
    }


    public PlayerEnum getPlayerEnum() {
        return playerEnum;
    }

    public void setPlayerEnum(PlayerEnum playerEnum) {
        this.playerEnum = playerEnum;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public LinkedList<Ship> getShipList() {
        return shipList;
    }

    public void setShipList(LinkedList<Ship> shipList) {
        this.shipList = shipList;
    }
}
