package de.tum.in.ase.eist;

import java.util.Queue;

class Chef implements Runnable {
    private Queue<Order> orderQueue;
    private LoggingReadWriteLock orderQueueLock;
    private String name;

    public Chef(String name, Queue<Order> orderQueue) {
        this.name = name;
        this.orderQueue = orderQueue;
        this.orderQueueLock = new LoggingReadWriteLock();
    }

    private static final int CHEF_BREAK_TIME_MS = 100;
    public Queue<Order> getOrderQueue() {
        return orderQueue;
    }

    public LoggingReadWriteLock getOrderQueueLock() {
        return orderQueueLock;
    }

    public String getName() {
        return name;
    }

    /**
     * Continuously processes orders from the queue. Ensure read-write
     * synchronization for safe access.
     * If there are no more orders (for some time until new ones are added), the
     * chef gets a quick break given by CHEF_BREAK_TIME_MS.
     */

    @Override
    public void run() {
        // TODO: Implement according to the comment above this function with respect to the entire system. 
    }
}
