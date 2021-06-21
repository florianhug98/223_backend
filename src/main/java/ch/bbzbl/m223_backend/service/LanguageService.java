package ch.bbzbl.m223_backend.service;

import ch.bbzbl.m223_backend.shared.helper.Validator;
import ch.bbzbl.m223_backend.shared.http.ErrorMessages;
import ch.bbzbl.m223_backend.shared.http.Response;
import ch.bbzbl.m223_backend.shared.dto.LanguageDTO;
import ch.bbzbl.m223_backend.persistence.entity.Language;
import ch.bbzbl.m223_backend.persistence.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageService extends AbstractService{

    private LanguageRepository languageRepository;

    public LanguageService(){
    }

    public Response<LanguageDTO> getAll (){
        List<LanguageDTO> resultList = new ArrayList<>();
        this.languageRepository.findAll().forEach(language -> {
            resultList.add(super.map(language, LanguageDTO.class));
        });
        return new Response<>(resultList);
    }

    public Response<LanguageDTO> getById (String id){
        List<LanguageDTO> resultList = new ArrayList<>();
        if (Validator.validateID(id)){
            this.languageRepository.findById(Long.parseLong(id))
                    .map(language -> resultList.add(super.map(language, LanguageDTO.class)));
        }
        return new Response<>(resultList);
    }

    public Response<Boolean> add (LanguageDTO languageDTO){
        if (validateLanguageParameter(languageDTO)){
            this.languageRepository.save(super.map(languageDTO, Language.class));
            return new Response<>(Boolean.TRUE);
        }else {
            return new Response<>(ErrorMessages.PARAMETER_INVALID);
        }
    }

    public Response<Boolean> edit (LanguageDTO languageDTO){
        if (!this.getById(String.valueOf(languageDTO.getId())).getResult().isEmpty()){
            if (validateLanguageParameter(languageDTO)){
                try{
                    this.languageRepository.save(super.map(languageDTO, Language.class));
                    return new Response<>(Boolean.TRUE);
                }catch (ObjectOptimisticLockingFailureException e){
                    return new Response<>(ErrorMessages.OLD_VERSION_USED);
                }
            }else {
             return new Response<>(ErrorMessages.PARAMETER_INVALID);
            }
        }
        return new Response<>(ErrorMessages.ENTITY_NOT_FOUND);
    }

    public Response<Boolean> delete (String id){
        if (Validator.validateID(id)){
            if (this.languageRepository.deleteLanguageById(Long.parseLong(id)) == 1){
                return new Response<>(Boolean.TRUE);
            }else{
                return new Response<>(ErrorMessages.ENTITY_NOT_FOUND);
            }
        }
        return new Response<>(ErrorMessages.ID_INVALID);
    }

    //helper

    private boolean validateLanguageParameter(LanguageDTO languageDTO){
        return languageDTO.getIsoCode() != null && languageDTO.getIsoCode().length() >= 2 && languageDTO.getIsoCode().length() <= 3
               && languageDTO.getName() != null && !"".equals(languageDTO.getName());
    }

    @Autowired
    public void setLanguageRepository(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
}
