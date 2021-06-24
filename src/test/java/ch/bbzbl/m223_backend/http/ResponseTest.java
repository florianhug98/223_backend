package ch.bbzbl.m223_backend.http;

import ch.bbzbl.m223_backend.shared.http.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ResponseTest {

    @Test
    public void init_ErrorString() {
        Response<Object> respose = new Response<>("Test String");

        assertTrue(respose.getResult().isEmpty());
        assertEquals("Test String", respose.getErrorMessage());
    }

    @Test
    public void init_singleResult() {
        Response<Object> respose = new Response<>(new Object());

        assertEquals(1, respose.getResult().size());
        assertEquals("", respose.getErrorMessage());
    }

    @Test
    public void init_multipleResults() {
        List<Object> list = new ArrayList<>();
        list.add(new Object());
        list.add(new Object());

        Response<Object> respose = new Response<>(list);

        assertEquals(2, respose.getResult().size());
        assertEquals("", respose.getErrorMessage());
    }
}
