package ch.bbzbl.m223_backend.service;

import ch.bbzbl.m223_backend.shared.dto.PersonDTO;
import ch.bbzbl.m223_backend.shared.helper.Validator;
import ch.bbzbl.m223_backend.shared.http.Response;
import ch.bbzbl.m223_backend.persistence.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService extends AbstractService{

    private PersonRepository personRepository;

    public PersonService(){
    }

    public Response<PersonDTO> getAll(){
        List<PersonDTO> resultList = new ArrayList<>();
        personRepository.findAll()
                .forEach(person -> resultList.add(super.map(person, PersonDTO.class)));
        return new Response<>(resultList);
    }

    public Response<PersonDTO> getPersonById(String id){
        List<PersonDTO> resultList = new ArrayList<>();
        if (Validator.validateID(id)){
            personRepository.findById(Long.parseLong(id))
                    .map(person -> resultList.add(super.map(person, PersonDTO.class)));
        }
        return new Response<>(resultList);
    }

    public Response<Boolean> deletePersonById(String id){
        if (Validator.validateID(id)){
            if (personRepository.deletePersonById(Long.parseLong(id)) == 1){
                return new Response<>(Boolean.TRUE);
            }else{
                return new Response<>("Person whith this ID does not exist!");
            }
        }else {
            return new Response<>("ID has to be a number!");
        }
    }

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
