package test;

import entity.Car;
import service.Engine;
import sport.SportEngine;

/**
 * 王金宇
 * 2020/11/7 0007
 */
public class 组装汽车 {
    public static void main(String[] args) {
        Engine engine = new SportEngine();
        Car car = new Car(engine);
        car.run();
    }
}
