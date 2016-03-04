import com.amazon.main.Map;
import com.amazon.utils.PlayerEnum;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        Map player1Map;
        Map player2Map;

        int initialSizeX = 10;
        int initialSizeY = 10;

        //step 1
        player1Map = new Map(PlayerEnum.PLAYER1, initialSizeX, initialSizeY);
        player2Map = new Map(PlayerEnum.PLAYER2, initialSizeX, initialSizeY);

        player1Map.printAll();
        player2Map.printAll();


        //step 2



    }
}
