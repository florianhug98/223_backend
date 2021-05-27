package ch.bbzbl.m223_backend.controller;

import ch.bbzbl.m223_backend.persistence.entity.Language;
import ch.bbzbl.m223_backend.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/language")
public class LanguageController {

    private LanguageService languageService;

    @GetMapping(value = "/getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Language> getLaguangeById(@PathVariable String id){
        return ResponseEntity.ok(languageService.getLanguageByID(id));
    }

    @DeleteMapping(value = "deleteById/{id}")
    public ResponseEntity<Boolean> deleteLanguageById(@PathVariable String id){
        return ResponseEntity.ok(languageService.deleteLanguageById(id));
    }


    @Autowired
    public void setLanguageService(LanguageService languageService) {
        this.languageService = languageService;
    }
}
