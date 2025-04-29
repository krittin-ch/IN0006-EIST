package de.tum.in.ase.eist;

public class Person {
	// Attribute
	private String name;
	private int age;
	private String tumId;

	// Constructor
	public Person(String name, int age, String tumId) {
		this.name = name;
		this.age = age;
		this.tumId = tumId;
	}

	// Function
	public final void say(String text) {
		System.out.println(
			String.format("%s said: %s", name, text)
		);
	}

	// getter
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getTumId() {
		return tumId;
	}
}
