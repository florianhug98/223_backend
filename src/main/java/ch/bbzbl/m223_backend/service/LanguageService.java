package ch.bbzbl.m223_backend.service;

import ch.bbzbl.m223_backend.persistence.entity.Language;
import ch.bbzbl.m223_backend.persistence.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {

    private LanguageRepository languageRepository;

    public LanguageService(){

    }

    public List<Language> getAllLanguages(){
        List<Language> languages = new ArrayList<>();
        languageRepository.findAll()
                .forEach(languages::add);
        return languages;
    }

    public Language getLanguageByID(String id){
        return languageRepository
                .findById(Long.valueOf(id))
                .orElse(null);
    }

    public void addLanguage(Language language){
        if (checkForValidAttributes(language)){
            languageRepository.save(language);
        }else {
            throw new IllegalArgumentException("Parameters may not be null");
        }
    }

    public boolean deleteLanguageById(String id){
        return languageRepository.deleteLanguageById(Long.valueOf(id)) == 1;
    }

    private boolean checkForValidAttributes(Language language){
        return language.getIsoCode() != null
                && language.getName() != null;
    }

    @Autowired
    public void setLanguageRepository(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
}
