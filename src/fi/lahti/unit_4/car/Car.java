package fi.lahti.unit_4.car;

import java.util.Objects;

public class Car implements Comparable<Car>{
    String marka;
    String model;
    int age;

    public Car(String marka, String model, int age) {
        this.marka = marka;
        this.model = model;
        this.age = age;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public int getAge() {
        return age;
    }

/*
    @Override
    public int compareTo(Car o) {
        if(o.hashCode()< hashCode())
            return -1;
        else if(o.hashCode()> hashCode())
            return 1;

        return 0;
    }


 */





    @Override
    public int compareTo(Car o) {
        if(o.getAge() > getAge()){
            return -1;
        }

        else if(o.getAge() < getAge()){
            return 1;
        }
        return 0;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return age == car.age &&
                Objects.equals(marka, car.marka) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marka, model, age);
    }

    @Override
    public String toString() {
        return "Car{" +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", age=" + age +
                '}';
    }
}
