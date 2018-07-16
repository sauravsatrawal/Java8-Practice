package com.java8;
public class LembdaExpressions {
	public static void main(String[] args) {
		Greeting greeting = () -> System.out.println("Greeting Anonymous Implementation");
		greeting.foo();
		
																																						// Type-2
		Greeting greeting2 = () -> fooImplementation();
		greeting2.foo();
		
																																						// Type-3
		StringLengthLambda stringLengthLambda = (String s) -> s.length();
		System.out.println( stringLengthLambda.getLength("Hello World") );
																																						// Type-4 (Removing parameter type)
		StringLengthLambda stringLengthLambda2 = (s) -> s.length();
		System.out.println( stringLengthLambda2.getLength("Hello World2") );
		
																																						// Type-5 
		printStringLengthLambda(s -> s.length());
	}

	private static void fooImplementation() {
		System.out.println("Greeting Anonymous Implementation-2");
	}
	
	private static void printStringLengthLambda(StringLengthLambda lambda) {
		System.out.println(lambda.getLength("Hello world 3"));
	}
}

@FunctionalInterface
interface Greeting {
	void foo();
}

interface StringLengthLambda {
	int getLength(String s);
}