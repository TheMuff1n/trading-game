package de.marvinstier.tradinggame.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.marvinstier.tradinggame.exceptions.HarbourFullException;

class HarbourTest {

	Harbour hamburg;
	Ship bloodyMary, blackPearl, royalBoat;

	@BeforeEach
	void setupHarbour() {
		hamburg = new Harbour("Hamburg", 2);
	}

	@BeforeEach
	void setupShips() {
		bloodyMary = new Ship("Bloody Mary", 5);
		blackPearl = new Ship("Black Pearl", 10);
		royalBoat = new Ship("Royal Boat", 1);
	}

	@Test
	void testHarbourHasDisplayName() {
		assertEquals("Hamburg", hamburg.getDisplayName());
	}

	@Test
	void testShipsCanDock() {
		hamburg.dockShip(bloodyMary);
		hamburg.dockShip(blackPearl);

		assertTrue(hamburg.getDockedShips().contains(bloodyMary));
		assertTrue(hamburg.getDockedShips().contains(blackPearl));
	}

	@Test
	void testThrowsHarbourFullException() {
		hamburg.dockShip(bloodyMary);
		hamburg.dockShip(blackPearl);

		assertThrows(HarbourFullException.class, () -> {
			hamburg.dockShip(royalBoat);
		});
		assertFalse(hamburg.getDockedShips().contains(royalBoat));
	}

}
