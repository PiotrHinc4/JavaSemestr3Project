package classJava;

import java.io.*;
import java.util.Scanner;

public class Car {
    private static final String DEFAULT_FILE_CARSTYPES = "src/files/CarsTypes.txt";
    public static final int DEFAULT_NUMBER_OF_CARS_TO_BUY = 15;
    private static final int DEFAULT_AMOUNT_OF_INFORMATION_ABOUT_THE_CAR = 10;
    public static Integer value;
    public static String model;
    public static Double distanceTraveled;
    public static String color;
    public static String segment;
    public static Boolean isEfficientBrakes;
    public static Boolean isEfficientSuspension;
    public static Boolean isEfficientEngine;
    public static Boolean isEfficientBodywork;
    public static Boolean isEfficientGearbox;
    public static Boolean isTruck;
    public static Double cargoSpace;
    public static String[][] carsShop = new String[DEFAULT_NUMBER_OF_CARS_TO_BUY][DEFAULT_AMOUNT_OF_INFORMATION_ABOUT_THE_CAR];
    public Car(Integer value,
               String model,
               Double distanceTraveled,
               String color,
               String segment,
               Boolean isEfficientBrakes,
               Boolean isEfficientSuspension,
               Boolean isEfficientEngine,
               Boolean isEfficientBodywork,
               Boolean isEfficientGearbox,
               Boolean isTruck,
               Double cargoSpace){
        this.value = value;
        this.model = model;
        this.distanceTraveled = distanceTraveled;
        this.color=color;
        this.segment=segment;
        this.isEfficientBrakes=isEfficientBrakes;
        this.isEfficientSuspension=isEfficientSuspension;
        this.isEfficientEngine=isEfficientEngine;
        this.isEfficientBodywork=isEfficientBodywork;
        this.isEfficientGearbox=isEfficientGearbox;
        this.isTruck=isTruck;
        this.cargoSpace=cargoSpace;
    }
    public static String generateCar() throws FileNotFoundException{
        File file = new File(DEFAULT_FILE_CARSTYPES);
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        for (int i=1;i<=randomNumber(0,countLineNumberReader(DEFAULT_FILE_CARSTYPES));i++){
            line = scanner.nextLine();
        }
        String[] words = line.split(",");
        model = words[0];
        value = randomNumber(Integer.parseInt(words[1]),(Integer.parseInt(words[2])));
        segment = words[3];
        isTruck=Boolean.parseBoolean(words[4]);
        cargoSpace=Double.parseDouble(words[5]);
        if (isTruck=true) {
            cargoSpace=Double.parseDouble((words[5]));
        } else {
            cargoSpace=0.0;
        }

        isEfficientBrakes=checkPart(95);
        isEfficientSuspension=checkPart(90);
        isEfficientEngine=checkPart(50);
        isEfficientBodywork=checkPart(25);
        isEfficientGearbox=checkPart(25);

        return model+","+value+","+segment+","+isTruck+","+cargoSpace
                +","+isEfficientBrakes+","+isEfficientSuspension+","+
                isEfficientEngine+","+isEfficientBodywork+","+
                isEfficientGearbox;
    }
    public static boolean checkPart(int percent){
        if(isPartDamage()==true){
            value=value*percent/100;
            return true;
        } else {
            return false;
        }
    }
    public static boolean isPartDamage(){
        int chance = randomNumber(1,12);
        if(chance%4==0) {
            return true;
        } else {
            return false;
        }
    }
    public static int countLineNumberReader(String fileName) {
        File file = new File(fileName);
        int lines = 0;
        try (LineNumberReader lnr = new LineNumberReader(new FileReader(file))) {
            while (lnr.readLine() != null) ;
            lines = lnr.getLineNumber();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
    public static int randomNumber(int minimum, int maximum){
        return (int) ((Math.random() * (maximum - minimum)) + minimum);
    }
    public static void addCarToShop() throws FileNotFoundException {
        for(int x=0;x<DEFAULT_NUMBER_OF_CARS_TO_BUY;x++){
            if(carsShop[x][0]==null) {
                String[] car = generateCar().split(",");
                for(int y=0;y<DEFAULT_AMOUNT_OF_INFORMATION_ABOUT_THE_CAR;y++){
                    carsShop[x][y]=car[y];
                }
                System.out.println(carsShop[x][0]);
                break;
            }
        }
    }
}
