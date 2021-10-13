package de.marvinstier.tradinggame.models;

public abstract class GameObject {

	protected String displayName;

	public String getDisplayName() {
		return displayName;
	}

	public GameObject(String displayName) {
		this.displayName = displayName;
	}

	public GameObject() {
		this("GameObject");
	}

}
