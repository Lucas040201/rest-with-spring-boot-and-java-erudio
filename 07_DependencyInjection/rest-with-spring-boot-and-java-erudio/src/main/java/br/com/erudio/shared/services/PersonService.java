package br.com.erudio.shared.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());


    public List<Person> findAll() {

        this.logger.info("Finding all people!");

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Person person = this.mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    public Person findById(String id) {

        this.logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Lucas");
        person.setLastName("Mendes");
        person.setGender("Male");
        person.setAddress("Pontezinha");
        return person;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person Name " + i);
        person.setLastName("Last Name " + i);
        person.setGender("Male ");
        person.setAddress("Pontezinha " + i);
        return person;
    }

    public Person create(Person person) {
        logger.info("creating one person!");
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating one person!");
        return person;
    }

    public void delete(String id) {
        logger.info("Deleting one person!");
    }
}
