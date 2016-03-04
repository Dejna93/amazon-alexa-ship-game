import com.amazon.main.Map;
import com.amazon.main.Player;
import com.amazon.model.Ship;
import com.amazon.random.Randomizer;
import com.amazon.utils.PlayerEnum;

public class Main {

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

//        Ship ship = randomizer.createShip(4);
        player1.getMap().addShip(randomizer.bulkCreateShip());
        player1.getMap().printAll();

        player2.getMap().addShip(randomizer.bulkCreateShip());
        player2.getMap().printAll();


    }
}
