package se.kth.ict.nextgenpos.model;

/**
 *
 */
public class ItemIdDoesNotExistException extends Exception{
    private String message;

    public ItemIdDoesNotExistException(String message){}

    public String getMessage(){
        return this.message;
    }
}
