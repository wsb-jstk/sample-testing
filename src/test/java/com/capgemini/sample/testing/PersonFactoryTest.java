package com.capgemini.sample.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is only an example and please do not start a discussion if this makes sense to check firstName and lastName in the same test-method or not.
 */
class PersonFactoryTest {

	private static final String FIRST_NAME = "John";

	private static final String LAST_NAME = "Smith";

	private PersonFactory personFactory;

	@BeforeEach
	void setUp() {
		personFactory = new PersonFactory();
	}

	/**
	 * Example of dependant assertion. If one fails - we will never know if the second success.
	 * <p>
	 * For test, You can set the first or second parameter of the {@link PersonFactory#of} method to null
	 */
	@Test
	void dependent() {
		// given
		Person person = personFactory.of(FIRST_NAME, LAST_NAME, generatePastDate(10));
		// then
		assertNotNull(person.getFirstName());
		assertEquals(FIRST_NAME, person.getFirstName());
		assertNotNull(person.getLastName());
		assertEquals(LAST_NAME, person.getLastName());
	}

	/**
	 * Example of grouped assertions. Sometimes called 'soft assertions'.
	 * Both groups will be executed (even if one will fail) and the test output will point to the failed group.
	 * <p>
	 * For test, You can set the first or second parameter of the {@link PersonFactory#of} method to null
	 */
	@Test
	void group() {
		// given
		Person person = personFactory.of(FIRST_NAME, LAST_NAME, generatePastDate(5));
		// then
		assertAll("person", () -> {
			assertNotNull(person.getFirstName());
			assertEquals(FIRST_NAME, person.getFirstName());
		}, () -> {
			assertNotNull(person.getLastName());
			assertEquals(LAST_NAME, person.getLastName());
		});
	}

	private LocalDate generatePastDate(int minusYears) {
		return LocalDate.now()
				.minusYears(minusYears);
	}

}
