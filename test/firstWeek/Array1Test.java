package firstWeek;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Array1Test {

    Array1 array1;

    @Before
    public void setup() {
        array1 = new Array1();
    }

    @Test
    public void int2StrTest() {
        //assertEquals(array1.int2Str(123),"123");
        assertEquals(array1.int2Str(12), "12");
        assertEquals(array1.int2Str(0), "0");
        assertEquals(array1.int2Str(-123), "123");
    }

    @Test
    public void digitLIstTest() {
        int input = 123;
        List<Integer> result = new ArrayList<>();
        result.add(3);
        result.add(2);
        result.add(1);
        assertEquals(result, array1.digitList(input));
    }

    @Test
    public void digitStringTest() {
        List<Integer> input = new ArrayList<>();
        input.add(3);
        input.add(2);
        input.add(1);
        assertEquals("123", array1.digitString(input));
    }


}

