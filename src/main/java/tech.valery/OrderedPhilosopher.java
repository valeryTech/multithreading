package tech.valery;

public class OrderedPhilosopher extends Philosopher {

    public OrderedPhilosopher(int number, Chopstick leftChopstick, Chopstick rightChopstick, Table table) {
        super(rightChopstick, number, leftChopstick, table);

    }

    public void stopSignal() {
        shouldStop = true;
    }

    /**
     * The partial order of resources is used in resource hierarchy solution to dining problems.
     * @throws InterruptedException
     */
    public void prepareToEat() throws InterruptedException {
        Chopstick firstChopstcik = leftChopstick.getId() < rightChopstick.getId() ? leftChopstick : rightChopstick;
        Chopstick secondChopstick = leftChopstick.getId() < rightChopstick.getId() ? rightChopstick : leftChopstick;

        firstChopstcik.take();
        sleep(40);
        secondChopstick.take();
    }

}