package org.atras.services;

public class MathUtils {

	protected int add(int a, int b) {
		return a + b;
	}

	public double computeCircleArea(int radius) {
		double area = Math.PI * Math.pow(radius, 2);
		return area;
	}

	public int testException(boolean isThrowException) {
		if (isThrowException) {
			throw new ArithmeticException();
		}
		return 0;

	}
}
