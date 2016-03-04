import com.amazon.main.Map;
import com.amazon.main.Player;
import com.amazon.model.Ship;
import com.amazon.random.Randomizer;
import com.amazon.utils.PlayerEnum;

import java.util.Scanner;

public class Main {

    private static PlayerEnum actualPlayer = PlayerEnum.PLAYER1;
    private static String input;
    private static char row, column;

    public static void main(String[] args) {

        System.out.println("Hello World!");

        Map player1Map;
        Map player2Map;
        int initialSizeX = 10;
        int initialSizeY = 10;

        //creating 'players'
        Player player1 = new Player(PlayerEnum.PLAYER1);
        Player player2 = new Player(PlayerEnum.PLAYER2);


        //step 1: creating empty map
        player1Map = new Map(PlayerEnum.PLAYER1, initialSizeX, initialSizeY);
        player2Map = new Map(PlayerEnum.PLAYER2, initialSizeX, initialSizeY);

        player1Map.printAll();
        player2Map.printAll();

        player1.setMap(player1Map);
        player2.setMap(player2Map);



        //step 2: creating ships
        //randomly at the moment

        //randomly fill player 1 map:
        Randomizer randomizer = new Randomizer(player1Map);

        player1.getMap().addShip(randomizer.bulkCreateShip());
        player1.getMap().printAll();

        player2.getMap().addShip(randomizer.bulkCreateShip());
        player2.getMap().printAll();

        gameLoop();

    }


    //should be running in another thread
    private static void gameLoop() {
        System.out.println("\n");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            if (actualPlayer == PlayerEnum.PLAYER1) System.out.println("PLAYER 1 TURN:");
            else System.out.println("PLAYER 2 TURN:");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            if (scanner.hasNext()) {
                captureInput(scanner);

                if (input == "exit") return;

                System.out.println("You've hit the position: " + "(" + row + "," + column + ")\n");


            }

            if (actualPlayer == PlayerEnum.PLAYER1)
                actualPlayer = PlayerEnum.PLAYER2;
            else
                actualPlayer = PlayerEnum.PLAYER1;
        }
    }

    private static void captureInput(Scanner scanner) {
        input = scanner.next();
        row = input.charAt(0);
        column = input.charAt(1);
    }
}
