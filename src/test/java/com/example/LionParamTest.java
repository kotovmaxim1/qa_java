package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParamTest {

    private final String sex;
    private final boolean expected;
    Feline feline;

    public LionParamTest(String sex, boolean expected){
        this.sex = sex;
        this.expected = expected;
    }

    @Before
    public void init(){
        feline = new Feline();
        MockitoAnnotations.initMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] testLionData(){
        return new Object[][]{
                {"Самец", true},
                {"Самка",false}
        };
    }

    @Test
    public void testDoesHasMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(expected, lion.doesHaveMane());
    }
}
