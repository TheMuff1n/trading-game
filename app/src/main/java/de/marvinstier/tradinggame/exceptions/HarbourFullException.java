package de.marvinstier.tradinggame.exceptions;

/**
 * This exception can be used to show that a harbour has reached max ship
 * capacity.
 *
 * @author TheMuff1n
 * @version 1.0
 */
public class HarbourFullException extends RuntimeException {

	private static final long serialVersionUID = 8253580494133238765L;

	/**
	 * This constructor creates a {@link RuntimeException} with the message "This
	 * harbour is full.".
	 */
	public HarbourFullException() {
		super("This harbour is full.");
	}

}
