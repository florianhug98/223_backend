package ch.bbzbl.m223_backend.shared.dto;

import java.util.List;

public class PersonDTO {

    private long id;
    private String surname;
    private String name;
    private String notice;
    private List<LanguageDTO> languages;
    private long version;

    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public String getSurname () {
        return surname;
    }

    public void setSurname (String surname) {
        this.surname = surname;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getNotice () {
        return notice;
    }

    public void setNotice (String notice) {
        this.notice = notice;
    }

    public List<LanguageDTO> getLanguages () {
        return languages;
    }

    public void setLanguages (List<LanguageDTO> languages) {
        this.languages = languages;
    }

    public long getVersion () {
        return version;
    }

    public void setVersion (long version) {
        this.version = version;
    }
}
