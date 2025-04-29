package de.tum.in.ase.eist;

import java.time.LocalTime;
import java.time.Duration;

public abstract class TimeSlot {
	// Attribute
	private LocalTime startTime;
	private LocalTime endTime; 

	// Constructor
	public TimeSlot(LocalTime startTime, LocalTime endTime) {
		// if (endTime.isBefore(startTime)) {
		// 	throw new IllegalArgumentException("End time must be after start time.");
		// }
		this.startTime = startTime;
		this.endTime = endTime;
	}

	// Function
	public Duration getDuration() {
		if (startTime == null || endTime == null) {
			throw new IllegalStateException("No start and end time specified.");
		}

		return Duration.between(startTime, endTime);
	}

	// getter
	public LocalTime getStartTime() {
		return startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}
}
