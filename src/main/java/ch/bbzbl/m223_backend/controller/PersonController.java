package ch.bbzbl.m223_backend.controller;

import ch.bbzbl.m223_backend.shared.dto.PersonDTO;
import ch.bbzbl.m223_backend.shared.http.Response;
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
    public ResponseEntity<Response<PersonDTO>> getAll(){
        return ResponseEntity.ok(this.personService.getAll());
    }

    @GetMapping(value = "/getById/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<PersonDTO>> getById(@PathVariable String id){
        return ResponseEntity.ok(this.personService.getById(id));
    }

    @PostMapping(value = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<Boolean>> add(@RequestBody PersonDTO personDTO){
        return ResponseEntity.ok(this.personService.add(personDTO));
    }

    @PutMapping(value = "/edit",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<Boolean>> edit(@RequestBody PersonDTO personDTO){
        return ResponseEntity.ok(this.personService.edit(personDTO));
    }

    @DeleteMapping(value = "/delete/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<Boolean>> deleteById(@PathVariable String id){
        return ResponseEntity.ok(this.personService.deleteById(id));
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
