package com.example.demo.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.method.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class PasswordUtilsTest {

    private static final String PASSWORD = "123456";
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Test
    public void testPasswordNull() throws Exception {
        assertNull(PasswordUtils.createBCrYpt(null));
    }

    @Test
    public void testGenerationPasswordHash() throws Exception {
        String hash = PasswordUtils.createBCrYpt(PASSWORD);

        assertTrue(bCryptPasswordEncoder.matches(PASSWORD, hash));
    }
}
