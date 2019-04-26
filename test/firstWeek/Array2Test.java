package firstWeek;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Array2Test {

    Array2 array2;

    @Before
    public void setup() {
        array2 = new Array2();
    }

    @Test
    public void int2StrTest() {
        String input = "I am a boy";
        assertEquals("boy a am I", array2.reverseStr(input));
    }

    @Test
    public void indexOfTest() {
        String input = "i am a";
        assertEquals(1, input.indexOf(" "));
    }
}