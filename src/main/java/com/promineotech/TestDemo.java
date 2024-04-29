package com.promineotech;

import java.util.Random;

public class TestDemo {
public int addPositive(int a, int b) {
	if (a > 0 && b > 0) {
        return a + b;
    } else {
        throw new IllegalArgumentException("Both parameters must be positive!");
}
}

public static int subtractPositive(int c, int d) {
	if (c > 0 && d > 0) {
		return c - d;
	}else {
		throw new IllegalArgumentException("Both parameters must be positive!");
	}
	}

public int randomNumberSquared() {
	int result = getRandomInt();
	return result * result; 
	}
	int getRandomInt() {
	Random random = new Random();
	return random.nextInt(10) + 1;
}
}	

