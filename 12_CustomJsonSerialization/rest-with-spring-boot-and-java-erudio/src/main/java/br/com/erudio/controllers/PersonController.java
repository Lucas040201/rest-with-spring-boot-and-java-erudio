package br.com.erudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.shared.data.vo.v1.PersonVO;
import br.com.erudio.shared.data.vo.v2.PersonVOV2;
import br.com.erudio.shared.services.PersonService;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping(
		value = "/{id}",
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public PersonVO findById(@PathVariable(value = "id") Long id) {
		return this.personService.findById(id);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonVO> findAll() {
		return this.personService.findAll();
	}

	@PostMapping(
		produces = MediaType.APPLICATION_JSON_VALUE,
		consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public PersonVO create(@RequestBody PersonVO person) {
		return this.personService.create(person);
	}

	@PostMapping(
		value = "/v2",
		produces = MediaType.APPLICATION_JSON_VALUE,
		consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
		return this.personService.createV2(person);
	}

	@PutMapping(
		produces = MediaType.APPLICATION_JSON_VALUE,
		consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public PersonVO update(@RequestBody PersonVO person) {
		return this.personService.update(person);
	}

	@DeleteMapping(
		value = "/{id}",
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		this.personService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
