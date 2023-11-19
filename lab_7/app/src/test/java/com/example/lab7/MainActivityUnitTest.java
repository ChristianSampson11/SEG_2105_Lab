package com.example.lab7;

import static com.example.lab7.MainActivity.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainActivityUnitTest {

    @Test
    public void ValidateFirstNameTest() {
        String goodFirstName = "John";
        boolean result = isValidName(goodFirstName);
        assertEquals(true, result);

        String badFirstName = "user123";
        boolean badResult = isValidName(badFirstName);
        assertEquals(false, badResult);
    }

    @Test
    public void ValidateLastNameTest() {
        String goodLastName = "Doe";
        boolean result = isValidName(goodLastName);
        assertEquals(true, result);

        String badLastName = "password123!";
        boolean badResult = isValidName(badLastName);
        assertEquals(false, badResult);
    }

    @Test
    public void ValidatePasswordTest() {
        String goodPassword = "password";
        boolean result = isValidPassword(goodPassword);
        assertEquals(true, result);

        String badPassword = "test";
        boolean badResult = isValidPassword(badPassword);
        assertEquals(false, badResult);
    }

    @Test
    public void validateEmailTest() {
        String goodEmail = "email@email.com";
        boolean result = isValidPassword(goodEmail);
        assertEquals(true, result);

        String badEmail = "\n";
        boolean badResult = isValidPassword(badEmail);
        assertEquals(false, badResult);
    }

}
