package com.bilgeadam.boost.java.course02.lesson074.basic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTest {

	public static void main(String[] args) {
		Method[] methods = Person.class.getDeclaredMethods();
		Constructor[] contructors = Person.class.getDeclaredConstructors();
		Field[] fields = Person.class.getDeclaredFields();

		for (Field field : fields) {
			System.out.println(Modifier.toString(field.getModifiers())  + " " + field.getName() + " " + field.toString());
		}
		System.out.println();
		
		for (Constructor constructor : contructors) {
			System.out.println( Person.class.getSimpleName() + " sınıfının tanımlı yapıcı metodu " + constructor.getModifiers() + " - " +constructor.toString());
		}
		System.out.println();
		for (Method method : methods) {
			System.out.println( Person.class.getSimpleName() + " sınıfının tanımlı methodu " + method.getName());
		}
		System.out.println();
		for (Method method : Person.class.getMethods()) {
			System.out.println( Person.class.getSimpleName() + " sınıfının tüm methodu " + method.getName());
		}

	}

}
