package ch.bbzbl.m223_backend.service;

import ch.bbzbl.m223_backend.core.Helper;
import ch.bbzbl.m223_backend.core.http.Response;
import ch.bbzbl.m223_backend.core.dto.LanguageDTO;
import ch.bbzbl.m223_backend.persistence.entity.Language;
import ch.bbzbl.m223_backend.persistence.repository.LanguageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageService {

    private LanguageRepository languageRepository;
    private final ModelMapper mapper = new ModelMapper();

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
        if (Helper.validateID(id)){
            languageRepository.findById(Long.valueOf(id))
                    .map(language -> resultList.add(createDTO(language)));
        }
        return new Response<>(resultList);
    }

    public Response<Boolean> addLanguage(LanguageDTO languageDTO){
        if (validateLanguageParameter(languageDTO)){
            languageRepository.save(createEntity(languageDTO));
            return new Response<>(Boolean.TRUE);
        }else {
            return new Response<>("Parameter must have correct format and not be null/empty!");
        }
    }

    public Response<Boolean> updateLanguageById(LanguageDTO language){
        if (!this.getLanguageByID(String.valueOf(language.getId())).getResult().isEmpty()){
            languageRepository.save(createEntity(language));
            return new Response<>(Boolean.TRUE);
        }
        return new Response<>("Entity whith this ID not found!");
    }

    public Response<Boolean> deleteLanguageById(String id){
        if (Helper.validateID(id)){
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
        return mapper.map(language, LanguageDTO.class);
    }

    private Language createEntity(LanguageDTO languageDTO){
        return mapper.map(languageDTO, Language.class);
    }

    private boolean validateLanguageParameter(LanguageDTO languageDTO){
        return languageDTO.getIsoCode() != null && !"".equals(languageDTO.getIsoCode()) && languageDTO.getIsoCode().length() <= 3
                && languageDTO.getName() != null && !"".equals(languageDTO.getName());
    }

    @Autowired
    public void setLanguageRepository(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
}
