package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void testGetFamily(){

        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testEatMeat() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void testGetKittens(){
        int expectedKittens = 7;
        Mockito.when(feline.getKittens(Mockito.anyInt())).thenReturn(expectedKittens);

        int actualKittens = feline.getKittens();
        Mockito.verify(feline).getKittens(1);
        assertEquals(expectedKittens,actualKittens);
    }
}
