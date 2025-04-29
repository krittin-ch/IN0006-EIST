package de.tum.in.ase.eist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TutorGroup {
	// Attribute
	private String id;
	private WeeklyTimeSlot timeSlot;
	private Person tutor;
	private List<TutorGroupMeeting> meetings = new ArrayList<>();
	private Set<Student> students = new HashSet<>();

	// Constructor
	public TutorGroup(String id, WeeklyTimeSlot timeSlot, Person tutor) {
		this.id = id;
		this.timeSlot = timeSlot;
		this.tutor = tutor;
	}

	// Function
	void addMeeting(TutorGroupMeeting tutorGroupMeeting) {
		meetings.add(tutorGroupMeeting);
	}

	public void register(Student student) {
		students.add(student);
	}

	// getter
	public String getId() {
		return id;
	}

	public WeeklyTimeSlot getTimeSlot() {
		return timeSlot;
	}

	public Person getTutor() {
		return tutor;
	}

	public List<TutorGroupMeeting> getTutorGroupMeetings() {
		return meetings;
	}

	public Set<Student> getStudents() {
		return students;
	}
}
