package com.jrsaavedra.javatests.util;


import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {
    @Test
    public void testRepeat() {
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola", 3));
        Assert.assertEquals("hola", StringUtil.repeat("hola", 1));
    }

    @Test
    public void not_is_empty(){
        Assert.assertFalse(StringUtil.isEmpty("message"));
    }

    @Test
    public void is_empty(){
        Assert.assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void null_is_empty(){
        Assert.assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    public void trim_is_empty(){
        Assert.assertTrue(StringUtil.isEmpty(" "));
    }


}