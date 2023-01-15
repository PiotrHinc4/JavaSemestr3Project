package classJava;

public class Car {
    public Double value;
    public String model;
    public Double distanceTraveled;
    public String color;
    public String segment;
    public Boolean isEfficientBrakes;
    public Boolean isEfficientSuspension;
    public Boolean isEfficientEngine;
    public Boolean isEfficientBodywork;
    public Boolean isEfficientGearbox;
    public Boolean isTruck;
    public Double cargoSpace;

    public Car(Double value,
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
}
