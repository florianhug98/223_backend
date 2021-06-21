package ch.bbzbl.m223_backend.helper;

import ch.bbzbl.m223_backend.shared.helper.Validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {

    @Test
    public void validate_valid() {
        assertTrue(Validator.validateID("1254"));
    }

    @Test
    public void validate_invalid() {
        assertFalse(Validator.validateID("fer"));
    }
}
