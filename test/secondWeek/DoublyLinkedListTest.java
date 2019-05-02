package secondWeek;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoublyLinkedListTest {

    DoublyLinkedList dll;

    @Before
    public void setup() {
        dll = new DoublyLinkedList();
    }

    @Test
    public void getLastTest() {
        dll.push(1);
        dll.push(2);
        dll.push(3);
        assertEquals(3, dll.getLength());
        assertEquals(3, dll.getLast());
        dll.removeLast();
        assertEquals(2, dll.getLast());
    }
}