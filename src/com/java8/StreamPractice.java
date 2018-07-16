package com.java8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice {

	public static void main(String[] args) {
		/**
		 * Check for Duplicates
		 */
//		Integer arr[] = {3,5,7,3,8};
//		Stream.of(arr).filter(i -> Collections.frequency(Stream.of(arr).collect(Collectors.toList()), i) > 1).collect(Collectors.toSet()).forEach(System.out::println);
		
		/**
		 * Write a method that returns the average of a list of integers.
		 */
//		Integer[] list = {1, 2, 3, 3, 6, 6, 7, 9};
//		System.out.println(Stream.of(list).collect(Collectors.averagingInt(i -> i)).doubleValue());
		
		/**
		 * Write a method that converts all strings in a list to their upper case.
		 */
//		List<String> list = Arrays.asList(new String[]{"ABC","ABC"});
//		System.out.println( list.stream().map(item -> item.toUpperCase()).collect(Collectors.toList()) );
		
		/**
		 * Get the unique surnames in uppercase of the first 3 book authors that are 50 years old or over.
		 */
//		List<Book> books = Arrays.asList(new Book[]{
//			new Book(new Author("fifty", 50, 'M')),
//			new Book(new Author("sixty", 60, 'F')),
//			new Book(new Author("forty", 40, 'F')),
//			new Book(new Author("special", 50, 'F')),
//			new Book(new Author("special2", 50, 'F')),
//			new Book(new Author("Femalyounger1", 20, 'F')),
//			new Book(new Author("Femalyounger2", 18, 'F')),
//			new Book(new Author("Femalolder", 54, 'F'))
//		});
//		
//		 books.stream()
//				.map(book -> book.author)
//				.filter(author -> author.age>=50)
//				.limit(3)
//				.collect(Collectors.toList())
//				.stream()
//				.map(author -> author.getLastName().toUpperCase())
////				.map(author ->author.getLastName())
////				.map(String::toUpperCase)
//				.distinct()
//				.forEach(System.out::println);
		

		/**
		 * Compute the sum of ages of all female authors younger than 25.
		 */
//		double sum = books.stream()
//									.map(book -> book.author)
//									.filter(author -> author.age<25)
//									.filter(author -> author.gender=='F')
//									.map(author -> author.age)
//									.collect(Collectors.summarizingDouble(age -> age))
//									.getSum();
//			
//		System.out.println(sum);
		
		/**
		 * Print all those words in uppercase which has length < 4 and has 'E' as of the characters
		 */
//		List<String> words = Arrays.asList("hi", "hello", "hola", "byee", "goodbye", "adios");
//		
//		
//		String value =  words.stream()
//								.map(String::toUpperCase)
//								.filter(word -> word.length() < 4)
//								.filter(word -> word.contains("E"))
//								.findFirst()
//								.orElse("Not Match");
//		
//		System.out.println(value);
		
		/**
		 * Show sum of all ascii values of character array
		 */
//		System.out.print( Arrays.asList(new Character[] { 'b','b','c' }).stream().mapToInt(i -> i).sum() );
		
		/**
		 * Show sum of all ascii values of character array
		 */
//		System.out.println( IntStream.of('a','b','c').sum() );
		
		/**
		 * Show sum of all ascii values of character array.... Looping using range
		 */
//		char[] arr = {'a','b','c'};
//		int sum = IntStream.range(0, arr.length).mapToObj(c -> arr[c]).map(i -> (int)i).reduce(0, Integer::sum);
//		System.out.println(sum);
		
		
		/**
		 * Show sum of all ascii values of character array.... Looping using range
		 */
//		char[] arr = {'a','b','c'};
//		IntStream.range(0, arr.length).mapToObj(c -> arr[c]).map(i -> (int)i).reduce(Integer::sum).ifPresent(s -> System.out.println(s));
		
		
		/**
		 * Produce a single String that is the result of concatenating the uppercase versions of all of the
		 *	Strings. E.g., the result should be "HIHELLO...". Use a single reduce operation, without using map.
		 */
//		List<String> words = Arrays.asList("hi", "hello", "hola", "byee", "goodbye", "adios");
//		String concat = words.stream().reduce("", (x,y) -> x.concat(y).toUpperCase());
//		System.out.println(concat);
		
		/**
		 * Produce the same String as above, but this time via a map operation that turns the words into upper
		 *	case, followed by a reduce operation that concatenates them.
		 */
//		List<String> words = Arrays.asList("hi", "hello", "hola", "byee", "goodbye", "adios");
//		String concat = words.stream().map(String::toUpperCase).reduce("", (x,y) -> x.concat(y));
//		System.out.println(concat);
		
		
		/**
		 * Produce a String that is all the words concatenated together, but with commas in between. E.g., the
		 *	result should be "hi,hello,...". Note that there is no comma at the beginning, before “hi”, and also no
		 *	comma at the end, after the last word. Major hint: there are two versions of reduce discussed in the
		 *  notes.
		 */
//		List<String> words = Arrays.asList("hi", "hello", "hola", "byee", "goodbye", "adios");
//		String concat = words.stream().collect(Collectors.joining(","));
//		System.out.println(concat);
		
		/**
		 * Find the total number of characters (i.e., sum of the lengths) of the strings in the List.
		 */
//		List<String> words = Arrays.asList("hi", "hello", "hola", "byee", "goodbye", "adios");
//		int count = words.stream().map(i -> i.length()).reduce(0, Integer::sum);
//		System.out.println(count);
		

		/**
		 * Compute the sum of the square roots of the numbers in the array. Find a shorter and simpler way
			than making a loop to tally the sum. Hint: review the notes on number-specialized streams, especially
			the fact that you make a DoubleStream from a double[] with DoubleStream.of, not Stream.of.
		 */
//		double[] numbers = {4.0, 16.0, 36.0};
//		DoubleStream stream = DoubleStream.of(numbers);
//		double sum = stream.map(i -> Math.sqrt(i)).sum();
//		System.out.println(sum);
		
		/**
		 * Find all those employees whose employee ID starts with "1" and living in Gurgaon
		 */
		List<Address> addressList1 = new ArrayList<>();
		addressList1.add(new Address("Delhi"));
		addressList1.add(new Address("Gurgaon"));
		
		List<Address> addressList2 = new ArrayList<>();
		addressList1.add(new Address("Delhi"));
		addressList1.add(new Address("Noida"));
		
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(123, addressList1));
		employeeList.add(new Employee(200, addressList2));
		
		employeeList.stream()
			.filter(employee -> Integer.toString(employee.id).startsWith("1"))
			.filter(employee -> employee.addressList.stream().anyMatch(address -> address.city.equals("Gurgaon")))
			.forEach(System.out::println);
			
		
		
		
		
	}
}

class Employee {
	int id;
	List<Address> addressList;
	
	public Employee(int id, List<Address> addressList) {
		this.id = id;
		this.addressList = addressList;
	}
}

class Address {
	String city;
	
	public Address(String city) {
		this.city = city;
	}
}


class Book {
	Author author;
	
	Book(Author author) {
		this.author = author;
	}
}

class Author {
	String lastName;
	int age;
	char gender;
	
	public Author(String lastName, int age, char gender) {
		this.lastName = lastName;
		this.age=age;
		this.gender = gender;
	}
	
	public String getLastName() {
		return lastName;
	}
	
}
