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
        assertEquals(array2.reverseStr(input),"boy a am I");

    }

}