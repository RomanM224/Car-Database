package com.maistruk.basecar;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Random;

public class Car implements Serializable{
    private static final long serialVersionUID = 8111226007304260531L;
            
    int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String carName;
    private String carModel;
    private double carEngine;
    private int carYear;
    
    public Car(){
        Random rand = new Random();
        id = rand.nextInt(1000);
    }
    
    public String getCarName() {
        return carName;
    }
    public void setCarName(String carName) {
        this.carName = carName;
    }
    public String getCarModel() {
        return carModel;
    }
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    public double getCarEngine() {
        return carEngine;
    }
    public void setCarEngine(double carEngine) {
        this.carEngine = carEngine;
    }
    public int getCarYear() {
        return carYear;
    }
    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    
    @Override
    public String toString() {
        return "Car [id="+ id + ", carName=" + carName + ", carModel=" + carModel + ", carEngine=" + carEngine
                + ", carYear=" + carYear + "]";
    }

    
}
