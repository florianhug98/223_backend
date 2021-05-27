package ch.bbzbl.m223_backend.service;

import ch.bbzbl.m223_backend.persistence.entity.Language;
import ch.bbzbl.m223_backend.persistence.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LanguageService {

    private LanguageRepository languageRepository;

    public LanguageService(){

    }

    public Language getLanguageByID(String id){
        return languageRepository
                .findById(Long.valueOf(id))
                .orElse(null);
    }

    public boolean deleteLanguageById(String id){
        return languageRepository.deleteLanguageById(Long.valueOf(id)) == 1;
    }

    @Autowired
    public void setLanguageRepository(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
}
