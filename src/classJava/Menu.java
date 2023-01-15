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
        selectedOption=scanner.next();
        switch(selectedOption){
            case "1":
                System.out.println("1 option");
                break;
            default:
                System.out.println("Not found selected option. Try again");
                mainMenu();
        }
    }
}
