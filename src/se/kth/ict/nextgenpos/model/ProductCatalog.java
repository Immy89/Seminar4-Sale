package se.kth.ict.nextgenpos.model;

import se.kth.ict.nextgenpos.IObservable;
import se.kth.ict.nextgenpos.IObserver;

import java.util.*;

/**
 * This class is responsible for all access to the product database.
 */ 
public class ProductCatalog implements IObservable{
    private Map<Integer, ProductSpecification> products =
	new HashMap<Integer, ProductSpecification>();
	private ArrayList<IObserver> observers = new ArrayList<>();
	private int counter = 3;

    /**
     * Fills the catalog with some dummy items.
     */
    public ProductCatalog() {
		products.put(1, new ProductSpecification(1, "low fat milk",
	   	"a very long description, a very long description, a very long description", 10));
		products.put(2, new ProductSpecification(2, "butter",
	   	"a very long description, a very long description, a very long description", 10));
		products.put(3, new ProductSpecification(3, "bread",
	   	"a very long description, a very long description, a very long description", 10));
    }

    public Collection<ProductSpecification> getAllProducts(){
		return products.values();
	}

	/**
	 * Adds new product to the productCatalog.
	 *
	 * @param productToAdd the productSpecification of the product to add.
	 */
	public void addProduct(ProductSpecification productToAdd){
		products.put(++counter, productToAdd);
		for (IObserver observer:observers) {
			observer.stateHasChanged();
		}
	}

    /**
     * Search for an item in the product catalog.
     *
     * @param    itemId The item to look for
     * @return          The specification for the found item or null if no item was found.
	 * @throws ItemIdDoesNotExistException If itemId does not exist.
     */
    public ProductSpecification findSpecification(int itemId) throws ItemIdDoesNotExistException
	{
		if (products.get(itemId) == null){
			throw new ItemIdDoesNotExistException(itemId);
		}
		return products.get(itemId);
    }

	/**
	 * Adds an observer to the class that implements this interface.
	 *
	 * @param observer is notified when change is made.
	 */
	@Override
	public void addObserver(IObserver observer) {
		observers.add(observer);
	}
}
