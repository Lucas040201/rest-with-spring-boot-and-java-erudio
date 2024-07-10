package br.com.erudio.shared.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;
import br.com.erudio.shared.exceptions.ResourceNotFoundException;
import br.com.erudio.shared.repositories.PersonRepository;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository personRepository;

    public List<Person> findAll() {

        this.logger.info("Finding all people!");

        return this.personRepository.findAll();
    }

    public Person findById(Long id) {

        this.logger.info("Finding one Person!");

        return this.personRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }



    public Person create(Person person) {
        logger.info("creating one person!");
        return this.personRepository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating one person!");

        Person entity = this.personRepository.findById(person.getId())
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());


        return this.personRepository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");

        Person entity = this.personRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        
        this.personRepository.delete(entity);
    }
}
