package com.amazon.main;

import com.amazon.containers.Coord;
import com.amazon.utils.PlayerEnum;

import java.util.Scanner;

/**
 * Created by Ciemek on 04/03/16.
 */
public class GameLoop {

    private PlayerEnum actualPlayer = PlayerEnum.PLAYER1;
    private String input;
    private char row, column;
    private int asciiRow, asciiColumn;
    private Player player1;
    private Player player2;
    boolean isHit;

    public GameLoop(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        gameLoop();
    }


    private void gameLoop() {
        System.out.println("\n");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            if (actualPlayer == PlayerEnum.PLAYER1) System.out.println("PLAYER 1 TURN:");
            else System.out.println("PLAYER 2 TURN:");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            if (scanner.hasNext()) {
                captureInput(scanner);

                if (input.contains("exit")) {
                    System.out.println("exiting the game");
                    return;
                }

                //shouldn't they be the other way around? first column, then row?
                System.out.println("You've chosen the position: " + "(" + row + "," + column + ") "
                        + " [" + asciiRow + "," + asciiColumn + "]");

                Coord actualCoord = new Coord(asciiRow, asciiColumn);
                //NOW, CHECK IF INPUT IS VALID AND WITHIN MAP!
                    //check out of border conditions
                    //check providing a number lower than zero
                    //fix capitalization


                if(actualPlayer == PlayerEnum.PLAYER1)
                    isHit = player2.getMap().checkHit(PlayerEnum.PLAYER1, actualCoord);
                 else
                    isHit = player1.getMap().checkHit(PlayerEnum.PLAYER2, actualCoord);


                if(isHit)
                    System.out.println("IT'S A HIT, you can have another move!");
                else
                    System.out.println("You missed, next player's turn.");

            }

            if (!isHit) {
                if (actualPlayer == PlayerEnum.PLAYER1)
                    actualPlayer = PlayerEnum.PLAYER2;
                else
                    actualPlayer = PlayerEnum.PLAYER1;
            }
        }
    }


    private void captureInput(Scanner scanner) {
        //input has to be uppercase
        input = scanner.next();
        row = input.charAt(0);
        column = input.charAt(1);
        asciiRow = row;
        asciiRow = asciiRow - 49 - 16;
        asciiColumn = column - 49;

    }

}
