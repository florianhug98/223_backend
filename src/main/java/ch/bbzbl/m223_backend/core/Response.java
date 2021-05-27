package ch.bbzbl.m223_backend.core;

import java.util.List;

public class Response<t> {

    private List<t> result;
    private String errorMessage;

    private Response(List<t> result, String errorMessage){
        this.result = result;
        this.errorMessage = errorMessage;
    }

    public Response(List<t> result){
        this(result, "");
    }

    public Response (String errorMessage){
        this(null, errorMessage);
    }

    public List<t> getResult () {
        return result;
    }

    public String getErrorMessage () {
        return errorMessage;
    }
}
