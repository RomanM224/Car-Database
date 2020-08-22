package com.maistruk.basecar;

import java.util.Comparator;

public class YearCompare implements Comparator<Car> {

    public int compare(Car first, Car second) {
        return first.getCarYear()-second.getCarYear();
    }

}
