package se.kth.ict.nextgenpos;

/**
 * Interface for an observer.
 */
public interface IObserver {

    /**
     * Is called when the observable state changes.
     */
    public void stateHasChanged ();
}
