package com.example.functional;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GeneralFunctionalExamples {
	
	final Function<String, Predicate<String>> startsWithLetter = 
			(final String letter) -> {
				final Predicate<String> checkStarts = (final String name) -> name.startsWith(letter);
				return checkStarts;
			};
			
	final Function<String, Predicate<String>> startsWithLetter2 = 
			(final String letter) ->
				(final String name) ->
					name.startsWith(letter);
					
	final Function<String, Predicate<String>> startsWithLetter3 = 
			letter -> name -> name.startsWith(letter);
	
	final Function<List<String>, Optional<String>> findLongestName = 
			names -> names.stream().reduce((n1, n2) -> n1.length() >= n2.length() ? n1 : n2);
			
	final Function<List<String>, String> steveOrLonger = 
			names -> names.stream().reduce("steve", (n1, n2) -> n1.length() >= n2.length() ? n1 : n2);
	
	final Function<List<String>, String> commaList = 
			names -> names.stream().collect(Collectors.joining(", ")); 
	
	final Function<String, List<Character>> toChars = 
			str ->	str.chars()
				.mapToObj(ch -> Character.valueOf((char)ch))
				.collect(Collectors.toList());
	
	public static Predicate<String> startsWithLetter(final String letter) {
		return word -> word.startsWith(letter);
	}
	
	final Comparator<Integer> compareAscending = (int1, int2) -> int1 - int2;
	
	final Comparator<Integer> compareDescending = compareAscending.reversed();
	
	final Function<List<Integer>, List<Integer>> sortInts = ints -> ints.stream()
			.sorted(compareAscending)
			.collect(Collectors.toList());
	
	final Function<Person, Integer> byAge = person -> person.getAge();
	final Function<Person, String> byName = person -> person.getName();
	
	final Function<List<Person>, List<Person>> comparePeople = 
			people -> people.stream()
				.sorted(Comparator.comparing(byAge).thenComparing(byName))
				.collect(Collectors.toList());
			
	final Comparator<Person> byAge2 = Comparator.comparing(Person::getAge);
	final Function<List<Person>, Map<Character, Optional<Person>>> oldestByNameLetter = 
			people -> people.stream()
				.collect(Collectors.groupingBy(person -> person.getName().charAt(0), 
						Collectors.reducing(BinaryOperator.maxBy(byAge2))));

	final String[] files = new File("dirName").list(new java.io.FilenameFilter() {
		public boolean accept(final File dir, final String name) {
			return name.endsWith(".java");
		}
	});
	
	Files.newDirectoryStream(Paths.get("dirName"), path -> path.toString().endsWith(".java")).forEach(System.out::println);
	
	List<File> files2 = Stream.of(
			new File(".").listFiles())
				.flatMap(file -> file.listFiles() == null ?
						Stream.of(file) : Stream.of(file.listFiles()))
				.collect(Collectors.toList());
	
	final BiFunction<List<Person>, Predicate<Person>, List<Person>> findPeople = 
				(people, filter) -> people.stream().filter(filter).collect(Collectors.toList());
				
	// setting multiple filters for something
	public  <T> Optional<T> applyFilters(final Function<T, T>... filters) {
		return Stream.of(filters).reduce((filter, next) -> filter.compose(next).apply(arg0));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Person {
	private final Integer age;
	private final String name;
	public Person(final Integer age, final String name) {
		this.age = age;
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	
}
