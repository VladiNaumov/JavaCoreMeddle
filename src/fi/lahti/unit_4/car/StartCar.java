package fi.lahti.unit_4.car;

import java.util.Comparator;
import java.util.TreeMap;

public class StartCar {


    public static void main(String[] args) {

        System.out.println("----Comparable");
/*
        TreeMap<Car, Integer> cars = new TreeMap<>();

        Car bmv = new Car("BMV", "B104", 4);
        Car volga = new Car("VOLGA", "V101", 5);
        Car toyota = new Car("TOYOTA","T108", 1 );
        Car mazda = new Car("MAZDA","M908", 8 );

        cars.put(bmv, 10);
        cars.put(volga,3 );
        cars.put(toyota,14);
        cars.put(mazda,5);

        System.out.println(cars);

 */

        //2.05:44

        System.out.println("----Comparator");

        TreeMap<Car, Integer> comporatorMap = new TreeMap(new CarComparator());
        Car bmv = new Car("BMV", "B104", 4);
        Car volga = new Car("VOLGA", "V101", 5);
        Car toyota = new Car("TOYOTA","T108", 1 );
        Car mazda = new Car("MAZDA","M908", 8 );

        comporatorMap.put(bmv, 10);
        comporatorMap.put(volga,3 );
        comporatorMap.put(toyota,14);
        comporatorMap.put(mazda,5);

        System.out.println(comporatorMap);


    }
}
