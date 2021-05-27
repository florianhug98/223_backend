package ch.bbzbl.m223_backend.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tbl_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String surname;
    private String name;
    private String notice;

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
}
