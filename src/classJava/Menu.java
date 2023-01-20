package classJava;
import java.util.Scanner;

public class Menu {

    public static String selectedOption;
    public Menu(String selectedOption) {
        this.selectedOption=selectedOption;
    }
    public static void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the appropriate command number:");
        System.out.println("[1] Base of cars to buy");
        System.out.println("[0] Exiting the game");
        selectedOption=scanner.next();
        switch(selectedOption){
            case "1":
                System.out.println("1st option");
                Menu.mainMenu();
                break;
            case "0":
                leavingGame();
                break;
            default:
                System.out.println("Not found selected option. Try again");
                mainMenu();
        }
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
