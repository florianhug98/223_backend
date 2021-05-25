package ch.bbzbl.m223_backend.persistence.repository;

import ch.bbzbl.m223_backend.persistence.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
