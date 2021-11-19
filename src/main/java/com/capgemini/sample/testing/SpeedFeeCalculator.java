package com.capgemini.sample.testing;

import lombok.Value;

/**
 * <=50 km/h – brak kary
 * <=60 km/h – 50pln
 * <=70 km/h – 100pln, 2pkt
 * <=80 km/h – 200pln, 4pkt
 * <=90 km/h – 300pln, 6pkt
 * <=100 km/h – 400pln, 8pkt,
 * >100km/h – 500pln, 10pkt, zatrzymane prawo jazdy
 */
public class SpeedFeeCalculator {

	public Fee fee(int speed) {
		if (speed < 0) {
			throw new IllegalStateException("Speed should be a positive or equal zero");
		}
		if (speed <= 50) {
			return new Fee(0, 0, false);
		}
		if (speed <= 60) {
			return new Fee(50, 0, false);
		}
		if (speed <= 70) {
			return new Fee(100, 2, false);
		}
		if (speed <= 80) {
			return new Fee(200, 4, false);
		}
		if (speed <= 90) {
			return new Fee(300, 6, false);
		}
		if (speed <= 100) {
			return new Fee(400, 8, false);
		}
		return new Fee(500, 10, true);
	}

	@Value
	static class Fee {

		int fee;

		int points;

		boolean hasToReturnDriverLicense;

	}

}
