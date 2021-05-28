package ch.bbzbl.m223_backend.service;

import ch.bbzbl.m223_backend.core.http.Response;
import ch.bbzbl.m223_backend.core.dto.LanguageDTO;
import ch.bbzbl.m223_backend.persistence.entity.Language;
import ch.bbzbl.m223_backend.persistence.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageService extends AbstractService{

    private LanguageRepository languageRepository;

    public LanguageService(){
    }

    public Response<LanguageDTO> getAllLanguages(){
        List<LanguageDTO> resultList = new ArrayList<>();
        languageRepository.findAll().forEach(language -> {
            resultList.add(super.map(language, LanguageDTO.class));
        });
        return new Response<>(resultList);
    }

    public Response<LanguageDTO> getLanguageByID(String id){
        List<LanguageDTO> resultList = new ArrayList<>();
        if (super.validateId(id)){
            languageRepository.findById(Long.parseLong(id))
                    .map(language -> resultList.add(super.map(language, LanguageDTO.class)));
        }
        return new Response<>(resultList);
    }

    public Response<Boolean> addLanguage(LanguageDTO languageDTO){
        if (validateLanguageParameter(languageDTO)){
            languageRepository.save(super.map(languageDTO, Language.class));
            return new Response<>(Boolean.TRUE);
        }else {
            return new Response<>("Parameter must have correct format and not be null/empty!");
        }
    }

    public Response<Boolean> updateLanguageById(LanguageDTO languageDTO){
        if (!this.getLanguageByID(String.valueOf(languageDTO.getId())).getResult().isEmpty()){
            languageRepository.save(super.map(languageDTO, Language.class));
            return new Response<>(Boolean.TRUE);
        }
        return new Response<>("Entity whith this ID not found!");
    }

    public Response<Boolean> deleteLanguageById(String id){
        if (super.validateId(id)){
            if (languageRepository.deleteLanguageById(Long.parseLong(id)) == 1){
                return new Response<>(Boolean.TRUE);
            }else{
                return new Response<>("Language with this ID does not exist!");
            }
        }
        return new Response<>("ID has to be a number!");
    }



    //helper

    private boolean validateLanguageParameter(LanguageDTO languageDTO){
        return languageDTO.getIsoCode() != null && !"".equals(languageDTO.getIsoCode()) && languageDTO.getIsoCode().length() <= 3
                && languageDTO.getName() != null && !"".equals(languageDTO.getName());
    }

    @Autowired
    public void setLanguageRepository(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
}
