package com.amazon.main;

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

    public GameLoop() {
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
                System.out.println("You've hit the position: " + "(" + row + "," + column + ") "
                        + " [" + asciiRow + "," + asciiColumn + "]");

            }

            if (actualPlayer == PlayerEnum.PLAYER1)
                actualPlayer = PlayerEnum.PLAYER2;
            else
                actualPlayer = PlayerEnum.PLAYER1;
        }
    }


    private void captureInput(Scanner scanner) {
        input = scanner.next();
        row = input.charAt(0);
        column = input.charAt(1);
        asciiRow = row;
        asciiRow = asciiRow - 48 - 16;
        asciiColumn = column - 48;

    }

}
