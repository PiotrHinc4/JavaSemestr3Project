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
            System.out.println("Enter the appropriate command number:");
            System.out.println("[1] Show base of cars to buy");
            System.out.println("[2] Buy a car (in progress)");
            System.out.println("[3] Show owned cars (in progress)");
            System.out.println("[4] Repair the car (in progress)");
            System.out.println("[5] Show potential customers (in progress)");
            System.out.println("[6] Sell the car (in progress)");
            System.out.println("[7] Buy advertisement (in progress)");
            System.out.println("[8] Check bank account (in progress)");
            System.out.println("[9] Check transaction history (in progress)");
            System.out.println("[10] Check history of car repair (in progress)");
            System.out.println("[11] Check repair and cleaning costs (in progress)");
            System.out.println("[0] Exit the game");
            selectedOption=getSelectedOption();
            switch (selectedOption) {
                case "1":
                    carsToBuy();
                    break;
                case "2":
                    System.out.println("This part is in progress. Back to the main menu");
                    mainMenu();
                    break;
                case "3":
                    System.out.println("This part is in progress. Back to the main menu");
                    mainMenu();
                    break;
                case "4":
                    System.out.println("This part is in progress. Back to the main menu");
                    mainMenu();
                    break;
                case "5":
                    System.out.println("This part is in progress. Back to the main menu");
                    mainMenu();
                    break;
                case "6":
                    System.out.println("This part is in progress. Back to the main menu");
                    mainMenu();
                    break;
                case "7":
                    System.out.println("This part is in progress. Back to the main menu");
                    mainMenu();
                    break;
                case "8":
                    System.out.println("This part is in progress. Back to the main menu");
                    mainMenu();
                    break;
                case "9":
                    System.out.println("This part is in progress. Back to the main menu");
                    mainMenu();
                    break;
                case "10":
                    System.out.println("This part is in progress. Back to the main menu");
                    mainMenu();
                    break;
                case "11":
                    System.out.println("This part is in progress. Back to the main menu");
                    mainMenu();
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
    static String getSelectedOption(){
        String messengeFromUser;
        Scanner scanner = new Scanner(System.in);
        messengeFromUser = scanner.next();
        return messengeFromUser;
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
        System.out.println("Press \"0\" to back to menu");
        if(getSelectedOption().equals("0")){
            mainMenu();
        } else {
            System.out.println("I don't understand. Try again");
            carsToBuy();
        }
    }

    private static void leavingGame() {
        System.out.println("Are you sure you want to leave the game? [Yes/No]");
        selectedOption=getSelectedOption();
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
