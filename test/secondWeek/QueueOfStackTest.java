package secondWeek;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class QueueOfStackTest {

    QueueOfStack qos;

    @Before
    public void setup() {
        qos = new QueueOfStack();
    }

    @Test
    public void dequeTest() {
        qos.enqueue(1);
        qos.enqueue(2);
        qos.enqueue(3);
        assertEquals(1, qos.dequeue());
        assertEquals(2, qos.dequeue());
        qos.enqueue(4);
        qos.enqueue(5);
        assertEquals(3, qos.dequeue());
        assertEquals(4, qos.dequeue());
        assertEquals(5, qos.dequeue());
    }

}