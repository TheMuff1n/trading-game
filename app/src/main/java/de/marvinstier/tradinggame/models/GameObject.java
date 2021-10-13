package de.marvinstier.tradinggame.models;

/**
 * Abstract base class for every object that can be displayed or interacted
 * with.
 *
 * @author TheMuff1n
 * @version 1.0
 */
public abstract class GameObject {

	protected String displayName;

	/**
	 * This constructor assigns this game object the given name.
	 *
	 * @param displayName the game object's display name
	 */
	public GameObject(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * This constructor assigns this game object a default name (GameObject).
	 */
	public GameObject() {
		this("GameObject");
	}

	/**
	 * @return the game object's display name
	 */
	public String getDisplayName() {
		return displayName;
	}

}
