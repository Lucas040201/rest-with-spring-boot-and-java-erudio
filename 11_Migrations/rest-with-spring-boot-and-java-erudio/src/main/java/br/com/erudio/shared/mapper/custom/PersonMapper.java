package br.com.erudio.shared.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;
import br.com.erudio.shared.data.vo.v2.PersonVOV2;

@Service
public class PersonMapper {
    public PersonVOV2 convertEntityToVo(Person person) {
        PersonVOV2 personVoV2 = new PersonVOV2();
        personVoV2.setId(person.getId());
        personVoV2.setAddress(person.getAddress());
        personVoV2.setFirstName(person.getFirstName());
        personVoV2.setLastName(person.getLastName());
        personVoV2.setGender(person.getGender());
        personVoV2.setBirthDate(new Date());

        return personVoV2;
    }

    public Person convertVoToEntity(PersonVOV2 personVoV2) {
        Person person = new Person();
        person.setId(personVoV2.getId());
        person.setAddress(personVoV2.getAddress());
        person.setFirstName(personVoV2.getFirstName());
        person.setLastName(personVoV2.getLastName());
        person.setGender(personVoV2.getGender());
        // person.setBirthDate(new Date());

        return person;
    }
}
