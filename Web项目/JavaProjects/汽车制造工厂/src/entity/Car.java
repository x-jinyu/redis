package entity;

import service.Engine;

/**
 * 王金宇
 * 2020/11/7 0007
 */
public class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void run(){
        this.engine.run();
    }
}
