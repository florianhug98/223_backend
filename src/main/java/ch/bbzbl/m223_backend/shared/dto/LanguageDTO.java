package ch.bbzbl.m223_backend.shared.dto;

public class LanguageDTO {

    private long id;
    private String name;
    private String isoCode;
    private long version;

    public LanguageDTO(){
    }

    public LanguageDTO(long id, String name, String isoCode) {
        this.id = id;
        this.name = name;
        this.isoCode = isoCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public long getVersion () {

        return version;
    }

    public void setVersion (long version) {
        this.version = version;
    }
}
