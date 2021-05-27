package ch.bbzbl.m223_backend.service;

import ch.bbzbl.m223_backend.core.Response;
import ch.bbzbl.m223_backend.core.dto.LanguageDTO;
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

    public Response<LanguageDTO> getAllLanguages(){
        List<LanguageDTO> resultList = new ArrayList<>();
        languageRepository.findAll().forEach(language -> {
            resultList.add(createDTO(language));
        });
        return new Response<>(resultList);
    }

    public Response<LanguageDTO> getLanguageByID(String id){
        List<LanguageDTO> resultList = new ArrayList<>();
        if (checkForValidId(id)){
            Language language = languageRepository.getById(Long.valueOf(id));
            resultList.add(createDTO(language));
        }
        return new Response<>(resultList);
    }

    public Response<Boolean> addLanguage(Language language){
        if (validateLanguageParameter(language)){
            languageRepository.save(language);
            return new Response<>(Boolean.TRUE);
        }else {
            return new Response<>("Parameter must have correct format and not be null/empty!");
        }
    }

    public Response<Boolean> deleteLanguageById(String id){
        if (checkForValidId(id)){
            if (languageRepository.deleteLanguageById(Long.valueOf(id)) == 1){
                return new Response<>(Boolean.TRUE);
            }else{
                return new Response<>("Language with this ID does not exist!");
            }
        }
        return new Response<>("ID has to be a number!");
    }



    //helper

    private LanguageDTO createDTO(Language language){
        return new LanguageDTO(
                language.getId(),
                language.getName(),
                language.getIsoCode()
        );
    }

    private boolean validateLanguageParameter(Language language){
        return language.getIsoCode() != null && !"".equals(language.getIsoCode()) && language.getIsoCode().length() <= 3
                && language.getName() != null && !"".equals(language.getName());
    }

    private boolean checkForValidId(String id){
        String regex = "\\d+";
        return id != null
                && !"".equals(id)
                && id.matches(regex);
    }

    @Autowired
    public void setLanguageRepository(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
}
