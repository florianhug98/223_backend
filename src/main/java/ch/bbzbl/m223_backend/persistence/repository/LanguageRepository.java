package ch.bbzbl.m223_backend.persistence.repository;

import ch.bbzbl.m223_backend.persistence.entity.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {

}
