package com.riccio.multithreading.liveLock;

public class SharedResource {

    private PoliteWorker owner;

    public SharedResource(PoliteWorker owner) {
        this.owner = owner;
    }

    public PoliteWorker getOwner() {
        return owner;
    }

    public synchronized void setOwner(PoliteWorker owner) {
        this.owner = owner;
    }
}
