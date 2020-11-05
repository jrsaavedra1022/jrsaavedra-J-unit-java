package com.jrsaavedra.javatests.player;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void looses_when_dice_number_is_too_low(){
        //clase simulada
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(2);
        // play
        Player player = new Player(dice , 3);
        assertEquals(false, player.play());
    }

    @Test
    public void wins_when_dice_number_is_too_big(){
        //clase simulada
        Dice dice = Mockito.mock(Dice.class);
        Mockito.when(dice.roll()).thenReturn(4);
        // play
        Player player = new Player(dice , 3);
        assertEquals(true, player.play());
    }
}