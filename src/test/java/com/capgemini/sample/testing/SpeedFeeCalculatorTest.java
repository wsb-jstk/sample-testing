package com.capgemini.sample.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SpeedFeeCalculatorTest {

	private SpeedFeeCalculator speedFeeCalculator;

	@BeforeEach
	void setUp() {
		speedFeeCalculator = new SpeedFeeCalculator();
	}

	@ParameterizedTest(name = "{displayName} [{index}]: {argumentsWithNames}")
	@CsvSource(value = {//
			"0,0,0,false", //
			"50,0,0,0,false", //
			"51,50,0,false", //
			"60,50,0,false", //
			"61,100,2,false", //
			"70,100,2,false", //
			"71,200,4,false", //
			"80,200,4,false", //
			"81,300,6,false", //
			"90,300,6,false", //
			"91,400,8,false", //
			"100,400,8,false", //
			"101,500,10,true", //
			"1000,500,10,true" //
	})
	void shouldReturnFee_whenDrivingTooFast(int speed, int expectedFee, int expectedPoints, boolean expectedHasToReturnDriverLicense) {
		// given
		SpeedFeeCalculator.Fee fee = new SpeedFeeCalculator.Fee(expectedFee, expectedPoints, expectedHasToReturnDriverLicense);
		// when
		SpeedFeeCalculator.Fee result = speedFeeCalculator.fee(speed);
		// then
		assertEquals(fee, result);
	}

	@Test
	void shouldThrowIllegalStateException_whenSpeedIsNegative() {
		// given
		int speed = -1;
		// then
		assertThrows(IllegalStateException.class, () -> speedFeeCalculator.fee(speed));
	}

	@Test
	void shouldThrowIllegalStateException_whenSpeedIsMaximumInteger() {
		// given
		int speed = Integer.MAX_VALUE;
		SpeedFeeCalculator.Fee fee = new SpeedFeeCalculator.Fee(500, 10, true);
		// when
		SpeedFeeCalculator.Fee result = speedFeeCalculator.fee(speed);
		// then
		assertEquals(fee, result);
	}

}
