package de.tum.in.ase.eist;

import java.time.LocalDate;
import java.time.LocalTime;

public class FixedDateTimeSlot extends TimeSlot {
	// Attribute
	private LocalDate date;

	// Constructor
	public FixedDateTimeSlot(LocalDate date, LocalTime startTime, LocalTime endTime) {
		super(startTime, endTime);
		this.date = date;
	}

	// getter
	public LocalDate getDate() {
		return date;
	}
}
