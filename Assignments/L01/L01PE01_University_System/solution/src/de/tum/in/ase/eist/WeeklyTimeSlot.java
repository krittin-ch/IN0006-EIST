package de.tum.in.ase.eist;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class WeeklyTimeSlot extends TimeSlot {
	// Attribute
	private DayOfWeek dayOfWeek;

	// Constructor
	public WeeklyTimeSlot(DayOfWeek dayOfWeek, LocalTime starTime, LocalTime endTime) {
		super(starTime, endTime);
		this.dayOfWeek = dayOfWeek;
	}

	// getter
	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}
}
