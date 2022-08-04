package com.bilgeadam.boost.java.course02.lesson074.basic;

public class Person {
	private static final int NUMBER = 3;
	private String name;
	private String surName;
	private int    birthYear;

	public Person(String name, String surName) {
		this.name    = name;
		this.surName = surName;
	}

	public Person(String name, String surName, int birthYear) {
		this(name, surName);
		this.birthYear = birthYear;
	}

	public int getBirthYear() {
		return this.birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public String getFullName() {
		return this.getName().concat(" ").concat(this.getSurName());
	}
	
	private String getName() {
		return this.name;
	}
	
	private String getSurName() {
		return this.surName;
	}
}
