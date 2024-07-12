package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void testGetKittens() {
        Lion lion = new Lion(feline);
        int kittensFromMock = 10;
        Mockito.when(feline.getKittens()).thenReturn(kittensFromMock);
        assertEquals(kittensFromMock, lion.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion(feline);
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedList);
        assertEquals(expectedList, lion.getFood());
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test(expected = Exception.class)
    public void testDoesHasManeException() throws Exception {
        Lion lion = new Lion("Небинарная личность");
    }
}
