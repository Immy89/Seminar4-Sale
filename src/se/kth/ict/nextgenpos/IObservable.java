package se.kth.ict.nextgenpos;

/**
 * Interface for an observable class.
 */
public interface IObservable {

    /**
     * Adds an observer to the class that implements this interface.
     * @param observer is notified when change is made.
     */
    public void addObserver(IObserver observer);
}
