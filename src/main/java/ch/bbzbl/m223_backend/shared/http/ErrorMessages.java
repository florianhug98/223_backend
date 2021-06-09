package ch.bbzbl.m223_backend.shared.http;

public class ErrorMessages {

    private ErrorMessages () {}

    public static final String ID_INVALID = "ID must be a number";
    public static final String ENTITY_NOT_FOUND = "Entity with this ID has not been found";
    public static final String PARAMETER_INVALID = "Parameter must have correct format and not be null/empty!";

}
