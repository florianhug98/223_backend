package ch.bbzbl.m223_backend.persistence.repository;

import ch.bbzbl.m223_backend.persistence.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM tbl_language l WHERE l.id = :id")
    int deleteLanguageById(@Param("id") Long id);
}
