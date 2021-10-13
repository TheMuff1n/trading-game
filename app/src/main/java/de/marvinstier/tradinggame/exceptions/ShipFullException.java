package de.marvinstier.tradinggame.exceptions;

public class ShipFullException extends RuntimeException {

	private static final long serialVersionUID = -1848658055736255625L;

	public ShipFullException() {
		super("This ship is full.");
	}

}
