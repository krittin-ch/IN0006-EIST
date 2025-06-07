package de.tum.in.ase.eist.rest;

import de.tum.in.ase.eist.model.Person;
import de.tum.in.ase.eist.service.PersonService;
import de.tum.in.ase.eist.util.PersonSortingOptions;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class PersonResource {

    private final PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    // TODO Part 1: Implement the specified endpoints here
    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        if (person.getId() != null) {
            return ResponseEntity.badRequest().build(); // 400 Bad Request
        }
        Person savedPerson = personService.savePerson(person);
        return ResponseEntity.ok(savedPerson);          // 200 OK with a saved person in body
    }

    @PutMapping("/persons/{personId}")
    public ResponseEntity<Person> updatePerson(@PathVariable UUID personId) {
        PersonSortingOptions option = null;
        List<Person> personList = personService.getAllPersons(option);

        Person targetPerson = personList
                .stream()
                .filter(person -> person.getId().equals(personId))
                .findFirst()
                .orElse(null);

        // no UUID found
        if (targetPerson == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(targetPerson);
    }

    @DeleteMapping("/persons/{personId}")
    public ResponseEntity<Person> deletePerson(@PathVariable UUID personId) {
        personService.deletePerson(personId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        PersonSortingOptions option = null;
        List<Person> people = personService.getAllPersons(option);
        return ResponseEntity.ok(people); // 200 OK with list of persons in body
    }
}