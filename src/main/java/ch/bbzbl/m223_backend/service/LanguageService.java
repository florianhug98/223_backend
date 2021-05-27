package ch.bbzbl.m223_backend.service;

import ch.bbzbl.m223_backend.persistence.entity.Language;
import ch.bbzbl.m223_backend.persistence.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        if (checkForValidId(id)){
            return languageRepository
                    .findById(Long.valueOf(id))
                    .orElse(null);
        }else{
            throw new IllegalArgumentException("ID must be a number!");
        }
    }

    public void addLanguage(Language language){
        if (checkForValidLanguageParameter(language)){
            languageRepository.save(language);
        }else {
            throw new IllegalArgumentException("Parameters may not be null/empty!");
        }
    }




    //helper

    public boolean deleteLanguageById(String id){
        return languageRepository.deleteLanguageById(Long.valueOf(id)) == 1;
    }

    private boolean checkForValidLanguageParameter (Language language){
        return language.getIsoCode() != null && !"".equals(language.getIsoCode())
                && language.getName() != null && !"".equals(language.getName());
    }

    private boolean checkForValidId(String id){
        String regex = "\\d+";
        return id.matches(regex);
    }

    @Autowired
    public void setLanguageRepository(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
}
