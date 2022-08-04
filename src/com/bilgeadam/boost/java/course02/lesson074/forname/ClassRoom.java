package com.bilgeadam.boost.java.course02.lesson074.forname;

public class ClassRoom {
	private String name;
	private int numOfStudents;
	private boolean weekEndClass;
	
	public ClassRoom(String name, int numOfStudents) {
		super();
		this.name          = name;
		this.numOfStudents = numOfStudents;
	}

	public ClassRoom(String name, int numOfStudents, boolean weekEndClass) {
		this(name, numOfStudents);
		this.weekEndClass = weekEndClass;
	}

	public boolean isWeekEndClass() {
		return this.weekEndClass;
	}

	public void setWeekEndClass(boolean weekEndClass) {
		this.weekEndClass = weekEndClass;
	}

	public String getName() {
		return this.name;
	}

	public int getNumOfStudents() {
		return this.numOfStudents;
	}

	@Override
	public String toString() {
		return "ClassRoom [name=" + this.name + ", numOfStudents=" + this.numOfStudents + ", weekEndClass="
				+ this.weekEndClass + "]";
	}
	
}
