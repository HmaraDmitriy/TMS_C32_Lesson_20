package com.teachmeskills.lesson_20.task_2.cars;

import com.teachmeskills.lesson_20.task_2.service.ServiceStation;

public class CarAdder implements Runnable{
    private final ServiceStation serviceStation;

    public CarAdder(ServiceStation serviceStation) {
        this.serviceStation = serviceStation;
    }

    @Override
    public void run() {
        try {
            while (true) {
                serviceStation.addCar();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
