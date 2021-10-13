package de.marvinstier.tradinggame.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.marvinstier.tradinggame.exceptions.ShipFullException;
import de.marvinstier.tradinggame.models.Cargo.CargoType;

class ShipTest {

	Ship bloodyMary, blackPearl;
	Cargo bananas, gunpowder, bricks;

	@BeforeEach
	void setupShips() {
		bloodyMary = new Ship("Bloody Mary", 5);
		blackPearl = new Ship("Black Pearl", 10);
	}

	@BeforeEach
	void setupCargo() {
		bananas = new Cargo("Bananas", 1);
		gunpowder = new Cargo("Gunpowder", CargoType.EXPLOSIVE, 3);
		bricks = new Cargo("Bricks", CargoType.FRAGILE, 6);
	}

	@Test
	void testShipHasDisplayName() {
		assertEquals("Bloody Mary", bloodyMary.getDisplayName());
		assertEquals("Black Pearl", blackPearl.getDisplayName());
	}

	@Test
	void testShipHasCargoCapacity() {
		assertEquals(5, bloodyMary.getCargoCapacity());
		assertEquals(10, blackPearl.getCargoCapacity());
	}

	@Test
	void testCanLoadCargo() {
		bloodyMary.loadCargo(bananas);
		bloodyMary.loadCargo(gunpowder);
		assertTrue(bloodyMary.getCargoDirectory().contains(bananas));
		assertTrue(bloodyMary.getCargoDirectory().contains(gunpowder));

		blackPearl.loadCargo(bananas);
		blackPearl.loadCargo(gunpowder);
		blackPearl.loadCargo(bricks);
		assertTrue(blackPearl.getCargoDirectory().contains(bananas));
		assertTrue(blackPearl.getCargoDirectory().contains(gunpowder));
		assertTrue(blackPearl.getCargoDirectory().contains(bricks));
	}

	@Test
	void testWeightCorrectAfterLoadingCargo() {
		bloodyMary.loadCargo(bananas);
		bloodyMary.loadCargo(gunpowder);
		assertEquals(4, bloodyMary.getCargoWeight());

		blackPearl.loadCargo(bananas);
		blackPearl.loadCargo(gunpowder);
		blackPearl.loadCargo(bricks);
		assertEquals(10, blackPearl.getCargoWeight());
	}

	@Test
	void testThrowsShipFullException() {
		bloodyMary.loadCargo(bananas);
		bloodyMary.loadCargo(gunpowder);

		assertThrows(ShipFullException.class, () -> {
			bloodyMary.loadCargo(bricks);
		});
		assertEquals(4, bloodyMary.getCargoWeight());
		assertFalse(bloodyMary.getCargoDirectory().contains(bricks));
	}

}
