package de.tum.in.ase.eist;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class TutorGroupStatistics {
	private TutorGroupStatistics() {

	}

	public static double averageDuration(Stream<TutorGroupMeeting> meetingStream) {
		return meetingStream
			.mapToLong(m -> m.getTimeSlot().getDuration().toSeconds())	// map each meeting to fixed time slot, then access to its duration
			.average()	// finding average 
			.orElse(0);	// if cannot complete (no meeting), return 0
	}

	public static Set<Skill> repeatedSkills(Stream<TutorGroupMeeting> meetings) {
		List<Skill> skills = meetings
			.map(TutorGroupMeeting::getSkillToPractise) 	// m -> m.getSkill()
			.collect(Collectors.toList());		// convert into list

		return skills.stream()
			.filter(skill -> Collections.frequency(skills, skill) > 1) // extract skills repeated more than 1
			.collect(Collectors.toSet());	// convert into set

		/*
		Map<Skill, Long> skillCounts = meetings
			.map(TutorGroupMeeting::skillToPractice)	// m -> m.getSkill()
			.collect(Collectors.groupingBy(skill -> skill, Collectors.counting())); // group skill to no. of counts

		return skillCounts.entrySet().stream()
			.filter(entry -> (entry.getValue() > 1))	// filter only more than 1 (repeated skill)
			.map(Map.entry::getKey) 					// entry -> entry.getKey()
			.collect(Collectors.toSet());				// convert into set
		*/
	}
}
