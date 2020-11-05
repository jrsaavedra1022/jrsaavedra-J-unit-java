package com.jrsaavedra.javatests.util;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class RomanNumeralsTest {
    private RomanNumerals roman;
    /* función que convierta un número en el equivalente romano. */
    @Before
    public void setUp(){
        roman = new RomanNumerals();
    }

    @Test
    public void check_base_numbers(){
        Assert.assertThat(roman.arabicToRoman(1), is("I"));
        Assert.assertThat(roman.arabicToRoman(2), is("II"));
        Assert.assertThat(roman.arabicToRoman(3), is("III"));
        Assert.assertThat(roman.arabicToRoman(4), is("IV"));
        Assert.assertThat(roman.arabicToRoman(5), is("V"));
        Assert.assertThat(roman.arabicToRoman(6), is("VI"));
        Assert.assertThat(roman.arabicToRoman(7), is("VII"));
        Assert.assertThat(roman.arabicToRoman(8), is("VIII"));
        Assert.assertThat(roman.arabicToRoman(9), is("IX"));
        Assert.assertThat(roman.arabicToRoman(10), is("X"));
        Assert.assertThat(roman.arabicToRoman(50), is("L"));
        Assert.assertThat(roman.arabicToRoman(100), is("C"));
        Assert.assertThat(roman.arabicToRoman(1000), is("M"));
    }

    @Test
    public void check_random_numbers(){
        Assert.assertThat(roman.arabicToRoman(11), is("XI"));
        Assert.assertThat(roman.arabicToRoman(15), is("XV"));
        Assert.assertThat(roman.arabicToRoman(16), is("XVI"));
        Assert.assertThat(roman.arabicToRoman(51), is("LI"));
        Assert.assertThat(roman.arabicToRoman(55), is("LV"));
        Assert.assertThat(roman.arabicToRoman(56), is("LVI"));
        Assert.assertThat(roman.arabicToRoman(60), is("LX"));
        Assert.assertThat(roman.arabicToRoman(70), is("LXX"));
        Assert.assertThat(roman.arabicToRoman(80), is("LXXX"));
        Assert.assertThat(roman.arabicToRoman(81), is("LXXXI"));
        Assert.assertThat(roman.arabicToRoman(85), is("LXXXV"));
        Assert.assertThat(roman.arabicToRoman(86), is("LXXXVI"));
        Assert.assertThat(roman.arabicToRoman(126), is("CXXVI"));
        Assert.assertThat(roman.arabicToRoman(2507), is("MMDVII"));
    }

    @Test
    public void errorConvertNumber(){
        Assert.assertThat(roman.arabicToRoman(11000), is("Error cantidad"));
    }

}