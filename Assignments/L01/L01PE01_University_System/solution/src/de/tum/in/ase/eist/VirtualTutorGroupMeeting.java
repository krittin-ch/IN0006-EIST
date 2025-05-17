package de.tum.in.ase.eist;

public class VirtualTutorGroupMeeting extends TutorGroupMeeting {
	// Attribute
	private String url;

	// Constructor
	public VirtualTutorGroupMeeting(FixedDateTimeSlot timeSlot, TutorGroup tutorGroup, Skill skill, String url) {
		super(timeSlot, tutorGroup, skill);
		this.url = url;
	}

	@Override
	public void practise() {
		getTutorGroup().getTutor().say(
			String.format("Thank you for joining using %s today.", url)
		);

		Skill skill = getSkillToPractise();
		for (Student student : getTutorGroup().getStudents()) {
			student.learnSkill(skill);
		}
		
		getTutorGroup().getTutor().say("See you next time!");
	}

	// getter
	public String getUrl() {
		return url;
	}
}
