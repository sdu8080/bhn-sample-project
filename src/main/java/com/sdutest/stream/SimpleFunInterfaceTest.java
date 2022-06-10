package com.sdutest.stream;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  functional interface is a interface with @FunctionalInterface annotation with a single abstract 
 *  method declaration.  It allows program to pass in a lambda function to the single abstract method 
 *  to implement the  interface, which can be executed at runtime. 
 *  
 *  often functional interface combines with Generic data type to make the interface perform variable 
 *  business logics based on the obejct type and different lambda function.
 *
 */
public class SimpleFunInterfaceTest {

	public static void main(String[] args) {

		/*
		 * defines the lambda express to use the business class and its method,
		 * and assign the lambda to functional interface (similar to provide an
		 * anonymous inner class.)
		 */
		
		// single line lambda function
		SimpleFuncInterface<Foo> simple1 = (Foo f) -> f.method();
		
		// multiple line lambda function
		SimpleFuncInterface<Bar> simple2 = (Bar b) -> {
			System.out.println("do something in lambda.");
			ExecutorService pool = Executors.newFixedThreadPool(1);
			pool.execute(b);
			pool.shutdown();
		};
		
		
		// call the interface method, which will call the lambda expression
		Foo foo = new Foo();
		simple1.doWork(foo);

		Bar bar = new Bar();
		simple2.doWork(bar);
	}

	// my class with business method
	public static class Foo {
		public void method() {
			System.out.println("doing some business logic.");
		}
	}

	// a more complicate business object
	public static class Bar implements Runnable{
		public void doMyWork() {
			System.out.println("do something in the class.");
		}

		@Override
		public void run() {
			doMyWork();
		}
	}

	@FunctionalInterface
	public interface SimpleFuncInterface<T> {
		public void doWork(T t);
	}
}