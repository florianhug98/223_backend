package ch.bbzbl.m223_backend.controller;

import ch.bbzbl.m223_backend.persistence.entity.Language;
import ch.bbzbl.m223_backend.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/language")
public class LanguageController {

    private LanguageService languageService;

    @GetMapping(value = "/getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Language>> getLaguangeById(@PathVariable String id){
        return ResponseEntity.ok(languageService.getLanguageByID(id));
    }

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Language>> getAllLanguages(){
        return ResponseEntity.ok(languageService.getAllLanguages());
    }

//    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Boolean> addLanguage(@RequestBody Language language){
//
//    }

    @DeleteMapping(value = "deleteById/{id}")
    public ResponseEntity<Boolean> deleteLanguageById(@PathVariable String id){
        return ResponseEntity.ok(languageService.deleteLanguageById(id));
    }

    @Autowired
    public void setLanguageService(LanguageService languageService) {
        this.languageService = languageService;
    }
}
