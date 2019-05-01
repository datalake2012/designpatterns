package com.sunlife.designpatterns;

/**
 * Thread safe Singleton pattern implemented with double-checked locking.
 */
public class Singleton {
	private static volatile Singleton instance;

	/**
	 * Private constructor
	 */
	private Singleton() {
	}

	/**
	 * Use getInstance method to create Singleton instance
	 * 
	 * @return instance - current instance of the Singleton
	 */
	public static Singleton getInstance() {
		// Double-Checked Locking to improve performance
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}

		return instance;
	}
	/*
	public void doSomething() {
		System.out.println("Hello, World!");
	}
	*/
}
