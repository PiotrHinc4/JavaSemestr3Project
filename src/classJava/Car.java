package classJava;

import java.io.*;
import java.util.Scanner;

public class Car {
    private static final String DEFAULT_FILE_CARSTYPES = "src/files/CarsTypes.txt";
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
        File file = new File(DEFAULT_FILE_CARSTYPES);
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        for (int i=1;i<=randomNumber(0,countLineNumberReader(DEFAULT_FILE_CARSTYPES));i++){
            line = scanner.nextLine();
        }
        String[] words = line.split(",");
        model = words[0];
        value = randomNumber(Integer.parseInt(words[1]),(Integer.parseInt(words[2])));
        //System.out.println(value);
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

        System.out.println(model+","+value+","+segment+","+isTruck+","+cargoSpace
                +","+isEfficientBrakes+","+isEfficientSuspension+","+
                isEfficientEngine+","+isEfficientBodywork+","+
                isEfficientGearbox);
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
}
