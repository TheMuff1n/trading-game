package de.marvinstier.tradinggame.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.marvinstier.tradinggame.exceptions.ShipFullException;

/**
 * This class can be instantiated to create a ship with a name and cargo
 * capacity. As long as it has space it can be loaded with cargo.
 *
 * @author TheMuff1n
 * @version 1.0
 */
public class Ship extends GameObject {

	private int cargoCapacity;
	private List<Cargo> cargoDirectory;

	/**
	 * This constructor creates a ship with a given name and cargo capacity.
	 *
	 * @param displayName   inherited from {@link GameObject}
	 * @param cargoCapacity the ship's cargo capacity
	 */
	public Ship(String displayName, int cargoCapacity) {
		super(displayName);

		this.cargoCapacity = cargoCapacity;
		cargoDirectory = new ArrayList<>();
	}

	/**
	 * @return the weight of the loaded cargo
	 */
	public int getCargoWeight() {
		int sum = 0;
		for (Cargo c : cargoDirectory)
			sum += c.getWeight();
		return sum;
	}

	/**
	 * Tries to load given cargo onto the ship if possible, or throws a
	 * {@link ShipFullException} if the cargo would exceed max cargo capacity.
	 *
	 * @param cargo the cargo to be loaded
	 * @throws ShipFullException thrown if the cargo to be loaded would exceed max
	 *                           cargo capacity
	 */
	public void loadCargo(Cargo cargo) throws ShipFullException {
		if (getCargoWeight() + cargo.getWeight() > cargoCapacity)
			throw new ShipFullException();

		cargoDirectory.add(cargo);
	}

	/**
	 * @return the ship's cargo capacity
	 */
	public int getCargoCapacity() {
		return cargoCapacity;
	}

	/**
	 * @return the ships's cargo directory as an immutable list
	 */
	public List<Cargo> getCargoDirectory() {
		return Collections.unmodifiableList(cargoDirectory);
	}

}
