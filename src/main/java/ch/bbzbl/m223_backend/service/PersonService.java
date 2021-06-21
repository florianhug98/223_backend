package ch.bbzbl.m223_backend.service;

import ch.bbzbl.m223_backend.persistence.entity.Language;
import ch.bbzbl.m223_backend.persistence.entity.Person;
import ch.bbzbl.m223_backend.shared.dto.LanguageDTO;
import ch.bbzbl.m223_backend.shared.dto.PersonDTO;
import ch.bbzbl.m223_backend.shared.helper.Validator;
import ch.bbzbl.m223_backend.shared.http.ErrorMessages;
import ch.bbzbl.m223_backend.shared.http.Response;
import ch.bbzbl.m223_backend.persistence.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
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
        this.personRepository.findAll()
                .forEach(person -> resultList.add(super.map(person, PersonDTO.class)));
        return new Response<>(resultList);
    }

    public Response<PersonDTO> getById (String id){
        List<PersonDTO> resultList = new ArrayList<>();
        if (Validator.validateID(id)){
            this.personRepository.findById(Long.parseLong(id))
                    .map(person -> resultList.add(super.map(person, PersonDTO.class)));
        }
        return new Response<>(resultList);
    }

    public Response<Boolean> delete (String id){
        if (Validator.validateID(id)){
            if (this.personRepository.deletePersonById(Long.parseLong(id)) == 1){
                return new Response<>(Boolean.TRUE);
            }else{
                return new Response<>(ErrorMessages.ENTITY_NOT_FOUND);
            }
        }else {
            return new Response<>(ErrorMessages.ID_INVALID);
        }
    }

    public Response<Boolean> edit (PersonDTO personDTO){
        if (!this.getById(String.valueOf(personDTO.getId())).getResult().isEmpty()){
            if (validatePersonParameter(personDTO)){
                try{
                    this.personRepository.save(super.map(personDTO, Person.class));
                    return new Response<>(Boolean.TRUE);
                }catch (ObjectOptimisticLockingFailureException e){
                    return new Response<>(ErrorMessages.OLD_VERSION_USED);
                }
            }else {
                return new Response<>(ErrorMessages.PARAMETER_INVALID);
            }
        }
        return new Response<>(ErrorMessages.ENTITY_NOT_FOUND);
    }

    public Response<Boolean> add(PersonDTO personDTO){
        if (validatePersonParameter(personDTO)){
            this.personRepository.save(super.map(personDTO, Person.class));
            return new Response<>(Boolean.TRUE);
        }else {
            return new Response<>(ErrorMessages.PARAMETER_INVALID);
        }
    }

    //helper

    private boolean validatePersonParameter (PersonDTO p){
        return p.getName() != null && !"".equals(p.getName()) && p.getName().length() <= 30
                && p.getSurname() != null && !"".equals(p.getSurname()) && p.getSurname().length() <= 20
                && p.getLanguages() != null
                && p.getNotice() != null;
    }

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
