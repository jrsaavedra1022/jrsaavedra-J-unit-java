package com.jrsaavedra.javatests.util;

import org.junit.Test;

import static com.jrsaavedra.javatests.util.PasswordUtil.*;
import static org.junit.Assert.*;

public class PasswordUtilTest {
    @Test
    public void weak_when_has_less_than_8_letters(){
        assertEquals(SecurityLevel.WEAK, accessPassword("1234567"));
    }

    @Test
    public void weak_when_has_only_letters(){
        assertEquals(SecurityLevel.WEAK, accessPassword("abcsdefghijklmn"));
    }

    @Test
    public void medium_when_has_letters_and_numbers(){
        assertEquals(SecurityLevel.MEDIUM, accessPassword("abcde1234"));
    }

    @Test
    public void strong_when_has_letters_and_numbers_and_symbols(){
        assertEquals(SecurityLevel.STRONG, accessPassword("abcd1234!"));
    }
}