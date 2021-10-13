package de.marvinstier.tradinggame.models;

public class Cargo extends GameObject {

	public enum CargoType {
		DEFAULT, FRAGILE, EXPLOSIVE
	}

	private CargoType cargoType;
	private int weight;

	public Cargo(String displayName, CargoType cargoType, int weight) {
		super(displayName);

		this.cargoType = cargoType;
		this.weight = weight;
	}

	public Cargo(String displayName, int weight) {
		this(displayName, CargoType.DEFAULT, weight);
	}

	public CargoType getCargoType() {
		return cargoType;
	}

	public int getWeight() {
		return weight;
	}

}
