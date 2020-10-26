package com.jrsaavedra.javatests.util;


public class StringUtilTest {
    public static void main(String[] args) {
        
        assertEquals(StringUtil.repeat("hola", 3), "holaholahola");
        assertEquals(StringUtil.repeat("hola", 1), "hola");
    }

    private static void assertEquals(String resultCurrent, String resultExpected) {
        if(!resultCurrent.equals(resultExpected)){
            throw new RuntimeException(resultCurrent + " is not equals to expected " + resultExpected);
        }
    }
}