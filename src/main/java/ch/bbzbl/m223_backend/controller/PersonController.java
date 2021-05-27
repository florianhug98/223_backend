package ch.bbzbl.m223_backend.controller;

import ch.bbzbl.m223_backend.persistence.entity.Person;
import ch.bbzbl.m223_backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller()
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Person>> getAllPersons(){

        //todo: implement
        return null;
    }

    @GetMapping(value = "/getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> getPersonById(@PathVariable String id){
        return ResponseEntity.ok(personService.getPersonById(id));
    }

    @PostMapping(value = "/addPerson", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> addPerson(@RequestBody Person person){

        //todo: implement
        return null;
    }

    @PostMapping(value = "/editPerson", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> editPerson(@RequestBody Person person){

        //todo:implement
        return null;
    }

    @DeleteMapping("/deletePersonById/{id}")
    public ResponseEntity<Boolean> deletePersonById(@PathVariable String id){

        //todo: implement
        return null;
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
