package com.bilgeadam.boost.java.course02.lesson074.forname;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.bilgeadam.boost.java.course02.lesson074.basic.Person;

public class ForNameTest {
	private record RegisteredClass(String packageName, String className) {};
	
	private Map<String, RegisteredClass> myClasses;
	
	public static void main(String[] args) {
		ForNameTest test = new ForNameTest();
		test.registerClasses();
		test.work();
	}

	private void work() {
		String selection = null;
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Yaratmak istediğiniz sınıf tipini giriniz (kedi, köpek, sınıf, insan): ");
			selection = input.nextLine();
		}
		
		if (selection != null && !selection.equals("") && myClasses.containsKey(selection.toLowerCase())) {
			this.workWithClass(selection.toLowerCase());
		}
	}

	private void workWithClass(String selection) {
		RegisteredClass selectedClass = this.myClasses.get(selection);
		String className = selectedClass.packageName + "." + selectedClass.className();
		try {
			Class<?> clazz = Class.forName(className);
			Constructor<?>[] contructors = clazz.getConstructors();
//			for (Constructor<?> constructor : contructors) {
//				System.out.println(constructor.toString());
//			}
			
			Constructor<?> constructor = contructors[0];
			int params = constructor.getParameterCount();
			Parameter[] parameters = constructor.getParameters();

			Object obj = null;
			if (params == 3) {
				obj = constructor.newInstance("Babür", "Somer", 1964);
			}
			else if (params == 2) {
				obj = constructor.newInstance("Babür", "Somer");
			}
			System.out.println(obj.toString());
			if (obj instanceof Person) {
				Person person = (Person)obj;
			}
			else if (obj instanceof ClassRoom) {
				ClassRoom cR = (ClassRoom)obj;
				cR.setWeekEndClass(true);
				System.out.println(cR);
			}
			
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				String modifier = Modifier.toString(method.getModifiers());
				if (modifier.equalsIgnoreCase("private")) {
					method.setAccessible(true);
					System.out.println(method.invoke(obj));
				}
			}
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
			ex.printStackTrace();
		}
	}

	private void registerClasses() {
		this.myClasses = new HashMap<>();
		this.myClasses.put("sınıf", new RegisteredClass("com.bilgeadam.boost.java.course02.lesson074.forname", "ClassRoom"));
		this.myClasses.put("kedi",  new RegisteredClass("com.bilgeadam.boost.java.course02.lesson074.forname", "Cat"));
		this.myClasses.put("köpek", new RegisteredClass("com.bilgeadam.boost.java.course02.lesson074.forname", "Dog"));
		this.myClasses.put("insan", new RegisteredClass("com.bilgeadam.boost.java.course02.lesson074.basic",   "Person"));
	}

	/* record yerine 
	private class RegisteredClass {
		private String packageName;
		private String ClassName;
		
		....
		
	 */
}
