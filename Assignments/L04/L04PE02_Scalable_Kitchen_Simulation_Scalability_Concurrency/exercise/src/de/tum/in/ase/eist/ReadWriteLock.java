package de.tum.in.ase.eist;

// TODO Implement this class. Check out the LoggingReadWriteLock which extends this class while doing so.
// Tip regarding interruptedexceptions: You can just ignore them and continue waiting
/**
 * A simple ReadWriteLock implementation.
 * NOTE: this implementation does not need to be "fair" (fair == lock requests
 * are guaranteed to be handled in the order of their arrival), as requiring
 * fairness would make this task too hard.
 */
public class ReadWriteLock {

    public synchronized void lockRead() {
        return;
    }

    public synchronized void unlockRead() {
        return;
    }

    public synchronized void lockWrite() {
        return;
    }

    public synchronized void unlockWrite() {
        return;
    }
}