package ch.bbzbl.m223_backend.persistence.repository;

import ch.bbzbl.m223_backend.persistence.entity.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM tbl_person p WHERE p.id = :id")
    int deletePersonById(@Param("id") long id);
}
