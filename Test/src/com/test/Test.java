package com.test;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface MyInterface {
	void test(String name);
}

public class Test {
	public static void main(String[] args) {
		Runnable r;
		/*
		 * Runnable r=()-> System.out.println("Hello "); Thread t=new Thread(r);
		 * t.start();
		 * 
		 * MyInterface m=( name)->System.out.println("Test"+name); m.test("Gourav");
		 */
		System.out.println(" \t Example of Predicate...!!!! \n");
		Integer arr[] = { 1, 2, 3, 4, 5 };

		Predicate<Integer> p = (n) -> n % 2 == 0;

		Predicate<Integer> p2 = (n) -> n % 3 == 0;

		Predicate<Integer> p3 = p.negate();

		for (Integer i : arr) {
			System.out.println(p3.test(i));
		}

		// Function
		System.out.println(" \t Example of Function...!!!! \n");
		String a = "Hello", b = "World";
		Function<String, String> f = (a1) -> {
			a1 = a1.concat(b);
			return a1;
		};

		System.out.println(f.apply(a));

		// Consumer
		System.out.println(" \t Example of Consumer...!!!! \n");
		Consumer<Integer> c = (i) -> System.out.println(i * i);
		c.accept(5);

		// Supplier
		System.out.println(" \t Example of Supplier...!!!! \n");
		Supplier<String> s = () -> {
			int i = 0;
			return "Num is " + (i + 7);
		};
		
		System.out.println(s.get());
		
		
		// BiConsumer
		System.out.println(" \t Example of BiConsumer...!!!! \n");
		BiConsumer<Integer,Integer> bc = (i,j) -> System.out.println("Multplication is "+i * j);
		bc.accept(5,10);
		
		
		
		
		
	}

}
