package com.bilgeadam.boost.java.course02.lesson074.forname;

public class Dog {
	private String name;
	private int    age;

	@Override
	public String toString() {
		return "Dog [name=" + this.name + ", age=" + this.age + "]";
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age  = age;
	}

}
