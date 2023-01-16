package classJava;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Car {
    private static final String DEFAULT_FILE_CARS_TYPES = "src/files/CarsTypes.txt";
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
    public static void generateCar() throws FileNotFoundException{
        File file = new File(DEFAULT_FILE_CARS_TYPES);
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        for (int i=1;i<=randomNumber(0,countLineNumberReader(DEFAULT_FILE_CARS_TYPES));i++){
            line = scanner.nextLine();
        }
        String[] words = line.split(",");
        model = words[0];
        value = randomNumber(Integer.parseInt(words[1]),(Integer.parseInt(words[2])));
        segment = words[3];
        cargoSpace=Double.parseDouble(words[4]);
        if (cargoSpace>0) {
            isTruck=true;
        } else {
            isTruck=false;
        }
        System.out.println(model + " " + value + " " + segment + " " + isTruck + " " + cargoSpace);
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
}
