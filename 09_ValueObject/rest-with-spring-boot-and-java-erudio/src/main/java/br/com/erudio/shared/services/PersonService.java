package br.com.erudio.shared.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;
import br.com.erudio.shared.data.vo.v1.PersonVO;
import br.com.erudio.shared.exceptions.ResourceNotFoundException;
import br.com.erudio.shared.mapper.DozerMapper;
import br.com.erudio.shared.repositories.PersonRepository;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository personRepository;

    public List<PersonVO> findAll() {

        this.logger.info("Finding all people!");

        return DozerMapper.parseListObjects(this.personRepository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {

        this.logger.info("Finding one Person!");

        Person person = this.personRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));


        return DozerMapper.parseObject(person, PersonVO.class); 
    }



    public PersonVO create(PersonVO person) {
        logger.info("creating one person!");
        Person entity = DozerMapper.parseObject(person, Person.class);
        PersonVO personVO = DozerMapper.parseObject(this.personRepository.save(entity), PersonVO.class);
        return personVO;
    }

    public PersonVO update(PersonVO person) {
        logger.info("Updating one person!");

        Person entity = this.personRepository.findById(person.getId())
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());

        PersonVO personVO = DozerMapper.parseObject(this.personRepository.save(entity), PersonVO.class);
        return personVO;
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");

        Person entity = this.personRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        
        this.personRepository.delete(entity);
    }
}
