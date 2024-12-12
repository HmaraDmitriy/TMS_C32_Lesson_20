package com.teachmeskills.lesson_20.task_1;

/*Задача 1
        1. Cоздать программу, иммитирующую утро: чтение нововостей, завтра, кофе.
Каждому потоку задать имя и приоритет из конфиг файла.
Пусть будет 3 потока.
Создать и запустить 3 потока.
Сделать два варианта: используя интерфейс Runnable и/или используя класс Thread.*/


import java.util.Properties;

class MorningTask implements Runnable {
    
    private final String taskName;

    public MorningTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + taskName + " started.");
        try {
            Thread.sleep(1000); // Имитация работы потока
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": " + taskName + " completed.");
    }
}

public class Runner {
    public static void main(String[] args) {

        Properties config = new Properties();
        config.setProperty("Thread1", "1");
        config.setProperty("Thread2", "5");
        config.setProperty("Thread3", "10");

        Thread thread1 = new Thread(new MorningTask("Reading News"), "News Thread");
        thread1.setPriority(Integer.parseInt(config.getProperty("Thread1")));

        Thread thread2 = new Thread(new MorningTask("Having Breakfast"), "Breakfast Thread");
        thread2.setPriority(Integer.parseInt(config.getProperty("Thread2")));

        Thread thread3 = new Thread(new MorningTask("Drinking Coffee"), "Coffee Thread");
        thread3.setPriority(Integer.parseInt(config.getProperty("Thread3")));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
