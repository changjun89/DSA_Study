package secondWeek;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoublyLinkedListStackTest {

    DoublyLinkedListStack dll;

    @Before
    public void setup() {
        dll = new DoublyLinkedListStack();
    }

    @Test
    public void pushAndPopTest() {
        dll.push(1);
        dll.push(2);
        dll.push(3);
        assertEquals(3, dll.pop());
        assertEquals(2, dll.pop());
        dll.push(4);
        dll.push(5);
        assertEquals(5, dll.pop());
        assertEquals(4, dll.pop());
    }
}