package se.kth.ict.nextgenpos.startup;

import se.kth.ict.nextgenpos.controller.Controller;
import se.kth.ict.nextgenpos.model.ItemIdDoesNotExistException;
import se.kth.ict.nextgenpos.model.ProductSpecification;
import se.kth.ict.nextgenpos.view.View;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Starts the application.
 */
public class Main {
    public static void main(String[] args) {
		Logger LOGGER = Logger.getLogger( ItemIdDoesNotExistException.class.getName() );

		// Add a log handler which writes to file
		try {
			FileHandler fh = new FileHandler("log.txt");
			LOGGER.addHandler(fh);

			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

		} catch (IOException e) {
			LOGGER.info(e.toString());
		}

		Controller cont = new Controller();
		View view = new View(cont);
		view.stateHasChanged();
		view.test();
    }
}

