package tech.valery;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable{
    private int number;
    private final Chopstick leftChopstick;
    private final Chopstick rightChopstick;

    public volatile boolean shouldStop;



    public Philosopher(int number, Chopstick leftChopstick, Chopstick rightChopstick) {
        this.number = number;

        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }

    @Override
    public String toString() {
        return "Philosopher{" +
                "number=" + number +
                ", leftChopstick=" + leftChopstick +
                ", rightChopstick=" + rightChopstick +
                '}';
    }

    public void stopSignal(){
        shouldStop = true;
    }

    @Override
    public void run() {

        int timeout = 1000;
        while (!shouldStop){
            synchronized (leftChopstick){
                System.out.println("Philosopher #" + number + ": try to get right lock.");
                sleep(200);
                synchronized (rightChopstick){
                    System.out.println("Philosopher #" + number + " eating.");
                    sleep(timeout);
                }
            }

            System.out.println("Philosopher #" + number + " thinking.");
            sleep(timeout);
        }
    }

    private void sleep(int timeout) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
