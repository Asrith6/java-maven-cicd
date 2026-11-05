package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void applicationReturnsCorrectMessage() {
        assertEquals(
                "Hello! Maven CI/CD Pipeline",
                App.RESPONSE_MESSAGE
        );
    }

    @Test
    void applicationUsesPort8081() {
        assertEquals(8081, App.PORT);
    }
}
