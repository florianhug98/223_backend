package ch.bbzbl.m223_backend.core;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Response<t> implements Serializable {

    private List<t> result;
    private String errorMessage;

    private Response(List<t> result, String errorMessage){
        this.result = result;
        this.errorMessage = errorMessage;
    }

    public Response(t result){
        this(Collections.singletonList(result), "");
    }

    public Response(List<t> result){
        this(result, "");
    }

    public Response (String errorMessage){
        this(null, errorMessage);
    }

    public List<t> getResult() {
        return result;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
