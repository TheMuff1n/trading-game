package de.marvinstier.tradinggame.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.marvinstier.tradinggame.exceptions.HarbourFullException;

/**
 * This class can be instantiated to create a harbour with a given capacity for
 * ships to dock if there is docking space.
 *
 * @author TheMuff1n
 * @version 1.0
 */
public class Harbour extends GameObject {

	private int shipCapacity;
	private List<Ship> dockedShips;

	/**
	 * This constructor creates a harbour with given name and ship capacity.
	 *
	 * @param displayName  inherited from {@link GameObject}
	 * @param shipCapacity the harbour's ship capacity
	 */
	public Harbour(String displayName, int shipCapacity) {
		super(displayName);

		this.shipCapacity = shipCapacity;
		dockedShips = new ArrayList<>();
	}

	/**
	 * Tries to dock a given ship or throws a {@link HarbourFullException} if the
	 * harbour is at max ship capacity.
	 *
	 * @param ship the ship to dock
	 * @throws HarbourFullException thrown if the harbour is already full
	 */
	public void dockShip(Ship ship) throws HarbourFullException {
		if (dockedShips.size() + 1 > shipCapacity)
			throw new HarbourFullException();

		dockedShips.add(ship);
	}

	/**
	 * @return the docked ships as an immutable list
	 */
	public List<Ship> getDockedShips() {
		return Collections.unmodifiableList(dockedShips);
	}

}
