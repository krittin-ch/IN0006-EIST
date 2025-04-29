// UNFINISHED
package de.tum.in.ase.eist;

import java.util.HashSet;
import java.util.Set;

public class Student extends Person {
	// Attribute
	private String matriculationNumber;
	private StudyLevel studyLevel;
	private int semester;
	private Set<Skill> skills = new HashSet<>();
	private Set<String> knowledge = new HashSet<>();

	// Constructor
	public Student(String name, int age, String tumId, String matriculationNumber, StudyLevel studyLevel, int semester) {
		super(name, age, tumId);

		this.matriculationNumber = matriculationNumber;
		this.semester = semester;
		this.studyLevel = studyLevel;
	}

	// Function
	public void acquireKnowledge(String newKnowledge) {
		knowledge.add(newKnowledge);
	}

	public void learnSkill(Skill skill) {
		skills.add(skill);
	}

	// getter
	public String getMatriculationNumber() {
		return matriculationNumber;
	}

	public StudyLevel getStudyLevel() {
		return studyLevel;
	}

	public int getSemester() {
		return semester;
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public Set<String> getKnowledge() {
		return knowledge;
	}
}
