package com.capgemini.sample.testing;

import java.time.LocalDate;
import java.time.Period;

public class PersonFactory {

	public Person of(String firstName, String lastName, LocalDate localDate) {
		final LocalDate now = LocalDate.now();
		if (localDate.compareTo(now) > 1) {
			throw new IllegalStateException("Birthdate is from the future");
		}
		Period age = Period.between(localDate, now);
		return new Person(firstName, lastName, age.getYears());
	}

}
