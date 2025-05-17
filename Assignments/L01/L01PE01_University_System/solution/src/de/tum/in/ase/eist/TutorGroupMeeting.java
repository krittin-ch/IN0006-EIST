package de.tum.in.ase.eist;

public abstract class TutorGroupMeeting {
	// Attribute
	private FixedDateTimeSlot timeSlot;
	private Skill skillToPractise;
	private TutorGroup tutorGroup;

	// Constructor
	public TutorGroupMeeting(FixedDateTimeSlot timeSlot, TutorGroup tutorGroup, Skill skillToPractise) {
		this.timeSlot = timeSlot;
		this.tutorGroup = tutorGroup;
		this.skillToPractise = skillToPractise;
	}

	// Function (abstract)
	public abstract void practise();

	// getter
	public FixedDateTimeSlot getTimeSlot() {
		return timeSlot;
	}

	public Skill getSkillToPractise() {
		return skillToPractise;
	}

	public TutorGroup getTutorGroup() {
		return tutorGroup;
	}
}
