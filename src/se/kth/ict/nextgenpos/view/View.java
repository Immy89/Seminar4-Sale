package se.kth.ict.nextgenpos.view;

import se.kth.ict.nextgenpos.IObserver;
import se.kth.ict.nextgenpos.controller.Controller;
import se.kth.ict.nextgenpos.model.ItemIdDoesNotExistException;
import se.kth.ict.nextgenpos.model.ProductSpecification;

import java.util.Collection;
import java.util.logging.*;

/**
 * A placeholder for the view.
 */
public class View implements IObserver{
    private Controller cont;
    private static final Logger LOGGER = Logger.getLogger( ItemIdDoesNotExistException.class.getName() );

    /**
     * Creates a new <code>View</code>.
     * @param cont           The controller of the application.
     */
    public View(Controller cont) {
	    this.cont = cont;
        cont.getCatalog().addObserver(this);
    }

    /**
     * Simulates a view. Makes some calls to the controller.
     */
    public void test() {
		cont.makeNewSale();
		enterItem(1);
		System.out.println(">>>>> NOTE!!\n" +
			   "A null pointer exception will follow since there is no handling" + 
			   " of non-existing item ids. When you have implemented exception" +
			   " handling, there should be some informative printout instead of the" +
			   " exception stack trace.");
		enterItem(10);
    }


    private void enterItem(int itemId) {
		try{
			int quantity = 1;
			System.out.println("");
			System.out.println("Result for item " + itemId + ": " + cont.enterItem(itemId, quantity));
			System.out.println("");
		}
		catch(ItemIdDoesNotExistException e){
            LOGGER.log( Level.INFO, e.toString(), e );
		}
    }

    /**
     * Is called when the observable state changes.
     */
    @Override
    public void stateHasChanged() {
        Collection<ProductSpecification> products = cont.getCatalog().getAllProducts();
        for (ProductSpecification product:products) {
            LOGGER.info(product.toString());
        }
    }
}
