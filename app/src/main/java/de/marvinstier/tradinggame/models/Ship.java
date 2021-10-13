package de.marvinstier.tradinggame.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.marvinstier.tradinggame.exceptions.ShipFullException;

public class Ship extends GameObject {

	private int cargoCapacity;
	private List<Cargo> cargoDirectory;

	public Ship(String displayName, int cargoCapacity) {
		super(displayName);

		this.cargoCapacity = cargoCapacity;
		cargoDirectory = new ArrayList<>();
	}

	public int getCargoWeight() {
		int sum = 0;
		for (Cargo c : cargoDirectory)
			sum += c.getWeight();
		return sum;
	}

	public void loadCargo(Cargo cargo) throws ShipFullException {
		if (getCargoWeight() + cargo.getWeight() > cargoCapacity)
			throw new ShipFullException();

		cargoDirectory.add(cargo);
	}

	public int getCargoCapacity() {
		return cargoCapacity;
	}

	public List<Cargo> getCargoDirectory() {
		return Collections.unmodifiableList(cargoDirectory);
	}

}
