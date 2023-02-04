package classJava;
import java.util.Objects;
import java.util.Scanner;

import static classJava.Car.DEFAULT_NUMBER_OF_CARS_TO_BUY;
import static classJava.Car.carsShop;
import static classJava.Player.isWin;

public class Menu {

    public static String selectedOption;
    public Menu(String selectedOption) {
        this.selectedOption=selectedOption;
    }
    public static void mainMenu() {
        if (isWin()) {
            System.out.println("YOU WIN!!!!!");
            System.out.println("YOU DO THIS IN " + Player.round + " ROUNDS!!!");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the appropriate command number:");
            System.out.println("[1] Base of cars to buy");
            System.out.println("[0] Exiting the game");
            selectedOption = scanner.next();
            switch (selectedOption) {
                case "1":
                    carsToBuy();
                    break;
                case "0":
                    leavingGame();
                    break;
                default:
                    System.out.println("Not found selected option. Try again");
                    mainMenu();
            }
        }
    }
    static void carsToBuy(){
        System.out.println("Cars in the shop:");
        for(int x=0;x<DEFAULT_NUMBER_OF_CARS_TO_BUY;x++){
            String line = "["+(x+1)+"] ";
            line=line+"Model: "+carsShop[x][0]+";";
            line=line+"\tValue: "+carsShop[x][1]+";";
            line=line+"\tColor: "+carsShop[x][11]+";";
            line=line+"\tTraveled distance: "+carsShop[x][10];
            if(carsShop[x][3]=="true"){
                line=line+"\tTruck; \tCargoSpace: "+ carsShop[x][4]+";";
            } else {
                line=line+"\tPersonal car;";
            }
            line=line+"\tSegement: "+carsShop[x][2]+";";

            line=line+"\tDamaged: ";
            if(Objects.equals(carsShop[x][5], "false") && Objects.equals(carsShop[x][6], "false") && Objects.equals(carsShop[x][7], "false") && Objects.equals(carsShop[x][8], "false") && Objects.equals(carsShop[x][9], "false")){
                line=line+"none";
            } else if (Objects.equals(carsShop[x][5], "true") && Objects.equals(carsShop[x][6], "true") && Objects.equals(carsShop[x][7], "true") && Objects.equals(carsShop[x][8], "true") && Objects.equals(carsShop[x][9], "true")){
                line=line+"all";
            } else {
                if (Objects.equals(carsShop[x][5], "true")) {
                    line = line + "brakes, ";
                }
                if (Objects.equals(carsShop[x][6], "true")) {
                    line = line + "suspension, ";
                }
                if (Objects.equals(carsShop[x][7], "true")) {
                    line = line + "engine, ";
                }
                if (Objects.equals(carsShop[x][8], "true")) {
                    line = line + "bodywork, ";
                }
                if (Objects.equals(carsShop[x][9], "true")) {
                    line = line + "gearbox, ";
                }
            }
            System.out.println(line);
        }
        System.out.println("[0] Back to menu");
    }

    private static void leavingGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you sure you want to leave the game? [Yes/No]");
        selectedOption=scanner.next();
        if (selectedOption.equals("Yes")) {
            System.out.println("Exiting the game. See you later");
        } else if (selectedOption.equals("No")) {
            Menu.mainMenu();
        } else {
            System.out.println("I don't understand. Try again");
            leavingGame();
        }
    }
}
