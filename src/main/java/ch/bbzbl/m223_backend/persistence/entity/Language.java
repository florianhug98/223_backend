package ch.bbzbl.m223_backend.persistence.entity;

import javax.persistence.*;

@Entity(name = "tbl_language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @Column(name = "iso_code")
    private String isoCode;

    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getIsoCode () {
        return isoCode;
    }

    public void setIsoCode (String isoCode) {
        this.isoCode = isoCode;
    }
}
