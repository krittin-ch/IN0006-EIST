package de.tum.in.ase.eist;

public class LocalTutorGroupMeeting extends TutorGroupMeeting {
	// Attribute
	private String room;

	// Contributor
	public LocalTutorGroupMeeting(FixedDateTimeSlot timeSlot, TutorGroup tutorGroup, Skill skill, String room) {
		super(timeSlot, tutorGroup, skill);
		this.room = room;
	}

	// Function
	@Override
	public void practise() {
		getTutorGroup().getTutor().say(
			String.format("Thank you for coming to %s today.", room)
		);

		Skill skill = getSkillToPractise();
		for (Student student : getTutorGroup().getStudents()) {
			student.learnSkill(skill);
		}
		
		getTutorGroup().getTutor().say("See you next time!");
	}

	// getter
	public String getRoom() {
		return room;
	}
}
