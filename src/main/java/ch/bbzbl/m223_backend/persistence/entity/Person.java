package ch.bbzbl.m223_backend.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "tbl_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String surname;
    private String name;
    private String notice;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_person_language",
            joinColumns = @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "person_fk")),
            inverseJoinColumns = @JoinColumn(name = "language_id", foreignKey = @ForeignKey(name = "language_fk"))
    )
    private List<Language> languages;

    @Version
    private Long version;

    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public java.lang.String getSurname () {
        return surname;
    }

    public void setSurname (java.lang.String surname) {
        this.surname = surname;
    }

    public java.lang.String getName () {
        return name;
    }

    public void setName (java.lang.String name) {
        this.name = name;
    }

    public String getNotice () {
        return this.notice;
    }

    public void setString (String notice) {
        this.notice = notice;
    }

    public void setNotice (String notice) {
        this.notice = notice;
    }

    public List<Language> getLanguages () {
        return languages;
    }

    public void setLanguages (List<Language> languages) {
        this.languages = languages;
    }

    public Long getVersion () {
        return version;
    }

    public void setVersion (Long version) {
        this.version = version;
    }
}
