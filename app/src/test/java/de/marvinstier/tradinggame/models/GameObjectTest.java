package de.marvinstier.tradinggame.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameObjectTest {

	private class GameObjectImpl extends GameObject {
		public GameObjectImpl() {
			super();
		}

		public GameObjectImpl(String displayName) {
			super(displayName);
		}
	}

	GameObject gameObject, customObject;

	@BeforeEach
	void setupGameObjects() {
		gameObject = new GameObjectImpl();
		customObject = new GameObjectImpl("CustomObject");
	}

	@Test
	void gameObjectHasDisplayName() {
		assertEquals("GameObject", gameObject.getDisplayName());
		assertEquals("CustomObject", customObject.getDisplayName());
	}

}
