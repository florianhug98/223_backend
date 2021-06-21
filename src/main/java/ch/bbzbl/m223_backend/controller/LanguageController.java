package ch.bbzbl.m223_backend.controller;

import ch.bbzbl.m223_backend.shared.http.Response;
import ch.bbzbl.m223_backend.shared.dto.LanguageDTO;
import ch.bbzbl.m223_backend.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/language")
@CrossOrigin(origins = "*")
public class LanguageController {

    private LanguageService languageService;

    @GetMapping(value = "/getById/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<LanguageDTO>> getLanguageById(@PathVariable String id){
        return ResponseEntity.ok(this.languageService.getById(id));
    }

    @GetMapping(value = "/getAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<LanguageDTO>> getAllLanguages(){
        return ResponseEntity.ok(this.languageService.getAll());
    }

    @PostMapping(value = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<Boolean>> addLanguage(@RequestBody LanguageDTO languageDTO){
        return ResponseEntity.ok(this.languageService.add(languageDTO));
    }

    @PutMapping(value = "/edit",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<Boolean>> updateLanguage(@RequestBody LanguageDTO languageDTO){
        return ResponseEntity.ok(this.languageService.edit(languageDTO));
    }

    @DeleteMapping(value = "/delete/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response<Boolean>> deleteLanguageById(@PathVariable String id){
        return ResponseEntity.ok(this.languageService.delete(id));
    }

    @Autowired
    public void setLanguageService(LanguageService languageService) {
        this.languageService = languageService;
    }
}
