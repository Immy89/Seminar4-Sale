package se.kth.ict.nextgenpos.model;

/**
 * Exception for when an item id does not exist
 */
public class ItemIdDoesNotExistException extends Exception{
    private int itemId;

    /**
     * @param itemId
     */
    public ItemIdDoesNotExistException(int itemId){
        this.itemId = itemId;
    }

    /**
     * @return
     */
    @Override
    public String getMessage(){
        return "Item id " + itemId + " does not exist";
    }
}
