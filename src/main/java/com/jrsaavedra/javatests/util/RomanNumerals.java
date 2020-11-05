package com.jrsaavedra.javatests.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanNumerals {
    private static List<String> startRomanNumbers = new ArrayList<String>();
    private static List<String> middleRomanNumbers = new ArrayList<String>();

    public RomanNumerals(){
        // números menores a 3 en tipificación de longitud
        startRomanNumbers.add("I"); // unidad
        startRomanNumbers.add("X"); // decena
        startRomanNumbers.add("C"); // centena
        startRomanNumbers.add("M"); // miles
        // números de 5 en longitud
        middleRomanNumbers.add("V"); // unidad
        middleRomanNumbers.add("L"); // decena
        middleRomanNumbers.add("D"); // centena
        middleRomanNumbers.add("V+"); // miles
    }

    public static String repeatCharacterNTimes(String character, int times){
        String newCharacter = "";
        for (int i = 0; i < times; i++) {
            newCharacter+=character;
        }
        return newCharacter;
    }

    public static String getNumber(int number, int position){
        if(number <= 3 && number > 0){
            return repeatCharacterNTimes(startRomanNumbers.get(position), number);
        }
        if(number == 4){
            return startRomanNumbers.get(position) + middleRomanNumbers.get(position);
        }
        if(number == 5){
            return middleRomanNumbers.get(position);
        }
        if(number <= 8 && number > 0){
            int numberLessThanFive = number - 5;
            return middleRomanNumbers.get(position) + repeatCharacterNTimes(startRomanNumbers.get(position), numberLessThanFive);
        }
        if(number == 9){
            return startRomanNumbers.get(position) + startRomanNumbers.get(position+1);
        }

        return "";
    }
    public static String arabicToRoman(int number) {
        String[] parts = String.valueOf(number).split("");
        if(number >= 10000 || number < 0){
            return "Error cantidad";
        }
        String romanNumber = "";
        int counter = (parts.length-1);
        for (int i = 0; i < parts.length; i++) {
            int num = Integer.parseInt(parts[i]);
            romanNumber += getNumber(num, counter);
            counter--;
        }
        return romanNumber;
    }
}
