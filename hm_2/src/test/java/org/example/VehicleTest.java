package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


class VehicleTest {

    Vehicle vehicle;
    Car car;
    Motorcycle motorcycle;

    public String company;
    public String model;

    public int speed;

    @Test
    void testDrive() {
        this.speed = 60;
    }

    @Test
    void park() {
        this.speed = 0;
    }


    // 1)  проверка того, что экземпляр объекта Car также является экземпляром транспортного средства;
    //    через (instanceof)

    @Test
    void instance0fAssertThat(){
        car = new Car("Skoda", "Superb", 2023);
        assertThat(car instanceof Vehicle);
    }

    @Test
    void instanceOfAssertTrue() {
        car = new Car("KIA", "Optima", 2022);
        assertTrue(car instanceof Vehicle);
    }

    // 2) проверка того, объект Car создается с 4-мя колесами
    @Test
    void wheelsCar() {
        Car car = new Car("Skoda", "Fabia", 2012);
        assertEquals(4, car.getNumWheels());
    }

    // 3) проверка того, объект Motorcycle создается с 2-мя колесами
    @Test
    void motorcycleWheels() {
        motorcycle = new Motorcycle("Izh", "Planeta", 1998);
        assertEquals(2, motorcycle.getNumWheels());
    }

    // 4) проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
    @Test
    void testDriveCar() {
        Car car = new Car("Skoda", "Fabia", 2012);
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

    // 5) проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
    @Test
    void testDriveMotorcycle() {
        motorcycle = new Motorcycle("Izh", "Planeta", 1998);
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }

    // 6) проверить, что в режиме парковки (сначала testDrive, потом park. т.е эмуляция движения транспорта)
    //    машина останавливается (speed = 0)
    @Test
    void carPark() {
        Car car = new Car("Skoda", "Fabia", 2012);
        car.testDrive();
        System.out.println(car.getSpeed());
        car.park();
        assertEquals(0, car.getSpeed());
    }

    // 7) проверить, что в режиме парковки (сначала testDrive, потом park
    //    т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)

    @Test
    void motorcyclePark() {
        Motorcycle motorcycle = new Motorcycle("Izh", "Planeta", 1998);
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }
}