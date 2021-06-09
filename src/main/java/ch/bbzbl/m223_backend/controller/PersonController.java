package ch.bbzbl.m223_backend.controller;

import ch.bbzbl.m223_backend.shared.dto.PersonDTO;
import ch.bbzbl.m223_backend.shared.http.Response;
import ch.bbzbl.m223_backend.persistence.entity.Person;
import ch.bbzbl.m223_backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
@CrossOrigin(origins = "*")
public class PersonController {

    private PersonService personService;

    @GetMapping(value = "/getAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<PersonDTO>> getAllPersons(){
        return ResponseEntity.ok(personService.getAll());
    }

    @GetMapping(value = "/getById/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<PersonDTO>> getPersonById(@PathVariable String id){
        return ResponseEntity.ok(personService.getPersonById(id));
    }

    @PostMapping(value = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> addPerson(@RequestBody Person person){

        //todo: implement
        return null;
    }

    @PutMapping(value = "/edit",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> editPerson(@RequestBody Person person){

        //todo:implement
        return null;
    }

    @DeleteMapping(value = "/delete/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<Boolean>> deletePersonById(@PathVariable String id){
        return ResponseEntity.ok(personService.deletePersonById(id));
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
