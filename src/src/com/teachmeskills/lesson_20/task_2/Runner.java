package com.teachmeskills.lesson_20.task_2;


/*Задача 2
        2. Есть СТО. На сто может быть в обслуживании максимум определенное количество машин.
        Создать класс, который будет запускаться в отдельном потоке и будет добавлять машины на обсуживание в СТО.
        Создать класс, который будет запускаться в отдельном потоке и будет забирать исправленные машины из СТО.
        Пусть максимальное количество доступных для обсуживания машин задается в интерфейсе для хранения констант.
        Использовать synchronized, wait, notify.*/

import com.teachmeskills.lesson_20.task_2.cars.CarAdder;
import com.teachmeskills.lesson_20.task_2.cars.CarRemover;
import com.teachmeskills.lesson_20.task_2.service.ServiceStation;
import com.teachmeskills.lesson_20.task_2.сonstant.StoConstants;

public class Runner {
    public static void main(String[] args) {
        ServiceStation serviceStation = new ServiceStation(StoConstants.MAX_CAPACITY);

        Thread adderThread = new Thread(new CarAdder(serviceStation));
        Thread removerThread = new Thread(new CarRemover(serviceStation));

        adderThread.start();
        removerThread.start();
    }
}

