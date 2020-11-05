package com.jrsaavedra.javatests.util;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class FizzBuzzTest {
    private FizzBuzz fizzBuzz;
    /*
    Si el número es divisible por 3, retorna “Fizz”
    Si el número es divisible por 5, retorna “Buzz”
    Si el número es divisible por 3 y por 5, retorna “FizzBuzz”*/
    @Before
    public void setUp(){
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void number_is_divisible_by_3(){
        Assert.assertThat(fizzBuzz.getDivisibleName(3), is("Fizz"));
        Assert.assertThat(fizzBuzz.getDivisibleName(6), is("Fizz"));
    }

    @Test
    public void number_is_divisible_by_5(){
        Assert.assertThat(fizzBuzz.getDivisibleName(5), is("Buzz"));
        Assert.assertThat(fizzBuzz.getDivisibleName(10), is("Buzz"));
    }

    @Test
    public void number_is_divisible_by_3_and_5(){
        Assert.assertThat(fizzBuzz.getDivisibleName(15), is("FizzBuzz"));
        Assert.assertThat(fizzBuzz.getDivisibleName(30), is("FizzBuzz"));
    }

    @Test
    public void number_is_not_divisible_by_3_or_5(){
        Assert.assertThat(fizzBuzz.getDivisibleName(2), is(String.valueOf(2)));
        Assert.assertThat(fizzBuzz.getDivisibleName(16), is(String.valueOf(16)));
    }
}