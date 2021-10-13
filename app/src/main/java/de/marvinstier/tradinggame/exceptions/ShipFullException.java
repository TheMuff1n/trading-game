package de.marvinstier.tradinggame.exceptions;

/**
 * This exception can be used to show that a ship has reached max cargo
 * capacity.
 *
 * @author TheMuff1n
 * @version 1.0
 */
public class ShipFullException extends RuntimeException {

	private static final long serialVersionUID = -1848658055736255625L;

	/**
	 * This constructor creates a {@link RuntimeException} with the message "This
	 * ship is full.".
	 */
	public ShipFullException() {
		super("This ship is full.");
	}

}
