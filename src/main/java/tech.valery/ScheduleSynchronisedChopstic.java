package tech.valery;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ScheduleSynchronisedChopstic implements Chopstick {
    private final int id;

    private final Lock lock = new ReentrantLock();

    public ScheduleSynchronisedChopstic(int id) {
        this.id = id;
    }

    private volatile Philosopher holder;

    @Override
    public String toString() {
        return "Chopstick{" +
                "id=" + id +
                '}';
    }

    @Override
    public synchronized void take() {
        lock.lock();
    }

    @Override
    public synchronized void put() {
        lock.unlock();
    }

    @Override
    public void setHolder(Philosopher holder) {
        this.holder = holder;
    }

    @Override
    public Boolean isGotten() {
        return null;
    }

    @Override
    public Philosopher getHolder() {
        return holder;
    }
}