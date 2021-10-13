package de.marvinstier.tradinggame.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.marvinstier.tradinggame.models.Cargo.CargoType;

class CargoTest {

	Cargo bananas, gunpowder;

	@BeforeEach
	void setupCargo() {
		bananas = new Cargo("Bananas", 1);
		gunpowder = new Cargo("Gunpowder", CargoType.EXPLOSIVE, 3);
	}

	@Test
	void testCargoHasDisplayName() {
		assertEquals("Bananas", bananas.getDisplayName());
		assertEquals("Gunpowder", gunpowder.getDisplayName());
	}

	@Test
	void testCargoHasCargoType() {
		assertEquals(CargoType.DEFAULT, bananas.getCargoType());
		assertEquals(CargoType.EXPLOSIVE, gunpowder.getCargoType());
	}

	@Test
	void testCargoHasWeight() {
		assertEquals(1, bananas.getWeight());
		assertEquals(3, gunpowder.getWeight());
	}

}
