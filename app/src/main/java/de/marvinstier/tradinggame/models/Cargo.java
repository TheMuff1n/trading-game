package de.marvinstier.tradinggame.models;

/**
 * This class can be instantiated to create cargo of different types that can be
 * loaded onto ships, traded etc.
 *
 * @author TheMuff1n
 * @version 1.0
 */
public class Cargo extends GameObject {

	/**
	 * Holds different types cargo can have.
	 *
	 * @author TheMuff1n
	 * @version 1.0
	 */
	public enum CargoType {
		DEFAULT, FRAGILE, EXPLOSIVE
	}

	private CargoType cargoType;
	private int weight;

	/**
	 * This constructor creates cargo of a given name, type and weight.
	 *
	 * @param displayName this {@link GameObject}'s display name
	 * @param cargoType   the cargo's type
	 * @param weight      the cargo's weight
	 */
	public Cargo(String displayName, CargoType cargoType, int weight) {
		super(displayName);

		this.cargoType = cargoType;
		this.weight = weight;
	}

	/**
	 * This constructor creates cargo of a given name and weight with type DEFAULT.
	 *
	 * @param displayName this {@link GameObject}'s display name
	 * @param weight      the cargo's weight
	 */
	public Cargo(String displayName, int weight) {
		this(displayName, CargoType.DEFAULT, weight);
	}

	/**
	 * @return the cargo's type
	 */
	public CargoType getCargoType() {
		return cargoType;
	}

	/**
	 * @return the cargo's weight
	 */
	public int getWeight() {
		return weight;
	}

}
