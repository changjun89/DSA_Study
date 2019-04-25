package firstWeek;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Array1Test {

    Array1 array1;

    @Before
    public void setup() {
        array1 = new Array1();
    }

    @Test
    public void int2StrTest() {
        int input =123;
        assertEquals(array1.int2Str(input),"123");

    }

}
