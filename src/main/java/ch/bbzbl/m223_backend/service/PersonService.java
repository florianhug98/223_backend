package ch.bbzbl.m223_backend.service;

import ch.bbzbl.m223_backend.persistence.entity.Person;
import ch.bbzbl.m223_backend.persistence.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(){
    }

    public Person getPersonById(String id){
        return personRepository
                .findById(Long.valueOf(id))
                .orElse(null);
    }

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
