package ch.bbzbl.m223_backend.persistence.repository;

import ch.bbzbl.m223_backend.persistence.entity.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {

    @Override
    Optional<Language> findById (Long aLong);

    @Override
    <S extends Language> S save (S s);
}
