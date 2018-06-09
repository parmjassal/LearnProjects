package org.learn.ds.segmentTree;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class AssociativeOperandRegitry {

	private static Set<String> registry;

	static {
		registry = new HashSet<>();
	}

	/*
	 * Register only classes not interfaces.
	 */
	public static void register(String className) {

		registry.add(className);
	}

	public static boolean isAssociativeOperand(String className) {

		if (registry.contains(className))
			return true;
		Class class1;
		try {
			class1 = Class.forName(className);
			Class temp = class1.getSuperclass();
			while (temp != null) {
				if (registry.contains(temp.getName())) {
					registry.add(className);
					return true;
				}
				temp = temp.getSuperclass();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
