package com.maistruk.basecar;

import java.util.Comparator;

public class NameCompare implements Comparator<Car>{

    
    public int compare(Car carOne, Car carTwo) {

        
        return stringToLowCase(carOne.getCarName()).compareTo(stringToLowCase(carTwo.getCarName()));
    }
    
    public String stringToLowCase(String carName) {
        char[] carNameChars = carName.toCharArray();
        for(int i = 0; i < carNameChars.length; i++) {
            carNameChars[i] = Character.toLowerCase(carNameChars[i]);
        }
        return String.valueOf(carNameChars);
    }
    
}