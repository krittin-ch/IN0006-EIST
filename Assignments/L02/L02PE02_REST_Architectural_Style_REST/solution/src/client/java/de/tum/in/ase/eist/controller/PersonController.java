package de.tum.in.ase.eist.controller;

import de.tum.in.ase.eist.model.Person;
import de.tum.in.ase.eist.util.PersonSortingOptions;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;
import java.util.function.Consumer;

public class PersonController {

    public void addPerson(Person person, Consumer<List<Person>> personsConsumer) {
        // TODO Part 2: Make an http post request to the server
        String url = "http://localhost:8080/persons";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Person> response1 = restTemplate.postForEntity(url, person, Person.class);

        if (response1.getStatusCode().is2xxSuccessful()) {
            ResponseEntity<Person[]> response2 = restTemplate.getForEntity(url, Person[].class);

            if (response2.getStatusCode().is2xxSuccessful() && response2 != null) {
                List<Person> personList = Arrays.asList(response2.getBody());
                /*
                or
                Person[] personArr = response2.getBody();           // fixed-size array
                List<Person> personList = Arrays.asList(personArr); // dynamic-size array
                 */
                personsConsumer.accept(personList);
            } else {
                throw new RuntimeException("Failed to add person: " + response2.getStatusCode());
            }
        } else {
            throw new RuntimeException("Failed to add person: " + response1.getStatusCode());

        }
    }

    public void updatePerson(Person person, Consumer<List<Person>> personsConsumer) {
        // TODO Part 2: Make an http put request to the server
        UUID personId = person.getId();

        String url = String.format("http://localhost:8080/persons/%s", personId);
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.put(url, personId); // update new person

        // ResponseEntity<Person[]> response = restTemplate.getForEntity("http://localhost:8080/persons", Person[].class); // call person list
        // if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
        //     List<Person> personList = Arrays.asList(response.getBody());
        //     personsConsumer.accept(personList);
        // } else {
        //     throw new RuntimeException("Failed to fetch updated person list");
        // }

    }

    public void deletePerson(Person person, Consumer<List<Person>> personsConsumer) {
        // TODO Part 2: Make an http delete request to the server
    }

    public void getAllPersons(PersonSortingOptions sortingOptions, Consumer<List<Person>> personsConsumer) {
        // TODO Part 2: Make an https get request to the server
    }
}