package ru.javawebinar.basejava;

public class MainLocking {
    static final String resource1 = "res1";
    static final String resource2 = "res2";


    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(resource1);
                synchronized (resource2) {
                    System.out.println(resource2);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println(resource2);
                Thread.yield();
                synchronized (resource1) {
                    System.out.println(resource1);
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}
