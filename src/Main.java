import classJava.*;
import java.io.FileNotFoundException;
import static classJava.Car.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        for(int i=0;i<DEFAULT_NUMBER_OF_CARS_TO_BUY;i++){
            addCarToShop();
        }
        Player.setBaseCash();

        Menu.mainMenu();
    }
}