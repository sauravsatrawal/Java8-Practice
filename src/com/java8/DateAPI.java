package com.java8;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DateAPI {
	
	// YYYY MM dd
	private static String[] lines= {"Sarah 1999 10 15","Philip 1993 8 12","Beth 1988 12 28"};
	
	public static void main(String[] args) {
		
//		sample();
		
//		localDate();
		
		localTime();
	
	}
	
	public static void sample() {
		/**
		 * Instant with Duration
		 */
		Instant nowTime1 = Instant.now();
		Instant nowTime2 = Instant.now();
		
		Duration duration = Duration.between(nowTime1, nowTime2);
		
		
		/**
		 * LocalDate with Period
		 */
		LocalDate localDate = LocalDate.now();
		LocalDate localDate2 = LocalDate.of(1564, Month.APRIL, 1);
		
		Period.between(localDate, localDate2);
		Period period = localDate2.until(localDate);								// years
		long days = localDate2.until(localDate, ChronoUnit.DAYS);
	}


	private static void localTime() {
		LocalTime bedGoingTime = LocalTime.of(22, 15);
		System.out.println(bedGoingTime);
		
		LocalTime wakeUpTime = bedGoingTime.plusHours(8);
		System.out.println(wakeUpTime);
		
		
//		ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);
		ZonedDateTime pragueTime = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.of("Europe/Prague"));
		System.out.println("Prague Time (w.r.t Here) : " +pragueTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		System.out.println("Prague Time : " + ZonedDateTime.now().minusSeconds(pragueTime.getOffset().getTotalSeconds()).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
	}


	private static void localDate() {
		
		String combined = Arrays.asList(lines).stream().reduce( (x,y) -> x+System.getProperty("line.separator")+y ).orElse("");
		List<Person> persons = new ArrayList<>();
		
		try(
				BufferedReader reader = new BufferedReader(new InputStreamReader( new ByteArrayInputStream(combined.getBytes())  ));
				Stream<String> stream = reader.lines();
		) {
			stream.map(
					line -> {
						String[] data = line.split(" ");
						return  new Person(data[0], LocalDate.of(Integer.parseInt(data[1]), Month.of( Integer.parseInt(data[2]) ), Integer.parseInt(data[3])));
					}
			).forEach(p -> persons.add(p));
		}
		catch(IOException e) {
			e.printStackTrace();
		}

		LocalDate now = LocalDate.now();
		
		persons.stream().forEach(
				p -> {
					Period period = Period.between(p.getDob(), now);
					System.out.println(p.getName() +" is now " +
							period.get(ChronoUnit.YEARS) +" years and "+
							period.get(ChronoUnit.MONTHS)+" months old" +
							" ["+p.getDob().until(now, ChronoUnit.DAYS)+" months]"
						);
				});
		
		System.out.println( now.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY)) );
		
	}
}

class Person {
	private String name;
	private LocalDate dob;
	
	public Person(String name, LocalDate dob) {
		this.name = name;
		this.dob = dob;
	}
	
	public String getName() {
		return name;
	}
	
	public LocalDate getDob() {
		return dob;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", dob=" + dob + "]";
	}
}
